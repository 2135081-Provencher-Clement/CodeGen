package com.codegen.codegen.serializerPersonnalisee.composants

import com.codegen.codegen.composants.Methode
import com.codegen.codegen.composants.Parametre
import com.codegen.codegen.composants.Visibilite
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

/**
 *  Tests pour la classe MethodeSerializer
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestMethodeSerializer {
    private lateinit var methode: Methode

    /**
     *  Cette fonction s'exécute avant chaque fonction de test
     *  Elle initialize les composants necessaires aux tests
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @BeforeEach
    fun initalize() {
        val liste = listOf(Parametre("string", "nom"))
        methode = Methode(Visibilite.public, "void", "FaireQQch", liste,false)
    }

    /**
     *  Test si le sérializeur transforme l'objet Methode en un bon string
     *  Test aussi si le desérializement redonne les bonnes informations
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementSerialization() {
        val methodeSerialize = Json.encodeToString(MethodeSerializer, methode)
        val valeurAttendue = "{\"visibilite\":\"public\",\"typeRetour\":\"void\",\"nom\":\"FaireQQch\",\"parametres\":[{\"type\":\"string\",\"nom\":\"nom\"}],\"virtuelle\":false}"
        assertEquals(valeurAttendue, methodeSerialize, "Devrait être la même valeur")
        val methodeDeserialize = Json.decodeFromString(MethodeSerializer, methodeSerialize)
        assertNotEquals(methode, methodeDeserialize, "Ne devrait pas être la même instance")
        assertEquals(methode.nom, methodeDeserialize.nom, "Les deux devraient être pareils")
        assertEquals(methode.typeRetour, methodeDeserialize.typeRetour, "Les deux devraient être pareils")
        assertEquals(methode.visibilite, methodeDeserialize.visibilite, "Les deux devraient être pareils")
        assertEquals(methode.virtuelle, methodeDeserialize.virtuelle, "Les deux devraient être pareils")
        assertEquals(methode.parametres.size, methodeDeserialize.parametres.size, "Les deux devraient être pareils")
    }
}
