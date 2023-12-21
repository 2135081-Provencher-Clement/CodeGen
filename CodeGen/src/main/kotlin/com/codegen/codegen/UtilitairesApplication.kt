package com.codegen.codegen

import javafx.fxml.FXML
import javafx.scene.control.TextInputDialog
import javafx.stage.FileChooser

public class UtilitairesApplication {

    public fun surChoisirItemDansTreeView() {

        println("Choisir un item dans le TreeView")
    }

    /**
     * Fonction pour créer un nouveau projet
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    public fun surCreerProjet() { //TODO: Faire fonctionner, enregistrer le projet lors de la création d'un nouveau?
        val dialogue = TextInputDialog("Nom du projet")
        dialogue.headerText = "Créer un nouveau projet"
        dialogue.contentText = "Nom du projet :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nomProjet = resultat.get()
        }
    }

    /**
     * Fonction pour ouvrir un projet existant
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
//    @FXML
//    public fun surOuvrirProjet() {
//        val selecteurFichier = FileChooser()
//        selecteurFichier.title = "Sélectionnez un projet"
//        //val fichierSelectionne = selecteurFichier.showOpenDialog(texteBienvenue.scene.window)
//        //if (fichierSelectionne != null) {
//        //val cheminProjet = fichierSelectionne.absolutePath
//        // Ouvrez le projet situé à cheminProjet
//    }

    /**
     * Fonction pour ouvrir la fenêtre pour renommer une classe
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
//    @FXML
//    public fun surRenommerClasse() {
//        val dialog = TextInputDialog("Nouveau nom de la classe")
//        dialog.title = "Renommer la classe"
//        dialog.headerText = "Renommer la classe"
//        dialog.contentText = "Entrez le nouveau nom de la classe :"
//        val result = dialog.showAndWait()
//        if (result.isPresent) {
//            val nouveauNomClasse = result.get()
//            classe.nom = nouveauNomClasse
//            nomClasse.text = nouveauNomClasse
//        }
//    }

    /**
     * Fonction pour ouvrir la fenêtre pour renommer un projet
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
//    @FXML
//    public fun surRenommerProjet() {
//        val dialogue = TextInputDialog("Nouveau nom de projet")
//        dialogue.headerText = "Renommer le projet"
//        dialogue.contentText = "Nouveau nom de projet"
//        val resultat = dialogue.showAndWait()
//        if (resultat.isPresent) {
//            val nouveauNomProjet = resultat.get()
//            initialiserNomDuProjet(nouveauNomProjet)
//        }
//    }
}
