package com.codegen.codegen.projet

import com.codegen.codegen.composants.Methode
import com.codegen.codegen.composants.Propriete
import com.codegen.codegen.composants.Visibilite
import com.codegen.codegen.fichiersCode.Classe
import com.codegen.codegen.fichiersCode.Interface
import kotlinx.serialization.Serializable
import java.security.InvalidParameterException

/**
 * structure d'information pour un projet
 * un projet contient :
 *  un nom
 *  une liste de classes
 *  une liste d'interfaces
 *
 * @property nom le nom du projet
 * @property classes La liste des classes du projet
 * @property interfaces La liste des interfaces du projet
 *
 * @author Clément Provencher
 */
@Serializable
class Projet {

    /**
     * Constructeur du projet qui assigne une valeur à chaque propriété du projet
     *
     * @param nom Le nom du projet
     * @param classes La liste des classes du projet
     * @param interfaces La liste des interfaces du projet
     *
     * @author Clément Provencher
     */
    constructor(nom: String, classes : List<Classe>, interfaces : List<Interface>)
    {
        this.nom = nom
        classes.forEach { classe -> AjouterClasse(classe) }
        interfaces.forEach { interfacee -> AjouterInterface(interfacee) }
    }

    /**
     * Constructeur du projet qui laisse les propriétés à leur valeur par défaut
     */
    constructor()

    /**
     * Le nom de la classe
     */
    var nom: String = ""
        set(value) {
            field = value
        }

    /**
     * Liste des classes du projet
     */
    val classes : MutableList<Classe> = mutableListOf()

    /**
     * Liste des interfaces du projet
     */
    val interfaces : MutableList<Interface> = mutableListOf()

    /**
     * Ajoute une classe à la liste de classes du projet
     *
     * La classe ne peut pas être privée
     * Si elle l'est, une erreur sera lancée
     *
     * @param classe La classe à ajouter
     *
     * @author Clément Provencher
     */
    fun AjouterClasse(classe: Classe) {

        if(classe.visibilite == Visibilite.private)
            throw InvalidParameterException("Une classe ne peut pas être privée")

        classes.add(classe)
    }

    /**
     * Retire une classe de la liste de classes du projet
     *
     * @param classe la classe à retirer
     * @return un Boolean qui est true si la suppression s'est bien effectuée, ou false sinon
     *
     * @author Clément Provencher
     */
    fun RetirerClasse(classe: Classe): Boolean {
        return classes.remove(classe)
    }

    /**
     * Ajoute une interface à la liste d'interfaces du projet
     *
     * l'interface ne peut pas avoir une visibilité privée
     * Si c'est le cas, une erreur sera lancée
     *
     * le paramètre ne pouvais pas se nommer interface (probablement un nom réservé)
     * donc il se nomme interfacee
     *
     * @param interfacee L'interface à ajouter
     *
     * @author Clément Provencher
     */
    fun AjouterInterface(interfacee : Interface) {

        if(interfacee.visibilite == Visibilite.private)
            throw InvalidParameterException("Une interface ne peut pas être privée")

        interfaces.add(interfacee)
    }

    /**
     * Retire une interface de la liste d'interfaces du projet
     *
     * le paramètre ne pouvais pas se nommer interface (probablement un nom réservé)
     * donc il se nomme interfacee
     *
     * @param interfacee l'interface à retirer
     * @return un Boolean qui est true si la suppression s'est bien effectuée, ou false sinon
     *
     * @author Clément Provencher
     */
    fun RetirerInterface(interfacee: Interface): Boolean {
        return interfaces.remove(interfacee)
    }
}
