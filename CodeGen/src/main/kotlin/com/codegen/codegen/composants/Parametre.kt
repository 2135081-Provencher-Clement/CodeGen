package com.codegen.codegen.composants

import kotlinx.serialization.Serializable

/**
 * structure pour un paramètre de méthode qui a un type et un nom
 *
 * @property type le type du paramètre
 * @property nom le nom du paramètre
 *
 * @author Clément Provencher
 */
@Serializable
data class Parametre(
    val type : String,
    val nom : String )
{

}
