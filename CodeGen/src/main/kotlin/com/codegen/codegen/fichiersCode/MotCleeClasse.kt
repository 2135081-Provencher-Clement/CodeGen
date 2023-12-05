package com.codegen.codegen.fichiersCode

import com.codegen.codegen.serializerPersonnalisee.fichiersCode.MotCleeClasseSerializer
import kotlinx.serialization.Serializable

/**
 * Enum pour les mots clées attribuables à une classe, soit
 *  static
 *  abstract
 *  sealed
 *
 * Un quatrième choix est ajouté pour les classes qui n'auraient aucune de ces trois caractéristiques
 *  classique
 *
 *  @author Clément Provencher
 */
@Serializable(with = MotCleeClasseSerializer::class)
enum class MotCleeClasse {
    classique,
    sealed,
    abstract,
    static
}
