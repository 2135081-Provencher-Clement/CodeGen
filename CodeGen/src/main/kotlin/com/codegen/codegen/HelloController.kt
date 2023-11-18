package com.codegen.codegen

import com.codegen.codegen.composants.Propriete
import com.codegen.codegen.composants.Visibilite
import javafx.fxml.FXML
import javafx.scene.control.Label
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class HelloController {
    @FXML
    private lateinit var welcomeText: Label

    @FXML
    private fun onHelloButtonClick() {
        var jsonPropriete = "{\"visibilite\":\"private\",\"type\":\"\",\"nom\":\"\"}"

        var proprieteTest : Propriete = Json.decodeFromString(jsonPropriete)

        welcomeText.text = Json.encodeToString(proprieteTest)
    }
}
