package com.codegen.codegen.composants

import com.codegen.codegen.serializerPersonnalisee.composants.ParametreSerializer
import kotlinx.serialization.Serializable

/**
 * structure pour un paramètre de méthode qui a un type et un nom
 *
 * @property type le type du paramètre
 * @property nom le nom du paramètre
 *
 * @author Clément Provencher
 */
@Serializable(with = ParametreSerializer::class)
class Parametre
{
    /**
     * Constructeur qui assigne une valeur à chaque propriété d'un paramètre
     *
     * @param type Le type du paramètre
     * @param nom Le nom du constructeur
     *
     * @author Clément Provencher
     */
    constructor(type: String, nom: String) {
        this.type = type
        this.nom = nom
    }

    /**
     * Constructeur par défaut qui créé un paramètre avec des valeurs par défaut
     *
     * @author Clément Provencher
     */
    constructor()

    /**
     * Le type du paramètre
     */
    var type : String = ""
        set(value) {
            field = value
        }

    /**
     * Le nom du paramètre
     */
    var nom : String = ""
        set(value) {
            field = value
        }
}
