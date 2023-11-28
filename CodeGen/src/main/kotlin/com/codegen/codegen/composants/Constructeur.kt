package com.codegen.codegen.composants

import com.codegen.codegen.serializerPersonnalisee.composants.ConstructeurSerializer
import kotlinx.serialization.Serializable

/**
 * structure d'information qui représente un constructeur de classe.
 * le constructeur possède une liste de propriétés qu'il initialiserait.
 * la liste de propriétés sera utilisé pour peupler la liste de paramètre du constructeur
 * à la transformation en squelette de code
 *
 * @property visibilite la visibilité du constructeur
 * @property proprietes la liste des propriétés que le constructeur initialiserait
 *
 * @author Clément Provencher
 */
@Serializable(with = ConstructeurSerializer::class)
class Constructeur
{

    /**
     * Constructeur du constructeur qui assigne tous les propriétés
     *
     * @param visibilite La visibilité du constructeur
     * @param proprietes L'Ensemble des proprietes que le constructeur assigne
     *
     * @author Clément Provencher
     */
    constructor(visibilite: Visibilite, proprietes: List<Propriete>) {
        this.visibilite = visibilite

        proprietes.forEach { propriete -> AjouterPropriete(propriete) }
    }

    /**
     * Constructeur du constructeur qui laisse les propriétés à leur valeur par défaut
     */
    constructor()

    /**
     * La visibilité du constructeur
     */
    var visibilite : Visibilite = Visibilite.public
        set(value) {
            field = value
        }

    /**
     * L'ensemble des propriétés que le constructeur assigne
     */
    val proprietes: MutableList<Propriete> = mutableListOf()

    /**
     * Ajoute une propriété à la liste de propriétés du constructeur
     *
     * @param propriete la propriété à ajouter
     */
    fun AjouterPropriete(propriete: Propriete) {
        proprietes.add(propriete)
    }

    /**
     * Retire une propriété de la liste de propriétés initialisés du constructeur
     *
     * @param propriete la propriété à retirer
     * @return un Boolean qui est true si la suppression s'est bien effectuée, ou false sinon
     *
     * @author Clément Provencher
     */
    fun RetirerPropriete(propriete: Propriete): Boolean {
        return proprietes.remove(propriete)
    }
}
