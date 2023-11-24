package com.codegen.codegen.composants

import com.codegen.codegen.serializerPersonnalisee.composants.ProprieteSerializer
import kotlinx.serialization.Serializable

/**
 * structure pour les informations d'une propriété
 * une propriété à un type, un nom et une visibilité
 *
 * @property visibilite la visibilité de la propriété
 * @property type le type de la propriété
 * @property nom le nom de la propriété
 *
 * @author Clément Provencher
 */
@Serializable(with = ProprieteSerializer::class)
class Propriete
{
    /**
     * Constructeur qui assigne chque propriété de la classe Propriete
     *
     * @param visibilite La visibilité de la propriété
     * @param type Le type de la propriété
     * @param nom Le nom de la propriété
     *
     * @author Clément Provencher
     */
    constructor(visibilite: Visibilite, type: String, nom: String) {
        this.visibilite = visibilite
        this.type = type
        this.nom = nom
    }

    /**
     * Constructeur par défaut qui ne fait que créer un instance
     * avec les valeurs par défaut pour chaque propriété
     *
     * @author Clément Provencher
     */
    constructor()

    /**
     * La visibilité de la propriété
     */
    var visibilite : Visibilite = Visibilite.private
        set(value) {
            field = value
        }

    /**
     * Le type de la propriété
     */
    var type : String = ""
        set(value) {
            field = value
        }

    /**
     * le nom de la propriété
     */
    var nom : String = ""
        set(value) {
            field = value
        }
}
