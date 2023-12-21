package com.codegen.codegen

import com.codegen.codegen.fichiersCode.Classe
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.TextInputDialog
import javafx.scene.layout.VBox
import javafx.scene.text.Text

/**
 *  Classe du contrôleur pour afficher la classe.
 *
 *  @param classe la classe à afficher dans le composant visuel
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class ControleurClasse(var classe: Classe) : VBox() {
    /**
     * Variables des composants visuels de la classe
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @FXML
    private var visibiliteClasse: ComboBox<String> = ComboBox<String>()
    @FXML
    private var motCleClasse: ComboBox<String> = ComboBox<String>()
    @FXML
    private var nomClasse: Button = Button()
    @FXML
    private var heritage: Text = Text()
    @FXML
    private var conteneurPropriete: VBox = VBox()
    @FXML
    private var conteneurConstructeur: VBox = VBox()
    @FXML
    private var contenueurMethode: VBox = VBox()

    /**
     * Initialisation des valeurs des composants visuels de la classe
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    init {
        FXMLLoader(javaClass.getResource("afficher-classe.fxml")).apply {
            setRoot(this@ControleurClasse)
            setController(this@ControleurClasse)
            load()
        }
        // Ajout des propriétés
        for (propriete in classe.proprietes) {
            conteneurPropriete.children.add(ControleurPropriete(propriete))
        }
        // Ajout des constructeurs
        for (constructeur in classe.constructeurs) {
            conteneurConstructeur.children.add(ControleurConstructeur(constructeur))
        }
        // Ajout des méthodes
        for (methode in classe.methodes) {
            contenueurMethode.children.add(ControleurMethode(methode))
        }
        // Ajout des visibilités possibles pour la classe
        visibiliteClasse.items = FXCollections.observableArrayList(
            listOf("public", "protected")
        )
        visibiliteClasse.selectionModel.select(classe.visibilite.name)
        // Ajout des mots clés possbiles pour la classe
        motCleClasse.items = FXCollections.observableArrayList(
            listOf("classique", "sealed", "abstract", "static")
        )
        motCleClasse.selectionModel.select(classe.motCleeClasse.name)
        // Ajout du nom de la classe et de l'héritage
        nomClasse.text = classe.nom

        heritage.text = " : " + "Aucun héritage" //TODO: Label de l'héritage
    }

    /**
     * Fonction pour ouvrir la fenêtre pour renommer une classe
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    fun surRenommerClasse() {
        val dialog = TextInputDialog("Nouveau nom de la classe")
        dialog.title = "Renommer la classe"
        dialog.headerText = "Renommer la classe"
        dialog.contentText = "Entrez le nouveau nom de la classe :"
        val result = dialog.showAndWait()
        if (result.isPresent) {
            val nouveauNomClasse = result.get()
            classe.nom = nouveauNomClasse
            nomClasse.text = nouveauNomClasse
        }
    }
}
