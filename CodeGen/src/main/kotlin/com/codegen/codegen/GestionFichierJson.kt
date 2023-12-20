// Fichier src/main/kotlin/com.codegen.codegen/GestionFichierJson.kt

package com.codegen.codegen

import com.codegen.codegen.projet.ListeProjet
import com.codegen.codegen.serializerPersonnalisee.projet.ListeProjetSerializer
import kotlinx.serialization.json.Json
import java.io.File
import java.io.IOException

/**
 * Fonction pour écrire un objet ListeProjet dans un fichier JSON avec le nom spécifié en paramètre
 *
 * Auteur: Francis Payan - 2131102@etudiant.cegepvicto.ca
 *
 * @param json
 * @param nomFichier
 */
fun ecrireJsonDansFichier(json: String, nomFichier: String) {
    try {
        File(nomFichier).writeText(json)
    } catch (e: IOException) {
        println("Erreur d'écriture de fichier : ${e.message}")
    }
}

/**
 * Fonction pour lire un fichier JSON et le convertir en objet ListeProjet
 *
 * Auteur: Francis Payan - 2131102@etudiant.cegepvicto.ca
 *
 * @param nomFichier
 * @return ListeProjet
 */
fun lireFichierJsonEnListeProjet(nomFichier: String): ListeProjet? {
    return try {
        val contenuFichier = File(nomFichier).readText()
        Json.decodeFromString(ListeProjetSerializer, contenuFichier)
    } catch (e: IOException) {
        println("Erreur de lecture de fichier : ${e.message}")
        null
    }
}
