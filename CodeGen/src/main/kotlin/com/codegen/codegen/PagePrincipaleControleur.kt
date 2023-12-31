package com.codegen.codegen

import com.codegen.codegen.composants.*
import com.codegen.codegen.fichiersCode.Classe
import com.codegen.codegen.fichiersCode.Interface
import com.codegen.codegen.fichiersCode.MotCleeClasse
import com.codegen.codegen.projet.Projet
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.VBox
import javafx.stage.FileChooser
import javafx.stage.Stage
import java.io.File
import java.util.*

/**
 *  Classe du contrôleur de l'interface principale.
 *
 *  @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
 *  Code partiellement généré par: OpenAi. (2023). ChatGPT (version 10 novembre 2023) [Modèle massif de langage]. https://chat.openai.com/chat
 */
class PagePrincipaleControleur {


    /**
     * Variables du menu
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private lateinit var menuItemFermerFenetre: MenuItem
    @FXML
    private lateinit var menuItemCreerProjet: MenuItem
    @FXML
    private lateinit var menuItemOuvrirProjet: MenuItem
    @FXML
    private lateinit var menuItemEnregistrerProjet: MenuItem
    @FXML
    private lateinit var menuItemExporterProjet: MenuItem
    @FXML
    private lateinit var menuItemParametres: MenuItem
    @FXML
    private lateinit var menuItemRenommerClasse: MenuItem
    @FXML
    private lateinit var menuItemAjouterImplementation: MenuItem
    @FXML
    private lateinit var menuItemAjouterHeritage: MenuItem
    @FXML
    private lateinit var menuItemExporterClasse: MenuItem
    @FXML
    private lateinit var menuItemSupprimerClasse: MenuItem
    @FXML
    private lateinit var menuItemAjouterClasse: MenuItem
    @FXML
    private lateinit var menuItemAjouterAttribut: MenuItem

    /**
     * Variable de l'étique du nom du projet
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private lateinit var etiquetteNomProjet: Label

    /**
     * Variable de l'arborscence du projet
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private var arborescenceProjet: TreeView<String> = TreeView<String>()

    /**
     * Variable qui contient la zone d'affichage de la classe
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @FXML
    private var zoneAffichageClasse: VBox = VBox()

    /**
     * Variable qui définissent le projet et la classe active
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    private lateinit var projetActif: Projet

    private lateinit var classeActive: Classe


    /**
     * Fonction d'initialisation des composants
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun initialize() {
        menuItemFermerFenetre.setOnAction {
            surFermerFenetre()
        }
        menuItemCreerProjet.setOnAction {
            surCreerProjet()
        }
        menuItemOuvrirProjet.setOnAction {
            surOuvrirProjet()
        }
        menuItemEnregistrerProjet.setOnAction {
            //surEnregistrerProjet()
        }
        menuItemParametres.setOnAction {
            surParametres()
        }
        menuItemAjouterImplementation.setOnAction {
            surAjouterImplementation()
        }
        menuItemAjouterHeritage.setOnAction {
            surAjouterHeritage()
        }
        menuItemExporterClasse.setOnAction {
            surExporterClasse()
        }
        menuItemExporterProjet.setOnAction {
            surExporterProjet()
        }
        menuItemSupprimerClasse.setOnAction {
            surSupprimerClasse()
        }
        menuItemAjouterClasse.setOnAction {
            surAjouterClasse()
        }
//        menuItemAjouterInterface.setOnAction {
//            surAjouterClasse()
//        }

    }




    /**
     * Fonction pour initialiser le nom du projet dans l'interface principale du nouveau projet
     *
     * @author Francis Payan - 2131102@etudiant.cegepvicto.ca
     *
     * @param nomDuProjet Le nom du projet
     */
    fun initialiserNomDuProjet(nomDuProjet: String) {
        etiquetteNomProjet.text = "Projet: $nomDuProjet"
    }

