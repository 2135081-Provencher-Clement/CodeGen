package com.codegen.codegen.composants

import com.codegen.codegen.serializerPersonnalisee.composants.VisibiliteSerializer
import kotlinx.serialization.Serializable

/**
 * enum pour les différentes visibilités possibles
 *
 * @author Clément Provencher
 */
@Serializable(with = VisibiliteSerializer::class)
enum class Visibilite {
    public,
    private,
    protected;
}
