package com.codegen.codegen.serializerPersonnalisee.composants

import com.codegen.codegen.composants.Propriete
import com.codegen.codegen.composants.Visibilite
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.*

import kotlinx.serialization.encoding.*

/**
 * Serializer personnalisé pour la classe Propriété
 * Transforme la classe propriété en Json, et vice-versa
 *
 * La grande majorité de cet objet à été généré avec l'aide de ChatGPT (le 10 novembre 2023)
 *
 * @author Clément Provencher
 */
object ProprieteSerializer : KSerializer<Propriete> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("com.codegen.codegen.composants.Propriete")
    {
        element("visibilite", Visibilite.serializer().descriptor)
        element("type", PrimitiveSerialDescriptor("type", PrimitiveKind.STRING))
        element("nom", PrimitiveSerialDescriptor("type", PrimitiveKind.STRING))
    }

    override fun serialize(encoder: Encoder, value: Propriete) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, Visibilite.serializer(), value.visibilite)
            encodeStringElement(descriptor, 1, value.type)
            encodeStringElement(descriptor, 2, value.nom)
        }
    }

    override fun deserialize(decoder: Decoder): Propriete {
        return decoder.decodeStructure(descriptor) {
            var visibilite = Visibilite.public
            var type = ""
            var nom = ""

            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> visibilite = decodeSerializableElement(descriptor, 0, Visibilite.serializer())
                    1 -> type = decodeStringElement(descriptor, 1)
                    2 -> nom = decodeStringElement(descriptor, 2)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> throw SerializationException("Unknown index $index")
                }
            }

            Propriete()
        }
    }
}
