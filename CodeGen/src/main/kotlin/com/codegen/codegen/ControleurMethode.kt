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

/**
 *  Classe du contrôleur pour afficher une méthode.
 *
 *  @param methode la méthode à afficher dans le composant visuel
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class ControleurMethode(methode: Methode) : VBox() {
    /**
     * Variables des composants visuels d'une méthode
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @FXML
    private var visibilite: ComboBox<String> = ComboBox<String>()
    @FXML
    private var boutonAjouter: Button = Button()
    @FXML
    fun ajouter() = println("Ajouter un param!")
    @FXML
    private var conteneurMethode: HBox = HBox()
    @FXML
    private var parametresMethode: VBox = VBox()

    /**
     * Initialisation des valeurs des composants visuels d'une méthode
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    init {
        FXMLLoader(javaClass.getResource("afficher-methode.fxml")).apply {
            setRoot(this@ControleurMethode)
            setController(this@ControleurMethode)
            load()
        }
        // Ajout de l'entête de la méthode
        conteneurMethode.children.add(
            ControleurTypeNomIcones(methode.typeRetour, methode.nom)
        )
        // Ajout des paramètres de la méthode
        for (parametre in methode.parametres) {
            parametresMethode.children.add(
                ControleurTypeNomIcones(parametre.type, parametre.nom)
            )
        }
        // Ajout des visibilités possibles de la méthode
        visibilite.items = observableArrayList(
            listOf("private", "public", "protected")
        )
        visibilite.selectionModel.select(methode.visibilite.name)
        // Image pour ajouter un paramètre
        val imageAjouter = Image(javaClass.getResourceAsStream("images/ajouter.png"), 50.0, 50.0, false, false)
        boutonAjouter.graphic = ImageView(imageAjouter)
    }
}
