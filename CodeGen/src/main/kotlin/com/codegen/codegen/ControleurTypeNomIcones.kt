package com.codegen.codegen

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.VBox

/**
 *  Classe du contrôleur pour afficher le type, le nom et deux boutons (modifier et supprimer)
 *
 *  @param typeParam le type de la variable/méthode
 *  @param nomParam le nom de la variable/méthode
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class ControleurTypeNomIcones(typeParam: String, nomParam: String) : VBox() {
    /**
     * Variables des composants visuels pour afficher le type, le nom et deux boutons
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
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
    /**
     * Initialisation des valeurs de ce composant
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    init {
        FXMLLoader(javaClass.getResource("afficher-type-nom-icones.fxml")).apply {
            setRoot(this@ControleurTypeNomIcones)
            setController(this@ControleurTypeNomIcones)
            load()
        }
        // Afficher les informations
        nom.text = nomParam
        type.text = typeParam
        // Ajouter les images aux boutons
        val imageSupprimer = Image(javaClass.getResourceAsStream("images/supprimer.png"), 30.0, 30.0, false, false)
        val imageModifier = Image(javaClass.getResourceAsStream("images/modifier.png"), 30.0, 30.0, false, false)
        boutonSupprimer.graphic = ImageView(imageSupprimer)
        boutonModifier.graphic = ImageView(imageModifier)
    }
}


