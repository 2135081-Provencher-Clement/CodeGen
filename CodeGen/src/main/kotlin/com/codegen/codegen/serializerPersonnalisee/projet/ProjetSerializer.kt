package com.codegen.codegen.serializerPersonnalisee.projet

import com.codegen.codegen.projet.Projet
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Serializer personnalisé pour la classe Projet
 * Transforme une instance de la classe Classe en Json, et vice-versa
 *
 * @author Clément Provencher
 */
object ProjetSerializer : KSerializer<Projet> {
    override val descriptor: SerialDescriptor
        get() = TODO("Not yet implemented")

    override fun serialize(encoder: Encoder, value: Projet) {
        TODO("Not yet implemented")
    }

    override fun deserialize(decoder: Decoder): Projet {
        TODO("Not yet implemented")
    }
}
