package com.codegen.codegen.serializerPersonnalisee.composants

import com.codegen.codegen.composants.Propriete
import com.codegen.codegen.composants.Visibilite
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

/**
 *  Tests pour la classe ProprieteSerializer
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestProprieteSerializer {
    private lateinit var propriete: Propriete

    /**
     *  Cette fonction s'exécute avant chaque fonction de test
     *  Elle initialize les composants necessaires aux tests
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @BeforeEach
    fun initalize() {
        propriete = Propriete(Visibilite.public, "String", "test")
    }

    /**
     *  Test si le sérializeur transforme l'objet Propriete en un bon string
     *  Test aussi si le desérializement redonne les bonnes informations
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementSerialization() {
        val proprieteSerialize = Json.encodeToString(ProprieteSerializer, propriete)
        val valeurAttendue = "{\"visibilite\":\"public\",\"type\":\"String\",\"nom\":\"test\"}"
        assertEquals(valeurAttendue, proprieteSerialize, "Devrait être la même valeur")
        val proprieteDeserialize = Json.decodeFromString(ProprieteSerializer, proprieteSerialize)
        assertNotEquals(propriete, proprieteDeserialize, "Ne devrait pas être la même instance")
        assertEquals(propriete.nom, proprieteDeserialize.nom, "Les deux devraient être pareils")
        assertEquals(propriete.visibilite, proprieteDeserialize.visibilite, "Les deux devraient être pareils")
        assertEquals(propriete.type, proprieteDeserialize.type, "Les deux devraient être pareils")
    }
}
