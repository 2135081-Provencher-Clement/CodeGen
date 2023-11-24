package com.codegen.codegen.fichiersCode

import com.codegen.codegen.composants.Constructeur
import com.codegen.codegen.composants.Methode
import com.codegen.codegen.composants.Propriete
import com.codegen.codegen.composants.Visibilite
import kotlinx.serialization.Serializable

/**
 * structure d'information pour une classe
 * une classe contient :
 *  une visibilité
 *  une liste de propriété,
 *  une liste de méthodes et
 *  une liste de constructeur
 *
 * @property visibilite la visibilite de la classe
 * @property proprietes la liste des propriétés de la classe
 * @property methodes la liste des méthodes de la classe
 * @property constructeurs la liste des constructeurs de la classe
 *
 * @author Clément Provencher
 */
@Serializable
class Classe
{
    /**
     * Constructeur de la classe qui assigne tous les propriétés
     *
     * @param visibilite La visibilité de la classe
     * @param proprietes La liste des propriétés de la classe
     * @param methodes La liste des méthodes de la classe
     * @param constructeurs La liste des constructeurs de la classe
     *
     * @author Clément Provencher
     */
    constructor(visibilite: Visibilite, proprietes: List<Propriete>, methodes: List<Methode>, constructeurs: List<Constructeur>)
    {
        this.visibilite = visibilite

        proprietes.forEach { propriete -> AjouterPropriete(propriete)}
        methodes.forEach { methode -> AjouterMethode(methode) }
        constructeurs.forEach { constructeur -> AjouterConstructeur(constructeur) }
    }

    /**
     * Constructeur de la classe qui laisse les propriétés à leur valeur par défaut
     */
    constructor()

    /**
     * La visibilité de la classe
     */
    var visibilite: Visibilite = Visibilite.public
        set(value) {
            field = value
        }

    /**
     * La liste des propriétés de la classe
     */
    val proprietes: MutableList<Propriete> = mutableListOf()

    /**
     * La liste des méthodes de la classe
     */
    val methodes: MutableList<Methode> = mutableListOf()

    /**
     * La liste des constructeurs de la classe
     */
    val constructeurs: MutableList<Constructeur> = mutableListOf()

    /**
     * Ajoute une propriété à la liste de propriétés de la classe
     *
     * @param propriete La propriété à ajouter
     *
     * @author Clément Provencher
     */
    fun AjouterPropriete(propriete: Propriete) {
        proprietes.add(propriete)
    }

    /**
     * Retire une propriété de la liste de propriétés de la classe
     *
     * @param propriete la propriété à retirer
     * @return un Boolean qui est true si la suppression s'est bien effectuée, ou false sinon
     *
     * @author Clément Provencher
     */
    fun RetirerPropriete(propriete: Propriete): Boolean {
        return proprietes.remove(propriete)
    }

    /**
     * Ajoute une méthode à la liste de méthodes de la classe
     *
     * @param methode La méthode à ajouter
     *
     * @author Clément Provencher
     */
    fun AjouterMethode(methode: Methode) {
        methodes.add(methode)
    }

    /**
     * Retire une methode de la liste de methodes de la classe
     *
     * @param methode la méthode à retirer
     * @return un Boolean qui est true si la suppression s'est bien effectuée, ou false sinon
     *
     * @author Clément Provencher
     */
    fun RetirerMethode(methode: Methode): Boolean {
        return methodes.remove(methode)
    }

    /**
     * Ajoute un constructeur à la liste de constructeurs de la classe
     *
     * @param constructeur Le constructeur à ajouter
     *
     * @author Clément Provencher
     */
    fun AjouterConstructeur(constructeur: Constructeur) {
        constructeurs.add(constructeur)
    }

    /**
     * Retire un constructeur de la liste de constructeurs de la classe
     *
     * @param constructeur le constructeur à retirer
     * @return un Boolean qui est true si la suppression s'est bien effectuée, ou false sinon
     *
     * @author Clément Provencher
     */
    fun RetirerConstructeur(constructeur: Constructeur): Boolean {
        return constructeurs.remove(constructeur)
    }
}
