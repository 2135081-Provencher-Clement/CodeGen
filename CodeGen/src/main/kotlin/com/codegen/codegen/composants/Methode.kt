package com.codegen.codegen.composants

import kotlinx.serialization.Serializable

/**
 * structure d'information qui représente une méthode.
 * une méthode possède une visibilité, un type de retour et des paramètres.
 *
 * @property visibilite la visibilité de la méthode
 * @property typeRetour le type de retour de la méthode
 * @property parametres la liste des paramètres de la méthodes
 *
 * @author Clément Provencher
 */
@Serializable
data class Methode(
    var visibilite : Visibilite,
    var typeRetour : String,
    val parametres : MutableList<Parametre> = mutableListOf() )
{
    /**
     * Ajoute un paramètre à la liste de paramètres de la méthode
     *
     * @param parametre le paramètre à ajouter
     *
     * @author Clément Provencher
     */
    fun AjouterParametre(parametre: Parametre) {
        parametres.add(parametre)
    }

    /**
     * Retire un paramètre de la liste de paramètres de la méthode
     *
     * @param parametre le paramètre à retirer
     * @return un Boolean qui est true si la suppression s'est bien effectuée, ou false sinon
     *
     * @author Clément Provencher
     */
    fun RetirerParametre(parametre: Parametre): Boolean {
        return parametres.remove(parametre)
    }
}
