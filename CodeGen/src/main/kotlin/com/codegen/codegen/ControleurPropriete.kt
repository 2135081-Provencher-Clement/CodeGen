package com.codegen.codegen

import com.codegen.codegen.composants.Propriete
import javafx.collections.FXCollections.observableArrayList
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.ComboBox
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

/**
 *  Classe du contrôleur pour afficher une propriété
 *
 *  @param propriete la propriété à afficher dans le composant visuel
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class ControleurPropriete(propriete: Propriete) : VBox() {
    /**
     * Variables des composants visuels d'une propriété
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @FXML
    private var visibilite: ComboBox<String> = ComboBox<String>()
    @FXML
    private var conteneurPropriete: HBox = HBox()
    /**
     * Initialisation des valeurs des composants visuels d'une propriété
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    init {
        FXMLLoader(javaClass.getResource("afficher-propriete.fxml")).apply {
            setRoot(this@ControleurPropriete)
            setController(this@ControleurPropriete)
            load()
        }
        // Ajout des visibilités possibles pour une propriété
        visibilite.items = observableArrayList(
            listOf("private", "public", "protected")
        )
        visibilite.selectionModel.select(propriete.visibilite.name)
        // Ajout du type et du nom de la propriété
        conteneurPropriete.children.add(
            ControleurTypeNomIcones(propriete.type, propriete.nom)
        )
    }
}
