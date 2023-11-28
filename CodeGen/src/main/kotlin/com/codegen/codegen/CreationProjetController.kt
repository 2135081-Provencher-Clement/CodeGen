// Fichier CreationProjetController.kt

/*
    codé en partie à l'aide de Chat-GPT
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

    @FXML
    fun initialize() {
        labelBienvenue.text = "Bienvenue dans CodeGen !"
    }

    @FXML
    private fun onNouveauProjetClick() {
        val dialog = TextInputDialog()
        dialog.title = "Nouveau Projet"
        dialog.headerText = "Créer un nouveau projet"
        dialog.contentText = "Entrez le nom du projet :"

        val result = dialog.showAndWait()

        result.ifPresent { nomProjet ->
            // Charger la vue du nouveau projet
            val fxmlLoader = FXMLLoader(CreationProjet::class.java.getResource("principale-view.fxml"))
            val nouvelleScene = Scene(fxmlLoader.load(), 800.0, 800.0)

            // Récupérer le contrôleur et passer le nom du projet
            val controller = fxmlLoader.getController<PrincipaleControleur>()
            controller.initialiserNomDuProjet(nomProjet)

            // Afficher la nouvelle vue
            val stageActuel = boutonNouveauProjet.scene.window as Stage
            stageActuel.scene = nouvelleScene
        }
    }


    // Cette méthode est pour le bouton "Ouvrir un projet existant", vide pour l'instant
    @FXML
    private fun onOuvrirProjetClick() {
        // Logique pour ouvrir un projet existant
    }
}
