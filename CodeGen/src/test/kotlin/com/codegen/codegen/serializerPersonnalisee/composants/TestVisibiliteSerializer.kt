package com.codegen.codegen.serializerPersonnalisee.composants

import com.codegen.codegen.composants.Visibilite
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

/**
 *  Tests pour la classe VisibiliteSerializer
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestVisibiliteSerializer {
    private lateinit var visibilite: Visibilite

    /**
     *  Cette fonction s'exécute avant chaque fonction de test
     *  Elle initialize les composants necessaires aux tests
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @BeforeEach
    fun initalize() {
        visibilite = Visibilite.public
    }

    /**
     *  Test si le sérializeur transforme l'objet Visibilite en un bon string
     *  Test aussi si le desérializement redonne les bonnes informations
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementSerialization() {
        val visibiliteSerialize = Json.encodeToString(VisibiliteSerializer, visibilite)
        val valeurAttendue = "\"public\""
        assertEquals(valeurAttendue, visibiliteSerialize, "Devrait être la même valeur")
        val visibiliteDeserialize = Json.decodeFromString(VisibiliteSerializer, visibiliteSerialize)
        assertEquals(visibilite.name, visibiliteDeserialize.name, "Les deux devraient être pareils")
    }
}
