package com.codegen.codegen.composants

import com.codegen.codegen.serializerPersonnalisee.composants.MethodeSerializer
import kotlinx.serialization.Serializable

/**
 * structure d'information qui représente une méthode.
 * une méthode possède une visibilité, un type de retour et des paramètres.
 *
 * @property visibilite la visibilité de la méthode
 * @property typeRetour le type de retour de la méthode
 * @property nom le nom de la méthode
 * @property parametres la liste des paramètres de la méthodes
 *
 * @author Clément Provencher
 */
@Serializable(with = MethodeSerializer::class)
class Methode
{
    /**
     * Constructeur qui assigne tous les propriétés de la méthode
     *
     * @param visibilite La visibilité de la méthode
     * @param typeRetour Le type de retour de la méthode
     * @param nom Le nom de la méthode
     * @param parametres Les paramètres de la méthode
     *
     * @author Clément Provencher
     */
    constructor(visibilite: Visibilite, typeRetour: String, nom: String, parametres: List<Parametre>) {
        this.visibilite = visibilite
        this.typeRetour = typeRetour
        this.nom = nom

        parametres.forEach { parametre -> AjouterParametre(parametre) }
    }

    /**
     * Constructeur qui assigne la valeur par défaut pour tous les propriétés de la méthode
     *
     * @author Clément Provencher
     */
    constructor()

    /**
     * La visibilité de la méthode
     */
    var visibilite : Visibilite = Visibilite.private
        set(value) {
            field = value
        }

    /**
     * Le type de retour de la méthode
     */
    var typeRetour : String = ""
        set(value) {
            field = value
        }

    /**
     * Le nom de la méthode
     */
    var nom : String = ""
        set(value) {
            field = value
        }

    /**
     * Les paramètres de la méthode
     */
    val parametres : MutableList<Parametre> = mutableListOf()

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
