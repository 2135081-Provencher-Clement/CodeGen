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
 */
@Serializable
data class Classe(
    val visibilite: Visibilite,
    val proprietes: MutableList<Propriete> = mutableListOf(),
    val methodes: MutableList<Methode> = mutableListOf(),
    val constructeurs: MutableList<Constructeur> = mutableListOf() )
{

}
