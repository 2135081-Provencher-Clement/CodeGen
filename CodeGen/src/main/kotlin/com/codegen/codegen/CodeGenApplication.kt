package com.codegen.codegen

/**
 *  Classe de l'application de CodeGen
 *  @author Alexandre del Fabbro - 2166311@etudiant.cegepvicto.ca
 *  Code partiellement généré par: OpenAi. (2023). ChatGPT (version 10 novembre 2023) [Modèle massif de langage]. https://chat.openai.com/chat
 */
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.SplitPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.Screen
import javafx.stage.Stage
import javafx.stage.StageStyle

class CodeGenApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(CodeGenApplication::class.java.getResource("principale-view.fxml"))
        val root = fxmlLoader.load<BorderPane>()

        val scene = Scene(root)

        stage.title = "CodeGen"

//        stage.isMaximized = true
//        stage.minWidth = 800.0
//        stage.minHeight = 600.0

        stage.scene = scene

        stage.show()
    }
}

fun main() {
    Application.launch(CodeGenApplication::class.java)
}



