package com.codegen.codegen.serializerPersonnalisee.fichiersCode

import com.codegen.codegen.fichiersCode.MotCleeClasse
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Serializer personnalisé pour l'enum Mot Clée Classe
 * Transforme l'enum MotCleeClasse en string, et vice-versa
 *
 * @author Clément Provencher
 */
object MotCleeClasseSerializer : KSerializer<MotCleeClasse> {

    /**
     * Le descripteur, indique comment le mot clée de la classe à été encodée et comment décoder le mot clée de la classe
     * Élémentaire lors du choix de quel sérialiseur à prendre lors d'une désérialisation
     */
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("MotCleeClasse", PrimitiveKind.STRING)

    /**
     * Sérialize un mot clée de classe en string
     *
     * @param encoder l'encodeur
     * @param value la valeur à encoder
     *
     * @author Clément Provencher
     */
    override fun serialize(encoder: Encoder, value: MotCleeClasse) {
        encoder.encodeString(value.name)
    }

    /**
     * Désérialize un mot clée de classe à partir d'un string
     *
     * @param decoder le décodeur
     * @return la valeur décodée
     *
     * @author Clément Provencher
     */
    override fun deserialize(decoder: Decoder): MotCleeClasse {
        return when (val value = decoder.decodeString()) {
            "classique" -> MotCleeClasse.classique
            "sealed" -> MotCleeClasse.sealed
            "abstract" -> MotCleeClasse.abstract
            "static" -> MotCleeClasse.static
            else -> throw SerializationException("Valeur de mot clée de classe inconnue : $value")
        }
    }
}
