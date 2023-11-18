package com.codegen.codegen.serializerPersonnalisee.composants

import com.codegen.codegen.composants.Parametre
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.*

/**
 * Serializer personnalisé pour la classe Paramètre
 * Transforme une instance de la classe paramètre en Json, et vice-versa
 *
 * @author Clément Provencher
 */
object ParametreSerializer : KSerializer<Parametre> {

    /**
     * Le descripteur, indique comment le paramètre à été encodée et comment décoder le paramètre
     * Élémentaire lors du choix de quel sérialiseur à prendre lors d'une désérialisation
     *
     * @author Clément Provencher
     */
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("com.codegen.codegen.composants.Parametre")
    {
        element("type", PrimitiveSerialDescriptor("type", PrimitiveKind.STRING))
        element("nom", PrimitiveSerialDescriptor("nom", PrimitiveKind.STRING))
    }

    /**
     * Sérialise un paramètre sous forme de Json
     *
     * @param encoder l'encodeur
     * @param value Le paramètre à encoder en Json
     *
     * @author Clément Provencher
     */
    override fun serialize(encoder: Encoder, value: Parametre) {
        encoder.encodeStructure(descriptor) {
            encodeStringElement(descriptor, 0, value.type)
            encodeStringElement(descriptor, 1, value.nom)
        }
    }

    /**
     * Désérailise un Json en Paramètre
     *
     * @param decoder le décodeur
     * @return Le Json, une fois décodé sous forme de paramètre
     *
     * @author Clément Provencher
     */
    override fun deserialize(decoder: Decoder): Parametre {
        return decoder.decodeStructure(descriptor) {
            var type = ""
            var nom = ""

            // Pour chaque élément du Json, désérialise chaque propriété selon le sérializeur approprié
            while(true) {
                when(val index = decodeElementIndex(descriptor)) {
                    0 -> type = decodeStringElement(descriptor, 0)
                    1 -> nom = decodeStringElement(descriptor, 1)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> throw  SerializationException("Index inconnu : $index")
                }
            }

            Parametre(type, nom)
        }
    }
}
