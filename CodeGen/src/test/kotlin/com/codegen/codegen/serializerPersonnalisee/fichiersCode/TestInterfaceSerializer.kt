package com.codegen.codegen.serializerPersonnalisee.fichiersCode

import com.codegen.codegen.composants.*
import com.codegen.codegen.fichiersCode.Interface
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

/**
 *  Tests pour la classe InterfaceSerializer
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestInterfaceSerializer {
    private lateinit var uneInterface: Interface

    /**
     *  Cette fonction s'exécute avant chaque fonction de test
     *  Elle initialize les composants necessaires aux tests
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @BeforeEach
    fun initalize() {
        val listePropriete = listOf(Propriete(Visibilite.public,"string", "nom"))
        val listeParametreMethode = listOf(Parametre("string", "nom"))
        val listeMethode = listOf(Methode(Visibilite.public, "void", "FaireQQch", listeParametreMethode, true))
        uneInterface = Interface(Visibilite.public, "IBouger", listePropriete, listeMethode)
    }

    /**
     *  Test si le sérializeur transforme l'objet Interface en un bon string
     *  Test aussi si le desérializement redonne les bonnes informations
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementSerialization() {
        val interfaceSerialize = Json.encodeToString(InterfaceSerializer, uneInterface)
        val valeurAttendue = "{\"visibilite\":\"public\",\"nom\":\"IBouger\",\"proprietes\":[{\"visibilite\":\"public\",\"type\":\"string\",\"nom\":\"nom\"}],\"methodes\":[{\"visibilite\":\"public\",\"typeRetour\":\"void\",\"nom\":\"FaireQQch\",\"parametres\":[{\"type\":\"string\",\"nom\":\"nom\"}],\"virtuelle\":true}]}"
        assertEquals(valeurAttendue, interfaceSerialize, "Devrait être la même valeur")
        val interfaceDeserialize = Json.decodeFromString(InterfaceSerializer, interfaceSerialize)
        assertNotEquals(uneInterface, interfaceDeserialize, "Ne devrait pas être la même instance")
        assertEquals(uneInterface.visibilite, interfaceDeserialize.visibilite, "Les deux devraient être pareils")
        assertEquals(uneInterface.nom, interfaceDeserialize.nom, "Les deux devraient être pareils")
        assertEquals(uneInterface.proprietes.size, interfaceDeserialize.proprietes.size, "Les deux devraient être pareils")
        assertEquals(uneInterface.methodes.size, interfaceDeserialize.methodes.size, "Les deux devraient être pareils")
    }
}
