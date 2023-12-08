package com.codegen.codegen

import com.codegen.codegen.composants.Propriete
import javafx.collections.FXCollections.observableArrayList
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.ComboBox
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

//create controller extend VBox as a custom control
class ControleurPropriete(propriete: Propriete) : VBox() {
    @FXML
    private var visibilite: ComboBox<String> = ComboBox<String>()
    @FXML
    private var conteneurPropriete: HBox = HBox()
    init {
        //load FXML file, and set CustomControl as root and controller
        FXMLLoader(javaClass.getResource("afficher-propriete.fxml")).apply {
            //"this" point to FXMLLoader,but we need set CustomControl as root and controller,so,use this@CustomControl
            setRoot(this@ControleurPropriete)
            setController(this@ControleurPropriete)
            load()
        }
        visibilite.items = observableArrayList(
            listOf("private", "public", "protected")
        )
        // SelectionModel pointe sur les éléments qui sont sélectionnés
        visibilite.selectionModel.select("private")
        val typeNomIcone = ControleurTypeNomIcones(propriete.type, propriete.nom)
        conteneurPropriete.children.add(typeNomIcone)
    }
}
