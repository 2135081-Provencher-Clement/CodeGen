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

class CreationProjetController {

    @FXML
    private lateinit var labelBienvenue: Label

    @FXML
    private lateinit var boutonNouveauProjet: Button

    @FXML
    private lateinit var boutonOuvrirProjet: Button

    /**
     * Affiche un message de bienvenue dans la page d'ouverture de l'application
     *
     * @author Francis Payan - 2131102@etudiant.cegepvicto.ca
     *
     * @param nomProjet Le nom du projet à afficher
     */
    @FXML
    fun initialize() {
        labelBienvenue.text = "Bienvenue dans CodeGen !"
    }

    /**
     * Cette méthode est pour le bouton "Créer un nouveau projet",
     * elle affiche une boîte de dialogue pour entrer le nom du projet et charge la vue du nouveau projet
     * avec le nom du projet entré en paramètre.
     *
     * @author Francis Payan - 2131102@etudiant.cegepvicto.ca
     *
     * @param nomProjet Le nom du projet à afficher
     */
    @FXML
    private fun onNouveauProjetClick() {
        val dialog = TextInputDialog()
        dialog.title = "Nouveau Projet"
        dialog.headerText = "Créer un nouveau projet"
        dialog.contentText = "Entrez le nom du projet :"

        val result = dialog.showAndWait()

        result.ifPresent { nomProjet ->
            // Charger la vue du nouveau projet
            val fxmlLoader = FXMLLoader(CodeGenApplication::class.java.getResource("principale-view.fxml"))
            val nouvelleScene = Scene(fxmlLoader.load(), 800.0, 800.0)

            // Récupérer le contrôleur et passer le nom du projet
            val controller = fxmlLoader.getController<PrincipaleControleur>()
            controller.initialiserNomDuProjet(nomProjet)

            // Afficher la nouvelle vue
            val stageActuel = boutonNouveauProjet.scene.window as Stage
            stageActuel.scene = nouvelleScene
        }
    }


    // Cette méthode est pour le bouton "Ouvrir un projet existant", à compléter...
    @FXML
    private fun onOuvrirProjetClick() {
        // Logique pour ouvrir un projet existant
    }
}

