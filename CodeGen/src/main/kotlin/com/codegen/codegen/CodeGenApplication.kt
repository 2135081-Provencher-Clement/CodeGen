package com.codegen.codegen


import com.codegen.codegen.composants.*
import com.codegen.codegen.fichiersCode.Classe
import com.codegen.codegen.fichiersCode.Interface
import com.codegen.codegen.fichiersCode.MotCleeClasse
import com.codegen.codegen.projet.Projet
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.SplitPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.Screen
import javafx.stage.Stage
import javafx.stage.StageStyle
import java.io.File
import java.nio.charset.Charset

/**
 *  Classe de l'application de CodeGen
 *
 *  @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
 *  Code partiellement généré par: OpenAi. (2023). ChatGPT (version 10 novembre 2023) [Modèle massif de langage]. https://chat.openai.com/chat
 *  Code partiellement généré par: Microsoft. (2023). Bing (version 28 novembre 2023) [Modèle massif de langage]. https://bing.com/chat
 */
class CodeGenApplication : Application() {
    override fun start(stagePrincipal: Stage) {

        exporter()

        /**
         * Création de la fenêtre principale
         *
         * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
         * Code partiellement généré par: Microsoft. (2023). Bing (version 28 novembre 2023) [Modèle massif de langage]. https://bing.com/chat
         */
//        val chargeurFXMLInterfacePrincipale = FXMLLoader(CodeGenApplication::class.java.getResource("principale-view.fxml"))
//        val racinePrincipale = chargeurFXMLInterfacePrincipale.load<BorderPane>()
//        val scenePrincipale = Scene(racinePrincipale)
//        stagePrincipal.title = "CodeGen"
//        stagePrincipal.scene = scenePrincipale
//        stagePrincipal.show()

        /**
         * Création de la fenêtre d'ouverture de projet
         *
         * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
         * Code partiellement généré par: Microsoft. (2023). Bing (version 28 novembre 2023) [Modèle massif de langage]. https://bing.com/chat
         */
        val chargeurFXMLPageOuverture = FXMLLoader(CodeGenApplication::class.java.getResource("principale-view.fxml"))
        val racineOuverture = chargeurFXMLPageOuverture.load<BorderPane>()
        val stageOuverture = Stage()
        val sceneOuverture = Scene(racineOuverture, 800.0, 800.0)
        sceneOuverture.stylesheets.add("styles.css")
        stageOuverture.title = "CodeGen"
        stageOuverture.scene = sceneOuverture
        stageOuverture.show()
    }

    fun exporter() {
        var propriete1 = Propriete(Visibilite.private, "string", "nom")
        var propriete2 = Propriete(Visibilite.public, "string", "prenom")
        var listeProprieteConstructeur = listOf(propriete1, propriete2)
        var listeProprieteConstructeur2 = listOf(propriete1)
        var listePropriete = listOf(propriete1, propriete2)
        var param1 = Parametre("string", "nom1");
        var param2 = Parametre("string", "nom2");
        var liste = listOf(param1, param2);
        var uneMethode = Methode(Visibilite.private, "string", "FaireQQch", liste, true)
        var methode2 = Methode(Visibilite.private, "void", "FaireQQchAutre", liste, false)
        var listeMethode = listOf(uneMethode, methode2)
        var constructeur = Constructeur(Visibilite.public, listeProprieteConstructeur)
        var constructeur2 = Constructeur(Visibilite.public, listeProprieteConstructeur2)
        var listeConstructeur = listOf(constructeur, constructeur2)
        val classe = Classe(Visibilite.public, MotCleeClasse.classique, listePropriete, listeMethode, listeConstructeur)
        println("test")
//        exporterCSharp(classe)
        exporterKotlin(classe)
//        val fileName = "test.txt"
//        File(fileName).printWriter().use { out -> out.println("test2") }
    }

    fun exporterCSharp(classe: Classe) {

        println("C#")
//        val projet = Projet()
//        for (classe in projet.classes) {
//            exporterClasseCSharp(classe)
//        }
//        for (uneInterface in projet.interfaces) {
//            exporterInterfaceCSharp(uneInterface)
//        }
        exporterClasseCSharp(classe)
    }

    fun exporterClasseCSharp(classe: Classe) {
        val className = "Chat"
        val fileName = "$className.cs"
        var fileContent = "\n" + classe.visibilite + " class " + className + "\n{\n"
        for (propriete in classe.proprietes) {
            fileContent += "\t" + propriete.visibilite + " " + propriete.type + " " + propriete.nom + ";\n"
        }
        fileContent += "\n"
        for (constructeur in classe.constructeurs) {
            fileContent += "\t" + constructeur.visibilite + " " + className + "("
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

    fun exporterInterfaceCSharp(uneInterface: Interface) {
        val nomInterface = "IVendable"
        val fileName = "$nomInterface.cs"
        var fileContent = "\n" + uneInterface.visibilite +  " interface $nomInterface\n{\n"
        for (propriete in uneInterface.proprietes) {
            fileContent += "\t" + propriete.visibilite + " " + propriete.type + " " + propriete.nom + " { get; set; }\n"
        }
        fileContent += "\n"
        for (methode in uneInterface.methodes) {
            fileContent += "\t" + methode.visibilite + " " + methode.typeRetour + " " + methode.nom + "("
            fileContent += ajouterParametresMethodeCSharp(methode) + ");\n"
        }
        File(fileName).writeText(fileContent)
    }

    fun ajouterParametresMethodeCSharp(methode: Methode): String {
        var fileContent = ""
        for (index in methode.parametres.indices) {
            fileContent += methode.parametres[index].type + " " + methode.parametres[index].nom
            if (index + 1 != methode.parametres.size) {
                fileContent += ", "
            }
        }
        return fileContent
    }

    fun exporterKotlin(classe: Classe) {
//        val projet = Projet()
//        for (classe in projet.classes) {
//            exporterClasseKotlin(classe)
//        }
//        for (uneInterface in projet.interfaces) {
//            exporterInterfaceKotlin(uneInterface)
//        }
        exporterClasseKotlin(classe)
    }

    fun exporterClasseKotlin(classe: Classe) {

    }

    fun exporterInterfaceKotlin(uneInterface: Interface) {

    }
}

fun main() {
    Application.launch(CodeGenApplication::class.java)
}



