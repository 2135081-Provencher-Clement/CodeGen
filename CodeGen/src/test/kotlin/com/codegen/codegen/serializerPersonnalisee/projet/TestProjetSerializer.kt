package com.codegen.codegen.serializerPersonnalisee.projet

import com.codegen.codegen.composants.*
import com.codegen.codegen.fichiersCode.Classe
import com.codegen.codegen.fichiersCode.Interface
import com.codegen.codegen.fichiersCode.MotCleeClasse
import com.codegen.codegen.projet.Projet
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import java.util.*

/**
 *  Tests pour la classe ProjetSerializer
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestProjetSerializer {
    private lateinit var projet: Projet

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
        val stringUUID = "STRING_DE_TEST_POUR_UUID"
        projet = Projet(UUID.nameUUIDFromBytes(stringUUID.toByteArray()), "projet-ferme",listeClasse, listeInterface)
    }

    /**
     *  Test si le sérializeur transforme l'objet Projet en un bon string
     *  Test aussi si le desérializement redonne les bonnes informations
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementSerialization() {
        val projetSerialize = Json.encodeToString(ProjetSerializer, projet)
        val valeurAttendue = "{\"uuid\":\"985e7e50-d2dd-36b2-9b3f-f88c4ee7b4fc\",\"nom\":\"projet-ferme\",\"classes\":[{\"visibilite\":\"public\",\"nom\":\"Chien\",\"motCleeClasse\":\"classique\",\"proprietes\":[{\"visibilite\":\"public\",\"type\":\"string\",\"nom\":\"nom\"}],\"methodes\":[{\"visibilite\":\"public\",\"typeRetour\":\"void\",\"nom\":\"FaireQQch\",\"parametres\":[{\"type\":\"string\",\"nom\":\"nom\"}],\"virtuelle\":true}],\"constructeurs\":[{\"visibilite\":\"public\",\"proprietes\":[{\"visibilite\":\"public\",\"type\":\"string\",\"nom\":\"nom\"}]}]}],\"interfaces\":[{\"visibilite\":\"public\",\"nom\":\"IManger\",\"proprietes\":[{\"visibilite\":\"public\",\"type\":\"string\",\"nom\":\"nom\"}],\"methodes\":[{\"visibilite\":\"public\",\"typeRetour\":\"void\",\"nom\":\"FaireQQch\",\"parametres\":[{\"type\":\"string\",\"nom\":\"nom\"}],\"virtuelle\":true}]}]}"
        assertEquals(valeurAttendue, projetSerialize, "Devrait être la même valeur")
        val projetDeserialize = Json.decodeFromString(ProjetSerializer, projetSerialize)
        assertNotEquals(projet, projetDeserialize, "Ne devrait pas être la même instance")
        assertEquals(projet.uuid, projetDeserialize.uuid, "Les deux devraient être pareils")
        assertEquals(projet.nom, projetDeserialize.nom, "Les deux devraient être pareils")
        assertEquals(projet.classes.size, projetDeserialize.classes.size, "Les deux devraient être pareils")
        assertEquals(projet.interfaces.size, projetDeserialize.interfaces.size, "Les deux devraient être pareils")
    }
}
