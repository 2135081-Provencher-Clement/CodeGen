package com.codegen.codegen.serializerPersonnalisee.composants

import com.codegen.codegen.composants.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.*

/**
 * Serializer personnalisé pour la classe Constructeur
 * Transforme une instance de la classe Constructeur en Json, et vice-versa
 *
 * @author Clément Provencher
 */
object ConstructeurSerializer : KSerializer<Constructeur> {

    /**
     * Le descripteur, indique comment le constructeur à été encodée et comment décoder la constructeur
     * Élémentaire lors du choix de quel sérialiseur à prendre lors d'une désérialisation
     *
     * @author Clément Provencher
     */
    @OptIn(ExperimentalSerializationApi::class)
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("com.codegen.codegen.composants.Constructeur")
    {
        element("visibilite", Visibilite.serializer().descriptor)
        element("proprietes", listSerialDescriptor(Propriete.serializer().descriptor))
    }

    /**
     * Sérialise un constructeur sous forme de Json
     *
     * @param encoder l'encodeur
     * @param value Le constructeur à encoder en Json
     *
     * @author Clément Provencher
     */
    override fun serialize(encoder: Encoder, value: Constructeur) {
        encoder.encodeStructure(MethodeSerializer.descriptor) {
            encodeSerializableElement(MethodeSerializer.descriptor, 0, Visibilite.serializer(), value.visibilite)
            TODO("Sais pas comment encoder une liste d'éléments")
        }
    }

    /**
     * Désérailise un Json en Constructeur
     *
     * @param decoder le décodeur
     * @return Le Json, une fois décodé sous forme de constructeur
     *
     * @author Clément Provencher
     */
    override fun deserialize(decoder: Decoder): Constructeur {
        return  decoder.decodeStructure(MethodeSerializer.descriptor) {
            var visibilite = Visibilite.private
            var proprietes = mutableListOf<Propriete>()

            // Pour chaque élément du Json, désérialise chaque propriété selon le sérializeur approprié
            while(true) {
                when (val index = decodeElementIndex(MethodeSerializer.descriptor)) {
                    0 -> visibilite = decodeSerializableElement(MethodeSerializer.descriptor, 0, Visibilite.serializer())
                    1 -> TODO("Sais pas comment décoder une liste d'éléments")
                    CompositeDecoder.DECODE_DONE -> break
                    else -> throw SerializationException("Index inconnu : $index")
                }
            }

            Constructeur(visibilite,proprietes)
        }
    }
}
