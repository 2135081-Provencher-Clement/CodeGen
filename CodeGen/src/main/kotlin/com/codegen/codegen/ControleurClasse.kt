package com.codegen.codegen

import com.codegen.codegen.composants.Methode
import com.codegen.codegen.composants.Parametre
import com.codegen.codegen.composants.Propriete
import com.codegen.codegen.composants.Visibilite
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.ComboBox
import javafx.scene.layout.VBox

/**
 *  Classe du contrôleur pour afficher la classe.
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class ControleurClasse : VBox() {
    /**
     * Variables des composants de la classe
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @FXML
    private var visibiliteClasse: ComboBox<String> = ComboBox<String>()
    @FXML
    private var motCleClasse: ComboBox<String> = ComboBox<String>()
    @FXML
    private var conteneurPropriete: VBox = VBox()
    @FXML
    private var conteneurConstructeur: VBox = VBox()
    @FXML
    private var contenueurMethode: VBox = VBox()
    init {
        var propriete1 = Propriete(Visibilite.private, "string", "nom")
        var propriete2 = Propriete(Visibilite.public, "string", "prenom")
        var proprieteControleur1 = ControleurPropriete(propriete1)
        var proprieteControleur2 = ControleurPropriete(propriete2)
        var listePropriete = mutableListOf<ControleurPropriete>(proprieteControleur1, proprieteControleur2)
        var param1 = Parametre("string", "nom1");
        var param2 = Parametre("string", "nom2");
        var liste = mutableListOf<Parametre>(param1, param2);
        var uneMethode = Methode(Visibilite.private, "string", "FaireQQch", liste)
        var methode2 = Methode(Visibilite.private, "string", "FaireQQch", liste)
        var methodeControleur = ControleurMethode(uneMethode)
        var methodeControleur2 = ControleurMethode(methode2)
        var listeMethode = mutableListOf<ControleurMethode>(methodeControleur, methodeControleur2)

        //load FXML file, and set CustomControl as root and controller
        FXMLLoader(javaClass.getResource("afficher-classe.fxml")).apply {
            //"this" point to FXMLLoader,but we need set CustomControl as root and controller,so,use this@CustomControl
            setRoot(this@ControleurClasse)
            setController(this@ControleurClasse)
            load()
        }
        for (propriete in listePropriete) {
            conteneurPropriete.children.add(propriete)
        }
        for (methode in listeMethode) {
            contenueurMethode.children.add(methode)
        }
        visibiliteClasse.items = FXCollections.observableArrayList(
            listOf("public", "protected")
        )
        // SelectionModel pointe sur les éléments qui sont sélectionnés
        visibiliteClasse.selectionModel.select("public")
        motCleClasse.items = FXCollections.observableArrayList(
            listOf("classique", "sealed", "abstract", "static")
        )
        // SelectionModel pointe sur les éléments qui sont sélectionnés
        motCleClasse.selectionModel.select("classique")
    }
}
