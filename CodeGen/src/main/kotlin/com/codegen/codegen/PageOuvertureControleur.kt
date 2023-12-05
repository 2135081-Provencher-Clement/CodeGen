// Fichier PageOuvertureControleur.kt

/*
   * Code partiellement généré par: OpenAi. (2023). ChatGPT (version 10 novembre 2023) [Modèle massif de langage]. https://chat.openai.com/chat
   * Auteur: Francis Payan - 2131102@etudiant.cegepvicto.ca
 */

package com.codegen.codegen

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextInputDialog
import javafx.stage.Stage

class PageOuvertureControleur {

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
            val chargeurFXML = FXMLLoader(CodeGenApplication::class.java.getResource("principale-view.fxml"))
            val nouvelleScene = Scene(chargeurFXML.load(), 800.0, 800.0)

            // Récupérer le contrôleur et passer le nom du projet
            val controleur = chargeurFXML.getController<PrincipaleControleur>()
            controleur.initialiserNomDuProjet(nomProjet)

            // Afficher la nouvelle vue
            val sceneActuelle = boutonNouveauProjet.scene.window as Stage
            sceneActuelle.scene = nouvelleScene
        }
    }

    /**
     * Gère l'action de cliquer sur le bouton "Ouvrir un projet existant".
     */
    @FXML
    private fun cliquerSurOuvrirProjet() {
        // Logique pour ouvrir un projet existant
    }
}
