package com.codegen.codegen

import com.codegen.codegen.composants.Constructeur
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.VBox

/**
 *  Classe du contrôleur pour afficher un constructeur.
 *
 *  @param constructeur le constructeur à afficher dans le composant visuel
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class ControleurConstructeur(constructeur: Constructeur) : VBox() {
    /**
     * Variables des composants visuels d'un constructeur
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @FXML
    private var boutonAjouter: Button = Button()
    @FXML
    fun ajouter() = println("Ajouter un param!")
    @FXML
    private var parametresConstructeur: VBox = VBox()

    /**
     * Initialisation des valeurs des composants visuels d'un constructeur
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    init {
        FXMLLoader(javaClass.getResource("afficher-constructeur.fxml")).apply {
            setRoot(this@ControleurConstructeur)
            setController(this@ControleurConstructeur)
            load()
        }
        // Ajout des paramètres du constructeur
        for (parametre in constructeur.proprietes) {
            parametresConstructeur.children.add(
                ControleurTypeNomIcones(parametre.type, parametre.nom)
            )
        }
        // Image pour ajouter un paramètre
        val imageAjouter = Image(javaClass.getResourceAsStream("images/ajouter.png"), 50.0, 50.0, false, false)
        boutonAjouter.graphic = ImageView(imageAjouter)
    }
}
