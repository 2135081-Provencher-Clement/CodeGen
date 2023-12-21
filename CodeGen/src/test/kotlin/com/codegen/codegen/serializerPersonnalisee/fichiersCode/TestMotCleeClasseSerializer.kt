package com.codegen.codegen.serializerPersonnalisee.fichiersCode

import com.codegen.codegen.fichiersCode.MotCleeClasse
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

/**
 *  Tests pour la classe MotCleeClasseSerializer
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestMotCleeClasseSerializer {
    private lateinit var motCleeClasse: MotCleeClasse

    /**
     *  Cette fonction s'exécute avant chaque fonction de test
     *  Elle initialize les composants necessaires aux tests
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @BeforeEach
    fun initalize() {
        motCleeClasse = MotCleeClasse.abstract
    }

    /**
     *  Test si le sérializeur transforme l'objet MotCleeClasse en un bon string
     *  Test aussi si le desérializement redonne les bonnes informations
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementSerialization() {
        val motCleeClasseSerialize = Json.encodeToString(MotCleeClasseSerializer, motCleeClasse)
        val valeurAttendue = "\"abstract\""
        assertEquals(valeurAttendue, motCleeClasseSerialize, "Devrait être la même valeur")
        val motCleeClasseDeserialize = Json.decodeFromString(MotCleeClasseSerializer, motCleeClasseSerialize)
        assertEquals(motCleeClasse.name, motCleeClasseDeserialize.name, "Les deux devraient être pareils")
    }
}
