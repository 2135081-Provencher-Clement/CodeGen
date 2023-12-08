package com.codegen.codegen

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.VBox

//create controller extend VBox as a custom control
//(typeParam: String, nomParam: String)
class ControleurTypeNomIcones(typeParam: String, nomParam: String) : VBox() {
    @FXML
    private var type: TextField = TextField()
    @FXML
    private var nom: TextField = TextField()
    @FXML
    private var boutonSupprimer: Button = Button()
    @FXML
    private var boutonModifier: Button = Button()
    @FXML
    fun supprimer()= println("Supprimer!")
    @FXML
    fun modifier()= println("Modifier!")

    init {
        //load FXML file, and set CustomControl as root and controller
        FXMLLoader(javaClass.getResource("afficher-type-nom-icones.fxml")).apply {
            //"this" point to FXMLLoader,but we need set CustomControl as root and controller,so,use this@CustomControl
            setRoot(this@ControleurTypeNomIcones)
            setController(this@ControleurTypeNomIcones)
            load()
        }
        nom.text = nomParam
        type.text = typeParam
        val imageSupprimer = Image(javaClass.getResourceAsStream("images/supprimer.png"), 30.0, 30.0, false, false)
        val imageModifier = Image(javaClass.getResourceAsStream("images/modifier.png"), 30.0, 30.0, false, false)
        boutonSupprimer.graphic = ImageView(imageSupprimer)
        boutonModifier.graphic = ImageView(imageModifier)
    }
}


