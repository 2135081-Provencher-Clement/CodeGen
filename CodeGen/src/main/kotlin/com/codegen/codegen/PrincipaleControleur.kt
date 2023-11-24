package com.codegen.codegen

/**
 *  Classe du contrôleur de l'application principale.
 *  @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
 *  Code partiellement généré par: OpenAi. (2023). ChatGPT (version 10 novembre 2023) [Modèle massif de langage]. https://chat.openai.com/chat
 */

import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.stage.FileChooser
import javafx.stage.Stage

class PrincipaleControleur {
    @FXML
    private lateinit var menuItemFermerFenetre: MenuItem

    @FXML
    private fun initialize() {
        // Associer l'action de fermeture à l'item du menu "Fermer la fenêtre"
        menuItemFermerFenetre.setOnAction {
            surFermerFenetre()
        }
    }

    @FXML
    private fun surFermerFenetre() {
        Platform.exit()
    }

    @FXML
    private fun surCreerProjet() {
        // Code pour créer un nouveau projet
        val dialogue = TextInputDialog("Nom du projet")
        dialogue.headerText = "Créer un nouveau projet"
        dialogue.contentText = "Nom du projet :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nomProjet = resultat.get()
            // Créez le projet avec le nom nomProjet
        }
    }

    @FXML
    private fun surOuvrirProjet() {
        // Code pour ouvrir un projet existant
        // Exemple : Afficher une boîte de dialogue de sélection de projet
        val selecteurFichier = FileChooser()
        selecteurFichier.title = "Sélectionnez un projet"
        //val fichierSelectionne = selecteurFichier.showOpenDialog(texteBienvenue.scene.window)
        //if (fichierSelectionne != null) {
        //val cheminProjet = fichierSelectionne.absolutePath
        // Ouvrez le projet situé à cheminProjet
    }

    @FXML
    private fun surParametres() {
        // Ouvrir une fenêtre de paramètres
        // Exemple : Afficher une fenêtre de paramètres personnalisée
        val stageParametres = Stage()
        val chargeurParametres = FXMLLoader(CodeGenApplication::class.java.getResource("vue-parametres.fxml"))
        val racineParametres = chargeurParametres.load<Parent>()
        stageParametres.scene = Scene(racineParametres)
        stageParametres.title = "Paramètres"
        stageParametres.show()
    }

    @FXML
    private fun surRenommer() {
        // Code pour renommer une classe
        // Exemple : Afficher une boîte de dialogue pour permettre à l'utilisateur de renommer une classe
        val dialogue = TextInputDialog("Nouveau nom de classe")
        dialogue.headerText = "Renommer la classe"
        dialogue.contentText = "Nouveau nom de classe :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nouveauNomClasse = resultat.get()
            // Renommez la classe en utilisant le nouveau nom nouveauNomClasse
        }
    }

    @FXML
    private fun surAjouterImplementation() {
        // Code pour ajouter une implémentation à une classe
        // Exemple : Afficher une boîte de dialogue pour permettre à l'utilisateur d'ajouter une implémentation
        val dialogue = TextInputDialog("Nom de l'interface à implémenter")
        dialogue.headerText = "Ajouter une implémentation"
        dialogue.contentText = "Nom de l'interface à implémenter :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nomInterface = resultat.get()
            // Ajoutez l'implémentation de l'interface nomInterface à la classe
        }
    }

    @FXML
    private fun surAjouterHeritage() {
        // Code pour ajouter un héritage à une classe
        // Exemple : Afficher une boîte de dialogue pour permettre à l'utilisateur d'ajouter un héritage
        val dialogue = TextInputDialog("Nom de la classe parente")
        dialogue.headerText = "Ajouter un héritage"
        dialogue.contentText = "Nom de la classe parente :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nomClasseParente = resultat.get()
            // Ajoutez l'héritage de la classe parente nomClasseParente à la classe
        }
    }

//    @FXML
//    private fun surExporterClasse() {
//        // Code pour exporter une classe
//        // Exemple : Afficher une boîte de dialogue pour permettre à l'utilisateur de choisir un emplacement d'export
//        val selecteurFichier = FileChooser()
//        selecteurFichier.title = "Choisissez un emplacement pour l'export de la classe"
//        selecteurFichier.extensionFilters.add(
//            FileChooser.ExtensionFilter("Fichiers Java", "*.java")
//        )
//        val fichierSelectionne = selecteurFichier.showSaveDialog(texteBienvenue.scene.window)
//        if (fichierSelectionne != null) {
//            val cheminExportClasse = fichierSelectionne.absolutePath
//            // Exportez la classe vers le chemin cheminExportClasse
//        }
//    }

    @FXML
    private fun surSupprimerClasse() {
        // Code pour supprimer une classe
        // Exemple : Afficher une boîte de dialogue de confirmation de suppression
        val alerte = Alert(Alert.AlertType.CONFIRMATION)
        alerte.title = "Confirmation de suppression"
        alerte.headerText = "Êtes-vous sûr de vouloir supprimer cette classe ?"
        val resultat = alerte.showAndWait()
        if (resultat.isPresent && resultat.get() == ButtonType.OK) {
            // Supprimez la classe
        }
    }

    @FXML
    private fun surAjouterClasse() {
        // Code pour ajouter une nouvelle classe
        // Exemple : Afficher une boîte de dialogue pour permettre à l'utilisateur d'ajouter une nouvelle classe
        val dialogue = TextInputDialog("Nom de la nouvelle classe")
        dialogue.headerText = "Ajouter une nouvelle classe"
        dialogue.contentText = "Nom de la nouvelle classe :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nouveauNomClasse = resultat.get()
            // Ajoutez la nouvelle classe avec le nom nouveauNomClasse
        }
    }

    @FXML
    private fun surAjouterInterface() {
        // Code pour ajouter une nouvelle interface
        // Exemple : Afficher une boîte de dialogue pour permettre à l'utilisateur d'ajouter une nouvelle interface
        val dialogue = TextInputDialog("Nom de la nouvelle interface")
        dialogue.headerText = "Ajouter une nouvelle interface"
        dialogue.contentText = "Nom de la nouvelle interface :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nouveauNomInterface = resultat.get()
            // Ajoutez le nouvel interface avec le nom nouveauNomInterface
        }
    }
}