    /**
     * Fonction pour ouvrir ou initialiser un projet dans l'interface principale
     *
     * @param projet Le projet
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    fun initialiserProjet(projet: Projet) {
        initialiserNomDuProjet(projet.nom)
        arborescenceProjet.root = TreeItem(projet.nom)

        if(projet.classes.isEmpty() && projet.interfaces.isEmpty()) {
            surAjouterClasse()
        }
        else {
            for (classe in projet.classes) {
                arborescenceProjet.root.children.add(TreeItem(classe.nom))
                zoneAffichageClasse.children.add(ControleurClasse(classe))
            }
        }
    }

    /**
     * Fonction pour l'ouverture de la fenêtre de création d'une classe au projet
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surAjouterClasse() {
        val dialogue = TextInputDialog("Nom de la nouvelle classe")
        dialogue.headerText = "Ajouter une nouvelle classe"
        dialogue.contentText = "Nom de la nouvelle classe :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nomNouvelleClasse = resultat.get()
            initialisationNouvelleClasse(nomNouvelleClasse)
            arborescenceProjet.root.children.add(TreeItem(nomNouvelleClasse))
        }
    }

    /**
     * Fonction pour initialiser une nouvelle classe d'exemple
     */
    @FXML
    private fun initialisationNouvelleClasse(nomClasse: String) {

        // Définir ce qu'il y a dans la classe
        // @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
        val propriete1 = Propriete(Visibilite.public, "string", "nom")
        val propriete2 = Propriete(Visibilite.public, "string", "prenom")
        val listeProprieteConstructeur = listOf(propriete1, propriete2)
        val listeProprieteConstructeur2 = listOf(propriete1)
        val listePropriete = listOf(propriete1, propriete2)
        val liste = listOf(Parametre("string", "nom1"), Parametre("string", "nom2"))
        val uneMethode = Methode(Visibilite.public, "string", "FaireQQch", liste, true)
        val methode2 = Methode(Visibilite.public, "string", "FaireQQchAutre", liste, false)
        val listeMethode = listOf(uneMethode, methode2)
        val constructeur = Constructeur(Visibilite.public, listeProprieteConstructeur)
        val constructeur2 = Constructeur(Visibilite.public, listeProprieteConstructeur2)
        val listeConstructeur = listOf(constructeur, constructeur2)
        val classe = Classe(Visibilite.public, "Chat", MotCleeClasse.classique, listePropriete, listeMethode, listeConstructeur)
        val listeClasse = listOf(classe)
        val uneInterface = Interface(Visibilite.public, "IVendable", listeProprieteConstructeur, listeMethode)
        val listeInterfaces = listOf(uneInterface)
        projetActif = Projet(UUID.randomUUID(), "Projet-ferme", listeClasse, listeInterfaces)
        classeActive = projetActif.classes[0]
        zoneAffichageClasse.children.add(ControleurClasse(classe))

    }


    /**
     * Fonction pour fermer l'application
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surFermerFenetre() {
        Platform.exit()
    }

    /**
     * Fonction pour créer un nouveau projet
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surCreerProjet() {
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
    @FXML
    private fun surOuvrirProjet() {
        val selecteurFichier = FileChooser()
        selecteurFichier.title = "Sélectionnez un projet"
        //val fichierSelectionne = selecteurFichier.showOpenDialog(texteBienvenue.scene.window)
        //if (fichierSelectionne != null) {
        //val cheminProjet = fichierSelectionne.absolutePath
        // Ouvrez le projet situé à cheminProjet
    }

    /**
     * Fonction pour ouvrir la fenêtre de paramètres
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surParametres() {
        val stageParametres = Stage()
        val chargeurParametres = FXMLLoader(CodeGenApplication::class.java.getResource("vue-parametres.fxml"))
        val racineParametres = chargeurParametres.load<Parent>()
        stageParametres.scene = Scene(racineParametres)
        stageParametres.title = "Paramètres"
        stageParametres.show()
    }

    /**
     * Fonction pour ouvrir la fenêtre pour renommer un projet
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surRenommerProjet() {
        val dialogue = TextInputDialog("Nouveau nom de projet")
        dialogue.headerText = "Renommer le projet"
        dialogue.contentText = "Nouveau nom de projet"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nouveauNomProjet = resultat.get()
            initialiserNomDuProjet(nouveauNomProjet)
        }
    }

    /**
     * Fonction pour ouvrir la fenêtre pour implémenter un interface à la classe
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surAjouterImplementation() {
        val dialogue = TextInputDialog("Nom de l'interface à implémenter")
        dialogue.headerText = "Ajouter une implémentation"
        dialogue.contentText = "Nom de l'interface à implémenter :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nomInterface = resultat.get()
            // Ajouter l'implémentation de l'interface nomInterface à la classe
        }
    }

    /**
     * Fonction pour ouvrir la fenêtre pour ajouter un héritage à la classe
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surAjouterHeritage() {
        val dialogue = TextInputDialog("Nom de la classe parente")
        dialogue.headerText = "Ajouter un héritage"
        dialogue.contentText = "Nom de la classe parente :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nomClasseParente = resultat.get()
            // Ajoutez l'héritage de la classe parente nomClasseParente à la classe
        }
    }

    /**
     * Fonction pour ouvrir la fenêtre d'exportation d'une classe
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surExporterClasse() {
        // @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
        print("exporter classe")
        exporterClasseCSharp(classeActive)
        // Pour l'instant, la selection de dossier n'est pas encore intégré
        // dans l'application. L'exportation se fait dans le dossier de projet
        // Fin des ajouts de Cedric
//        val selecteurFichier = FileChooser()
//        selecteurFichier.title = "Choisissez un emplacement pour l'export de la classe"
//        selecteurFichier.extensionFilters.add(
//            FileChooser.ExtensionFilter("Fichiers Java", "*.java")
//        )
//        val fichierSelectionne = selecteurFichier.showSaveDialog(texteBienvenue.scene.window)
//        if (fichierSelectionne != null) {
//            val cheminExportClasse = fichierSelectionne.absolutePath
//            // Exportez la classe vers le chemin cheminExportClasse
//        }
    }

    /**
     * Fonction pour exporter le projet actif
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surExporterProjet() {
        print("exporter projet")
        exporterCSharp(projetActif)

        // Pour l'instant, la selection de dossier n'est pas encore intégré
        // dans l'application. L'exportation se fait dans le dossier de projet
    }

    /**
     * Fonction pour la suppression d'une classe
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surSupprimerClasse() {
        // Code pour supprimer une classe
        // Exemple : Afficher une boîte de dialogue de confirmation de suppression
        val alerte = Alert(Alert.AlertType.CONFIRMATION)
        alerte.title = "Confirmation de suppression"
        alerte.headerText = "Êtes-vous sûr de vouloir supprimer cette classe ?"
        val resultat = alerte.showAndWait()
        if (resultat.isPresent && resultat.get() == ButtonType.OK) {
            // Supprimez la classe
        }
    }



    /**
     * Fonction pour l'ouverture de la fenêtre de création d'un interface au projet
     *
     * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
     */
    @FXML
    private fun surAjouterInterface() {
        val dialogue = TextInputDialog("Nom de la nouvelle interface")
        dialogue.headerText = "Ajouter une nouvelle interface"
        dialogue.contentText = "Nom de la nouvelle interface :"
        val resultat = dialogue.showAndWait()
        if (resultat.isPresent) {
            val nouveauNomInterface = resultat.get()
            // Ajoutez le nouvel interface avec le nom nouveauNomInterface
        }
    }

