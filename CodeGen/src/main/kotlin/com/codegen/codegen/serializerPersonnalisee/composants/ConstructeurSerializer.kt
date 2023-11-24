package com.codegen.codegen.serializerPersonnalisee.composants

import com.codegen.codegen.composants.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ArraySerializer
import kotlinx.serialization.builtins.ListSerializer
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
     * Solution pour sérialisation de liste trouvée avec aide de ChatGPT (24 novembre 2023)
     *
     * @param encoder l'encodeur
     * @param value Le constructeur à encoder en Json
     *
     * @author Clément Provencher
     */
    override fun serialize(encoder: Encoder, value: Constructeur) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, Visibilite.serializer(), value.visibilite)
            encodeSerializableElement(descriptor, 1, ListSerializer(Propriete.serializer()), value.proprietes)
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
        return  decoder.decodeStructure(descriptor) {
            var visibilite = Visibilite.private
            var proprietes = mutableListOf<Propriete>()

            // Pour chaque élément du Json, désérialise chaque propriété selon le sérializeur approprié
            while(true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> visibilite = decodeSerializableElement(descriptor, 0, Visibilite.serializer())
                    1 -> proprietes = decodeSerializableElement(descriptor, 1, ListSerializer(Propriete.serializer())).toMutableList()
                    CompositeDecoder.DECODE_DONE -> break
                    else -> throw SerializationException("Index inconnu : $index")
                }
            }

            Constructeur(visibilite,proprietes)
        }
    }
}
