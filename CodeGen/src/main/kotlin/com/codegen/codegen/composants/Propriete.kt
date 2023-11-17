package com.codegen.codegen.composants

import com.codegen.codegen.serializerPersonnalisee.composants.ProprieteSerializer
import kotlinx.serialization.Serializable

/**
 * structure pour les informations d'une propriété
 * une propriété à un type, un nom et une visibilité
 *
 * @property visibilite la visibilité de la propriété
 * @property type le type de la propriété
 * @property nom le nom de la propriété
 *
 * @author Clément Provencher
 */
@Serializable(with = ProprieteSerializer::class)
class Propriete()
{
    var visibilite : Visibilite = Visibilite.private
    var type : String = ""
    var nom : String = ""
}
