package com.codegen.codegen.serializerPersonnalisee.projet

import com.codegen.codegen.composants.*
import com.codegen.codegen.fichiersCode.Classe
import com.codegen.codegen.fichiersCode.Interface
import com.codegen.codegen.fichiersCode.MotCleeClasse
import com.codegen.codegen.projet.ListeProjet
import com.codegen.codegen.projet.Projet
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

/**
 *  Tests pour la classe ListeProjetSerializer
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestListeProjetSerializer {
    private lateinit var listeProjet: ListeProjet

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
        val listeClasse = listOf(Classe(Visibilite.public, "Chien", MotCleeClasse.classique, listePropriete, listeMethode, listeConstructeur))
        val listeInterface = listOf(Interface(Visibilite.public, "IManger", listePropriete, listeMethode))
        // Pour avoir toujours le même UUID pour les tests
        val stringUUID1 = "STRING_DE_TEST_POUR_UUID1"
        val stringUUID2 = "STRING_DE_TEST_POUR_UUID2"
        val listeProjets = listOf(Projet(UUID.nameUUIDFromBytes(stringUUID1.toByteArray()), "projet-ferme",listeClasse, listeInterface), Projet(UUID.nameUUIDFromBytes(stringUUID2.toByteArray()), "projet-ferme2",listeClasse, listeInterface))
        listeProjet = ListeProjet(listeProjets)
    }

    /**
     *  Test si le sérializeur transforme l'objet ListeProjet en un bon string
     *  Test aussi si le desérializement redonne les bonnes informations
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementSerialization() {
        val listeProjetSerialize = Json.encodeToString(ListeProjetSerializer, listeProjet)
        val valeurAttendue = "{\"listeProjets\":[{\"uuid\":\"f79b7844-1970-3c61-aa44-feb6a377d2d5\",\"nom\":\"projet-ferme\",\"classes\":[{\"visibilite\":\"public\",\"nom\":\"Chien\",\"motCleeClasse\":\"classique\",\"proprietes\":[{\"visibilite\":\"public\",\"type\":\"string\",\"nom\":\"nom\"}],\"methodes\":[{\"visibilite\":\"public\",\"typeRetour\":\"void\",\"nom\":\"FaireQQch\",\"parametres\":[{\"type\":\"string\",\"nom\":\"nom\"}],\"virtuelle\":true}],\"constructeurs\":[{\"visibilite\":\"public\",\"proprietes\":[{\"visibilite\":\"public\",\"type\":\"string\",\"nom\":\"nom\"}]}]}],\"interfaces\":[{\"visibilite\":\"public\",\"nom\":\"IManger\",\"proprietes\":[{\"visibilite\":\"public\",\"type\":\"string\",\"nom\":\"nom\"}],\"methodes\":[{\"visibilite\":\"public\",\"typeRetour\":\"void\",\"nom\":\"FaireQQch\",\"parametres\":[{\"type\":\"string\",\"nom\":\"nom\"}],\"virtuelle\":true}]}]},{\"uuid\":\"2a1cdf1e-3e5b-3ed1-833b-776c0ccc8408\",\"nom\":\"projet-ferme2\",\"classes\":[{\"visibilite\":\"public\",\"nom\":\"Chien\",\"motCleeClasse\":\"classique\",\"proprietes\":[{\"visibilite\":\"public\",\"type\":\"string\",\"nom\":\"nom\"}],\"methodes\":[{\"visibilite\":\"public\",\"typeRetour\":\"void\",\"nom\":\"FaireQQch\",\"parametres\":[{\"type\":\"string\",\"nom\":\"nom\"}],\"virtuelle\":true}],\"constructeurs\":[{\"visibilite\":\"public\",\"proprietes\":[{\"visibilite\":\"public\",\"type\":\"string\",\"nom\":\"nom\"}]}]}],\"interfaces\":[{\"visibilite\":\"public\",\"nom\":\"IManger\",\"proprietes\":[{\"visibilite\":\"public\",\"type\":\"string\",\"nom\":\"nom\"}],\"methodes\":[{\"visibilite\":\"public\",\"typeRetour\":\"void\",\"nom\":\"FaireQQch\",\"parametres\":[{\"type\":\"string\",\"nom\":\"nom\"}],\"virtuelle\":true}]}]}]}"
        assertEquals(valeurAttendue, listeProjetSerialize, "Devrait etre la meme chose")
        val listeProjetDeserialize = Json.decodeFromString(ListeProjetSerializer, listeProjetSerialize)
        assertNotEquals(listeProjet, listeProjetDeserialize, "Ne devrait pas être la même instance")
        assertEquals(listeProjet.listeProjet.size, listeProjetDeserialize.listeProjet.size, "Les deux devraient être pareils")
    }
}
