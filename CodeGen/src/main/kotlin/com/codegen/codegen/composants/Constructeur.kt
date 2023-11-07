package com.codegen.codegen.composants

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
data class Constructeur(
    val visibilite: Visibilite,
    val proprietes: MutableList<Propriete> )
{
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
