package com.codegen.codegen.serializerPersonnalisee.composants

import com.codegen.codegen.composants.Parametre
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

/**
 *  Tests pour la classe ParametreSerializer
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestParametreSerializer {
    private lateinit var parametre: Parametre

    /**
     *  Cette fonction s'exécute avant chaque fonction de test
     *  Elle initialize les composants necessaires aux tests
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @BeforeEach
    fun initalize() {
        parametre = Parametre("String", "test")
    }

    /**
     *  Test si le sérializeur transforme l'objet Parametre en un bon string
     *  Test aussi si le desérializement redonne les bonnes informations
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementSerialization() {
        val parametreSerialize = Json.encodeToString(ParametreSerializer, parametre)
        val valeurAttendue = "{\"type\":\"String\",\"nom\":\"test\"}"
        assertEquals(valeurAttendue, parametreSerialize, "Devrait être la même valeur")
        val parametreDeserialize = Json.decodeFromString(ParametreSerializer, parametreSerialize)
        assertNotEquals(parametre, parametreDeserialize, "Ne devrait pas être la même instance")
        assertEquals(parametre.nom, parametreDeserialize.nom, "Les deux devraient être pareils")
        assertEquals(parametre.type, parametreDeserialize.type, "Les deux devraient être pareils")
    }
}
