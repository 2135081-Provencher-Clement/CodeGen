package com.codegen.codegen


import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.SplitPane
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.Screen
import javafx.stage.Stage
import javafx.stage.StageStyle

/**
 *  Classe de l'application de CodeGen
 *
 *  @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
 *  Code partiellement généré par: OpenAi. (2023). ChatGPT (version 10 novembre 2023) [Modèle massif de langage]. https://chat.openai.com/chat
 *  Code partiellement généré par: Microsoft. (2023). Bing (version 28 novembre 2023) [Modèle massif de langage]. https://bing.com/chat
 */
class CodeGenApplication : Application() {
    override fun start(stagePrincipal: Stage) {
        /**
         * Création de la fenêtre d'ouverture de projet
         *
         * @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
         * Code partiellement généré par: Microsoft. (2023). Bing (version 28 novembre 2023) [Modèle massif de langage]. https://bing.com/chat
         */

        val chargeurFXMLPageOuverture = FXMLLoader(CodeGenApplication::class.java.getResource("page-ouverture-view.fxml"))
        val racineOuverture = chargeurFXMLPageOuverture.load<AnchorPane>()

        val stageOuverture = Stage()
        val sceneOuverture = Scene(racineOuverture, 800.0, 800.0)
        sceneOuverture.stylesheets.add("styles.css")
        stageOuverture.title = "CodeGen"
        stageOuverture.scene = sceneOuverture
        stageOuverture.show()
    }
}

fun main() {
    Application.launch(CodeGenApplication::class.java)
}