    /**
     * Fonction qui exporte toutes les classes et interfaces
     * du projet en C#
     *
     * @param projet le projet à exporter
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    fun exporterCSharp(projet: Projet) {
        for (classe in projet.classes) {
            exporterClasseCSharp(classe)
        }
        for (uneInterface in projet.interfaces) {
            exporterInterfaceCSharp(uneInterface)
        }
    }

    /**
     * Fonction qui exporte la classe en paramètres en C#
     *
     * @param classe la classe à exporter
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    fun exporterClasseCSharp(classe: Classe) {
        val fileName = classe.nom + ".cs"
        var fileContent = "\n" + classe.visibilite + " class " + classe.nom + "\n{\n"
        for (propriete in classe.proprietes) {
            fileContent += "\t" + propriete.visibilite + " " + propriete.type + " " + propriete.nom + ";\n"
        }
        fileContent += "\n"
        for (constructeur in classe.constructeurs) {
            fileContent += "\t" + constructeur.visibilite + " " + classe.nom + "("
            for (index in constructeur.proprietes.indices) {
                fileContent += constructeur.proprietes[index].type + " " + constructeur.proprietes[index].nom
                if (index + 1 != constructeur.proprietes.size) {
                    fileContent += ", "
                }
            }
            fileContent += ")\n\t{\n\t\t\n\t}\n\n"
        }
        for (methode in classe.methodes) {
            fileContent += "\t" + methode.visibilite + " " + methode.typeRetour + " " + methode.nom + "("
            fileContent += ajouterParametresMethodeCSharp(methode)
            fileContent += ")\n\t{\n\t\t\n\t}\n\n"
        }
        fileContent += "\n}"
        File(fileName).writeText(fileContent)
    }

    /**
     * Fonction qui exporte l'interface en paramètre en C#
     *
     * @param uneInterface l'interface à exporter
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    fun exporterInterfaceCSharp(uneInterface: Interface) {
        val fileName =  uneInterface.nom + ".cs"
        var fileContent = "\n" + uneInterface.visibilite +  " interface " + uneInterface.nom + "\n{\n"
        for (propriete in uneInterface.proprietes) {
            fileContent += "\t" + propriete.visibilite + " " + propriete.type + " " + propriete.nom + " { get; set; }\n"
        }
        fileContent += "\n"
        for (methode in uneInterface.methodes) {
            fileContent += "\t" + methode.visibilite + " " + methode.typeRetour + " " + methode.nom + "("
            fileContent += ajouterParametresMethodeCSharp(methode) + ");\n"
        }
        fileContent += "\n}"
        File(fileName).writeText(fileContent)
    }

    /**
     * Fonction qui ajoute les paramètres d'une méthode dans un string
     * pour l'affichage lors de l'exportation
     *
     * @param methode la méthode dont on veut avoir un string de ses paramètres
     *
     * @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    private fun ajouterParametresMethodeCSharp(methode: Methode): String {
        var fileContent = ""
        for (index in methode.parametres.indices) {
            fileContent += methode.parametres[index].type + " " + methode.parametres[index].nom
            if (index + 1 != methode.parametres.size) {
                fileContent += ", "
            }
        }
        return fileContent
    }
}
