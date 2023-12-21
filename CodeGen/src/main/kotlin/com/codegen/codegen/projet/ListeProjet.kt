package com.codegen.codegen.projet

import com.codegen.codegen.serializerPersonnalisee.projet.ListeProjetSerializer
import kotlinx.serialization.Serializable

/**
 * structure d'information pour un projet
 * un projet contient :
 *  une liste de projet
 *
 * @property listeProjet La liste des projets
 *
 * @author Clément Provencher
 */
@Serializable(with = ListeProjetSerializer::class)
class ListeProjet {

    /**
     * Constructeur de la liste de projets
     * recoit et assigne la liste de projets
     *
     * @param listeProjet La liste des projets
     *
     * @author Clément Provencher
     */
    constructor(listeProjet: List<Projet>)
    {
        listeProjet.forEach { projet -> AjouterProjet(projet) }
    }

    /**
     * Constructeur par défaut de la liste de projets
     */
    constructor()

    /**
     * La liste de projets
     */
    val listeProjet : MutableList<Projet> = mutableListOf()

    /**
     * Ajoute un projet à la liste de projets
     *
     * @param projet Le projet à ajouter
     *
     * @author Clément Provencher
     */
    fun AjouterProjet(projet: Projet) {
        listeProjet.add(projet)
    }

    /**
     * Retire un projet de la liste de projets
     *
     * @param projet le projet à retirer
     * @return un Boolean qui est true si la suppression s'est bien effectuée, ou false sinon
     *
     * @author Clément Provencher
     */
    fun RetirerProjet(projet: Projet): Boolean {
        return listeProjet.remove(projet)
    }
}
