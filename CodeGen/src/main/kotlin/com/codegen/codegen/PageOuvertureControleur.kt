// Fichier PageOuvertureControleur.kt

package com.codegen.codegen

import com.codegen.codegen.composants.Constructeur
import com.codegen.codegen.composants.Methode
import com.codegen.codegen.composants.Propriete
import com.codegen.codegen.composants.Visibilite
import com.codegen.codegen.fichiersCode.Classe
import com.codegen.codegen.fichiersCode.Interface
import com.codegen.codegen.fichiersCode.MotCleeClasse
import com.codegen.codegen.projet.Projet
import com.codegen.codegen.serializerPersonnalisee.projet.ProjetSerializer
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextInputDialog
import javafx.stage.Stage
import kotlinx.serialization.json.Json
import java.util.*

/*
   * Classe du controleur de la page d'ouverture
   * Code partiellement généré par: OpenAi. (2023). ChatGPT (version 10 novembre 2023) [Modèle massif de langage]. https://chat.openai.com/chat
   * Auteur: Francis Payan - 2131102@etudiant.cegepvicto.ca
 */
class PageOuvertureControleur {

//    lateinit var boutonTesterGenerationJson: Button

    @FXML
    private lateinit var etiquetteBienvenue: Label

    @FXML
    private lateinit var boutonNouveauProjet: Button

    @FXML
    private lateinit var boutonOuvrirProjet: Button

    /**
     * Affiche un message de bienvenue dans la page d'ouverture de l'application.
     */
    @FXML
    fun initialiser() {
        etiquetteBienvenue.text = "Bienvenue dans CodeGen !"
    }

    /**
     * Gère l'action de cliquer sur le bouton "Nouveau Projet".
     * Affiche une boîte de dialogue pour entrer le nom du projet et charge la vue du nouveau projet.
     */
    @FXML
    private fun cliquerSurNouveauProjet() {
        val dialogue = TextInputDialog()
        dialogue.title = "Nouveau Projet"
        dialogue.headerText = "Créer un nouveau projet"
        dialogue.contentText = "Entrez le nom du projet :"

        val resultat = dialogue.showAndWait()

        resultat.ifPresent { nomProjet ->
            // Charger la vue du nouveau projet
            val chargeurFXML = FXMLLoader(CodeGenApplication::class.java.getResource("page-principale-view.fxml"))
            val nouvelleScene = Scene(chargeurFXML.load(), 800.0, 800.0)

            // Créer un projet avec une classe par défaut
            // @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
//            val premiereClasse = Classe(Visibilite.public, "Ma classe", MotCleeClasse.classique, mutableListOf(), mutableListOf(), mutableListOf())
            val nouveauProjet = Projet(nomProjet, mutableListOf(), mutableListOf())

            // Récupérer le contrôleur et passer le nom du projet
            val controleur = chargeurFXML.getController<PagePrincipaleControleur>()
            controleur.initialiserNomDuProjet(nomProjet)
            controleur.initialiserProjet(nouveauProjet)

            // Afficher la nouvelle vue
            val sceneActuelle = boutonNouveauProjet.scene.window as Stage
            sceneActuelle.scene = nouvelleScene
            sceneActuelle.isMaximized = true
        }
    }

    /**
     * Gère l'action de cliquer sur le bouton "Ouvrir un projet existant".
     */
//    @FXML
//    private fun cliquerSurOuvrirProjet() {
//        // Logique pour ouvrir un projet existant
//    }

    /**
     * Gère l'action de cliquer sur le bouton "Tester Génération JSON".
     *
     * Auteur: Francis Payan - 2131102@etudiant.cegepvicto.ca
     */
//    @FXML
//    private fun cliquerSurTesterGenerationJson() {
//        //testerGenerationFichierJson()
//        testerGenerationFichierJsonObjetProjet()
//    }

    /**
     * Fonction pour tester la génération du fichier JSON d'une liste de projets factice à partir d'un string.
     *
     * Auteur: Francis Payan - 2131102@etudiant.cegepvicto.ca
     */
//    private fun testerGenerationFichierJson() {
//        val jsonProjets = """
//            {
//                "listeProjets": [
//                    {"nom": "Projet 1", "description": "Description 1", "langage": "Kotlin"},
//                    {"nom": "Projet 2", "description": "Description 2", "langage": "C#"}
//                    // Autres projets ici
//                ]
//            }
//        """.trimIndent()
//
//        val nomFichier = "liste_projets_test.json"
//        ecrireJsonDansFichier(jsonProjets, nomFichier)
//        println("Fichier JSON généré : $nomFichier")
//    }

    /**
     * Fonction pour tester la génération du fichier JSON à partir d'un objet Projet factice.
     *
     * Auteur: Francis Payan - 2131102@etudiant.cegepvicto.ca
     * Code partiellement généré par: OpenAi. (2023). ChatGPT (version 10 novembre 2023) [Modèle massif de langage]. https://chat.openai.com/chat
     *
     */
//    private fun testerGenerationFichierJsonObjetProjet() {
//        val projetTest = creerProjetPourTest() // Crée un objet Projet factice pour le test
//        val jsonProjet = Json.encodeToString(ProjetSerializer, projetTest) // Converti l'objet Projet en JSON avec le serializer personnalisé ProjetSerializer
//
//        val nomFichier = "projet_test.json"
//        ecrireJsonDansFichier(jsonProjet, nomFichier) // Écrit les informations dans un fichier JSON
//        println("Fichier JSON généré : $nomFichier")
//    }

    /**
     * Crée un objet Projet pour le test.
     *
     * Auteur: Francis Payan - 2131102@etudiant.cegepvicto.ca
     * Code partiellement généré par: OpenAi. (2023). ChatGPT (version 10 novembre 2023) [Modèle massif de langage]. https://chat.openai.com/chat
     * @return Un objet Projet factice pour le test.
     */
//    private fun creerProjetPourTest(): Projet {
//        // Création d'exemples de propriétés, méthodes, constructeurs
//        val proprietes = listOf(Propriete(Visibilite.public, "propriete1", "String"))
//        val methodes = listOf(Methode(Visibilite.public, "methode1", "Void", listOf(), virtuelle = false))
//        val constructeurs = listOf(Constructeur(Visibilite.public, listOf()))
//
//        // Utilise le constructeur complet de Classe et Interface
//        val classes = listOf(
//            Classe(Visibilite.public, "Classe1", MotCleeClasse.classique, proprietes, methodes, constructeurs),
//            Classe(Visibilite.public, "Classe2", MotCleeClasse.classique, proprietes, methodes, constructeurs)
//        )
//        val interfaces = listOf(
//            Interface(Visibilite.public, "Interface1", proprietes, methodes),
//            Interface(Visibilite.public, "Interface2", proprietes, methodes)
//        )
//
//        return Projet(UUID.randomUUID(), "Projet Test", classes, interfaces)
//    }
}
