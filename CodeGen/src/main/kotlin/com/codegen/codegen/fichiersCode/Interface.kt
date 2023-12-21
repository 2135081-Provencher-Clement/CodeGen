package com.codegen.codegen.fichiersCode

import com.codegen.codegen.composants.Methode
import com.codegen.codegen.composants.Propriete
import com.codegen.codegen.composants.Visibilite
import com.codegen.codegen.serializerPersonnalisee.fichiersCode.InterfaceSerializer
import kotlinx.serialization.Serializable
import java.security.InvalidParameterException

/**
 * structure d'information pour une interface
 * une interface contient :
 * une visibilité
 * un nom
 * une liste de propriété
 * une liste de méthodes
 *
 * @property visibilite la visibilite de l'interface
<<<<<<< HEAD
 * @property nom le nom de l'interface
=======
 * @property nom le nom de la classe
>>>>>>> dev
 * @property proprietes la liste des propriétés de l'interface
 * @property methodes la liste des méthodes de l'interface
 *
 * @author Clément Provencher
 */
@Serializable(with = InterfaceSerializer::class)
class Interface {

    /**
     * Constructeur qui assigne tous les propriétés de l'interface
     *
     * @param visibilite La visibilité de la classe (ne doit pas être privée)
<<<<<<< HEAD
     * @param nom Le nom de l'interface
=======
     * @param nom Le nom de la classe
>>>>>>> dev
     * @param proprietes La liste des propriétés de l'interface (ces propriétés ne doivent pas être privées)
     * @param methodes La liste des méthodes de l'interface (ces méthodes ne doivent pas être privées)
     *
     * @author Clément Provencher
     */
    constructor(visibilite: Visibilite, nom: String, proprietes: List<Propriete>, methodes: List<Methode>)
    {
        this.visibilite = visibilite
        this.nom = nom

        proprietes.forEach{ propriete -> AjouterPropriete(propriete) }
        methodes.forEach { methode -> AjouterMethode(methode) }
    }

    /**
     * Constructeur sans paramètres qui assigne les valeurs par défaut
     *
     * @author Clément Provencher
     */
    constructor()

    /**
     * La visibilité de l'interface
     *
     * Une interface ne peut pas être privée, une exception sera lançé si on tente de la mettre privée
     */
    var visibilite: Visibilite = Visibilite.public
        set(value) {
            if(value == Visibilite.private)
                throw InvalidParameterException("Une interface ne peut pas être privée")

            field = value
        }

    /**
     * Le nom de l'interface
     */
    var nom: String = ""
        set(value) {
            field = value
        }

    /**
     * La liste des propriétés de la classe
     *
     * Ces dernières ne peuvent pas être privées
     */
    val proprietes: MutableList<Propriete> = mutableListOf()

    /**
     * La liste des méthodes de la classe
     *
     * Ces dernières ne peuvent pas être privées
     */
    val methodes: MutableList<Methode> = mutableListOf()

    /**
     * Ajoute une propriété à la liste de propriétés de la classe
     *
     * Vérifie d'abbord si la propriété est privée, si oui, lance une exception
     *
     * @param propriete La propriété à ajouter (ne doit pas être privée)
     *
     * @author Clément Provencher
     */
    fun AjouterPropriete(propriete: Propriete) {

        if(propriete.visibilite == Visibilite.private)
            throw InvalidParameterException("Une propriété d'interface ne peut pas être privée")

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
     * Vérifie d'abbord si la méthode est privée, si oui, lance une exception
     *
     * @param methode La méthode à ajouter
     *
     * @author Clément Provencher
     */
    fun AjouterMethode(methode: Methode) {

        if(methode.visibilite == Visibilite.private)
            throw InvalidParameterException("Une méthode d'interface ne peut pas être privée")

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
}
