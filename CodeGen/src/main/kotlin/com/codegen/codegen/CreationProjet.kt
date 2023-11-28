// Fichier CreationProjet.kt

package com.codegen.codegen

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class CreationProjet : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(CreationProjet::class.java.getResource("creation-projet-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 800.0, 800.0)
        scene.stylesheets.add("styles.css")
        stage.title = "Gestion de Projets"
        stage.scene = scene
        stage.show()
    }
}


fun main() {
    Application.launch(CreationProjet::class.java)
}
