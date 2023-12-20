package com.codegen.codegen.serializerPersonnalisee.composants

import com.codegen.codegen.composants.*
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

/**
 *  Tests pour la classe ConstructeurSerializer
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestConstructeurSerializer {
    private lateinit var constructeur: Constructeur

    /**
     *  Cette fonction s'exécute avant chaque fonction de test
     *  Elle initialize les composants necessaires aux tests
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @BeforeEach
    fun initalize() {
        val liste = listOf(Propriete(Visibilite.public,"string", "nom"))
        constructeur = Constructeur(Visibilite.public, liste)
    }

    /**
     *  Test si le sérializeur transforme l'objet Constructeur en un bon string
     *  Test aussi si le desérializement redonne les bonnes informations
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementSerialization() {
        val constructeurSerialize = Json.encodeToString(ConstructeurSerializer, constructeur)
        val valeurAttendue = "{\"visibilite\":\"public\",\"proprietes\":[{\"visibilite\":\"public\",\"type\":\"string\",\"nom\":\"nom\"}]}"
        assertEquals(valeurAttendue, constructeurSerialize, "Devrait être la même valeur")
        val constructeurDeserialize = Json.decodeFromString(ConstructeurSerializer, constructeurSerialize)
        assertNotEquals(constructeur, constructeurDeserialize, "Ne devrait pas être la même instance")
        assertEquals(constructeur.visibilite, constructeurDeserialize.visibilite, "Les deux devraient être pareils")
        assertEquals(constructeur.proprietes.size, constructeurDeserialize.proprietes.size, "Les deux devraient être pareils")
    }
}
