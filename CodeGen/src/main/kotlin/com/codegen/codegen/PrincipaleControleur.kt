package com.codegen.codegen

import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.stage.FileChooser
import javafx.stage.Stage

/**
 *  Classe du contrôleur de l'interface principale.
 *
 *  @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
 *  Code partiellement généré par: OpenAi. (2023). ChatGPT (version 10 novembre 2023) [Modèle massif de langage]. https://chat.openai.com/chat
 */
class PrincipaleControleur {

    /**
     * Variables de l'application
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private lateinit var menuItemFermerFenetre: MenuItem
    @FXML
    private lateinit var menuItemCreerProjet: MenuItem
    @FXML
    private lateinit var menuItemOuvrirProjet: MenuItem
    @FXML
    private lateinit var menuItemExporterProjet: MenuItem
    @FXML
    private lateinit var menuItemParametres: MenuItem
    @FXML
    private lateinit var menuItemRenommerClasse: MenuItem
    @FXML
    private lateinit var menuItemAjouterImplementation: MenuItem
    @FXML
    private lateinit var menuItemAjouterHeritage: MenuItem
    @FXML
    private lateinit var menuItemExporterClasse: MenuItem
    @FXML
    private lateinit var menuItemSupprimerClasse: MenuItem
    @FXML
    private lateinit var menuItemAjouterClasse: MenuItem
    @FXML
    private lateinit var menuItemAjouterInterface: MenuItem

    /**
     * Fonction d'initialisation des composants
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun initialize() {
        menuItemFermerFenetre.setOnAction {
            surFermerFenetre()
        }
        menuItemCreerProjet.setOnAction {
            surCreerProjet()
        }
        menuItemOuvrirProjet.setOnAction {
            surOuvrirProjet()
        }
        menuItemParametres.setOnAction {
            surParametres()
        }
        menuItemAjouterImplementation.setOnAction {
            surAjouterImplementation()
        }
        menuItemAjouterHeritage.setOnAction {
            surAjouterHeritage()
        }
//        menuItemExporterClasse.setOnAction {
//            surExporterClasse()
//        }
//        menuItemExporterClasse.setOnAction {
//            surExporterProjet()
//        }
        menuItemSupprimerClasse.setOnAction {
            surSupprimerClasse()
        }
        menuItemAjouterClasse.setOnAction {
            surAjouterClasse()
        }
        menuItemAjouterInterface.setOnAction {
            surAjouterClasse()
        }
    }

    /**
     * Fonction pour fermer l'application
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surFermerFenetre() {
        Platform.exit()
    }

    /**
     * Fonction pour créer un nouveau projet
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surCreerProjet() {
        val dialogue = TextInputDialog("Nom du projet")
        dialogue.headerText = "Créer un nouveau projet"
        dialogue.contentText = "Nom du projet :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nomProjet = resultat.get()
            // Créez le projet avec le nom nomProjet
        }
    }

    /**
     * Fonction pour ouvrir un projet existant
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surOuvrirProjet() {
        val selecteurFichier = FileChooser()
        selecteurFichier.title = "Sélectionnez un projet"
        //val fichierSelectionne = selecteurFichier.showOpenDialog(texteBienvenue.scene.window)
        //if (fichierSelectionne != null) {
        //val cheminProjet = fichierSelectionne.absolutePath
        // Ouvrez le projet situé à cheminProjet
    }

    /**
     * Fonction pour ouvrir la fenêtre de paramètres
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surParametres() {
        val stageParametres = Stage()
        val chargeurParametres = FXMLLoader(CodeGenApplication::class.java.getResource("vue-parametres.fxml"))
        val racineParametres = chargeurParametres.load<Parent>()
        stageParametres.scene = Scene(racineParametres)
        stageParametres.title = "Paramètres"
        stageParametres.show()
    }

    /**
     * Fonction pour ouvrir la fenêtre pour renommer une classe
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surRenommer() {
        val dialogue = TextInputDialog("Nouveau nom de classe")
        dialogue.headerText = "Renommer la classe"
        dialogue.contentText = "Nouveau nom de classe :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nouveauNomClasse = resultat.get()
            // Renommez la classe en utilisant le nouveau nom nouveauNomClasse
        }
    }

    /**
     * Fonction pour ouvrir la fenêtre pour implémenter un interface à la classe
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surAjouterImplementation() {
        val dialogue = TextInputDialog("Nom de l'interface à implémenter")
        dialogue.headerText = "Ajouter une implémentation"
        dialogue.contentText = "Nom de l'interface à implémenter :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nomInterface = resultat.get()
            // Ajoutez l'implémentation de l'interface nomInterface à la classe
        }
    }

    /**
     * Fonction pour ouvrir la fenêtre pour ajouter un héritage à la classe
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surAjouterHeritage() {
        val dialogue = TextInputDialog("Nom de la classe parente")
        dialogue.headerText = "Ajouter un héritage"
        dialogue.contentText = "Nom de la classe parente :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nomClasseParente = resultat.get()
            // Ajoutez l'héritage de la classe parente nomClasseParente à la classe
        }
    }

    /**
     * Fonction pour ouvrir la fenêtre d'exportation d'une classe
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
//    @FXML
//    private fun surExporterClasse() {
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

    /**
     * Fonction pour la suppression d'une classe
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
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

    /**
     * Fonction pour l'ouverture de la fenêtre de création d'une classe au projet
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surAjouterClasse() {
        val dialogue = TextInputDialog("Nom de la nouvelle classe")
        dialogue.headerText = "Ajouter une nouvelle classe"
        dialogue.contentText = "Nom de la nouvelle classe :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nouveauNomClasse = resultat.get()
            // Ajoutez la nouvelle classe avec le nom nouveauNomClasse
        }
    }

    /**
     * Fonction pour l'ouverture de la fenêtre de création d'un interface au projet
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surAjouterInterface() {
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
