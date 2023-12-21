package com.codegen.codegen.serializerPersonnalisee.fichiersCode

import com.codegen.codegen.composants.*
import com.codegen.codegen.fichiersCode.Classe
import com.codegen.codegen.fichiersCode.MotCleeClasse
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

/**
 *  Tests pour la classe ClasseSerializer
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestClasseSerializer {
    private lateinit var classe: Classe

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
        val listeConstructeur = listOf(Constructeur(Visibilite.public, listePropriete))
        classe = Classe(Visibilite.public, "Chat", MotCleeClasse.classique, listePropriete, listeMethode, listeConstructeur)
    }

    /**
     *  Test si le sérializeur transforme l'objet Classe en un bon string
     *  Test aussi si le desérializement redonne les bonnes informations
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementSerialization() {
        val classeSerialize = Json.encodeToString(ClasseSerializer, classe)
        val valeurAttendue = "{\"visibilite\":\"public\",\"nom\":\"Chat\",\"motCleeClasse\":\"classique\",\"proprietes\":[{\"visibilite\":\"public\",\"type\":\"string\",\"nom\":\"nom\"}],\"methodes\":[{\"visibilite\":\"public\",\"typeRetour\":\"void\",\"nom\":\"FaireQQch\",\"parametres\":[{\"type\":\"string\",\"nom\":\"nom\"}],\"virtuelle\":true}],\"constructeurs\":[{\"visibilite\":\"public\",\"proprietes\":[{\"visibilite\":\"public\",\"type\":\"string\",\"nom\":\"nom\"}]}]}"
        assertEquals(valeurAttendue, classeSerialize, "Devrait être la même valeur")
        val classeDeserialize = Json.decodeFromString(ClasseSerializer, classeSerialize)
        assertNotEquals(classe, classeDeserialize, "Ne devrait pas être la même instance")
        assertEquals(classe.visibilite, classeDeserialize.visibilite, "Les deux devraient être pareils")
        assertEquals(classe.nom, classeDeserialize.nom, "Les deux devraient être pareils")
        assertEquals(classe.motCleeClasse, classeDeserialize.motCleeClasse, "Les deux devraient être pareils")
        assertEquals(classe.proprietes.size, classeDeserialize.proprietes.size, "Les deux devraient être pareils")
        assertEquals(classe.methodes.size, classeDeserialize.methodes.size, "Les deux devraient être pareils")
        assertEquals(classe.constructeurs.size, classeDeserialize.constructeurs.size, "Les deux devraient être pareils")
    }
}
