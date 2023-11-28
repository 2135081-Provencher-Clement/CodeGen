package com.codegen.codegen.serializerPersonnalisee.composants

import com.codegen.codegen.composants.Visibilite
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Serializer personnalisé pour la classe Visibilité
 * Transforme l'enum Visibilité en string, et vice-versa
 *
 * La grande majorité de cet objet à été généré avec l'aide de ChatGPT (le 10 novembre 2023)
 *
 * @author Clément Provencher
 */
object VisibiliteSerializer : KSerializer<Visibilite> {

    /**
     * Le descripteur, indique comment la visibilité à été encodée et comment décoder la visibilité
     * Élémentaire lors du choix de quel sérialiseur à prendre lors d'une désérialisation
     */
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Visibilite", PrimitiveKind.STRING)

    /**
     * Sérialise une visibilité en format string
     *
     * @param encoder L'encodeur
     * @param value La valeur de la visibilité à encoder
     *
     * @author Clément Provencher
     */
    override fun serialize(encoder: Encoder, value: Visibilite) {
        encoder.encodeString(value.name)
    }

    /**
     * Désérialise une visibilité à partir d'un string
     *
     * @param decoder Le décodeur
     * @return La visibilité sous forme d'enum
     *
     * @author Clément Provencher
     */
    override fun deserialize(decoder: Decoder): Visibilite {
        return when (val value = decoder.decodeString()) {
            "public" -> Visibilite.public
            "private" -> Visibilite.private
            "protected" -> Visibilite.protected
            else -> throw SerializationException("Valeur de visibilité inconnue : $value")
        }
    }
}

