package com.codegen.codegen

import com.codegen.codegen.composants.Methode
import javafx.collections.FXCollections.observableArrayList
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

//create controller extend VBox as a custom control
// (methode: Methode)
class ControleurMethode(methode: Methode) : VBox() {
    @FXML
    private var visibilite: ComboBox<String> = ComboBox<String>()
    @FXML
    private var boutonAjouter: Button = Button()
    @FXML
    fun ajouter()= println("Ajouter un param!")
    @FXML
    private var conteneurMethode: HBox = HBox()
    @FXML
    private var parametresMethode: VBox = VBox()
    init {
        //load FXML file, and set CustomControl as root and controller
        FXMLLoader(javaClass.getResource("afficher-methode.fxml")).apply {
            //"this" point to FXMLLoader,but we need set CustomControl as root and controller,so,use this@CustomControl
            setRoot(this@ControleurMethode)
            setController(this@ControleurMethode)
            load()
        }
        visibilite.items = observableArrayList(
            listOf("private", "public", "protected")
        )
        // SelectionModel pointe sur les éléments qui sont sélectionnés
        visibilite.selectionModel.select("private")
        val typeNomIcone = ControleurTypeNomIcones(methode.typeRetour, methode.nom)
        conteneurMethode.children.add(typeNomIcone)
//        val param = TypeNomIconesControleur("string", "param1")
//        parametresMethode.children.add(param)
        for (parametre in methode.parametres) {
            val param = ControleurTypeNomIcones(parametre.type, parametre.nom)
            parametresMethode.children.add(param)
        }
        val imageAjouter = Image(javaClass.getResourceAsStream("images/ajouter.png"), 50.0, 50.0, false, false)
        boutonAjouter.graphic = ImageView(imageAjouter)
    }
}
