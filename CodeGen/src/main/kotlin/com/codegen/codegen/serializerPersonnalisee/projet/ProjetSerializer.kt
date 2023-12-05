package com.codegen.codegen.serializerPersonnalisee.projet

import com.codegen.codegen.fichiersCode.Classe
import com.codegen.codegen.fichiersCode.Interface
import com.codegen.codegen.projet.Projet
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * Serializer personnalisé pour la classe Projet
 * Transforme une instance de la classe Classe en Json, et vice-versa
 *
 * @author Clément Provencher
 */
object ProjetSerializer : KSerializer<Projet> {

    /**
     * Le descripteur, indique comment le projet à été encodée et comment décoder le projet
     * Élémentaire lors du choix de quel sérialiseur à prendre lors d'une désérialisation
     *
     * @author Clément Provencher
     */
    @OptIn(ExperimentalSerializationApi::class)
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("com.codegen.codegen.projet.Projet")
    {
        element("nom", PrimitiveSerialDescriptor("nom", PrimitiveKind.STRING))
        element("classes", listSerialDescriptor(Classe.serializer().descriptor))
        element("interfaces", listSerialDescriptor(Interface.serializer().descriptor))
    }

    /**
     * Sérialise un projet sous forme de Json
     *
     * @param encoder l'encodeur
     * @param value Le projet à encoder en Json
     *
     * @author Clément Provencher
     */
    override fun serialize(encoder: Encoder, value: Projet) {
        encoder.encodeStructure(descriptor) {
            encodeStringElement(descriptor, 0, value.nom)
            encodeSerializableElement(descriptor, 1, ListSerializer(Classe.serializer()), value.classes)
            encodeSerializableElement(descriptor, 2, ListSerializer(Interface.serializer()), value.interfaces)
        }
    }

    /**
     * Désérailise un Json en Projet
     *
     * @param decoder le décodeur
     * @return Le Json, une fois décodé sous forme de projet
     *
     * @author Clément Provencher
     */
    override fun deserialize(decoder: Decoder): Projet {
        return  decoder.decodeStructure(descriptor) {
            var nom = ""
            var classes = mutableListOf<Classe>()
            var interfaces = mutableListOf<Interface>()

            // Pour chaque élément du Json, désérialise chaque propriété selon le sérializeur approprié
            while(true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> nom = decodeStringElement(descriptor, 0)
                    1 -> classes = decodeSerializableElement(descriptor, 1, ListSerializer(Classe.serializer())).toMutableList()
                    2 -> interfaces = decodeSerializableElement(descriptor, 2, ListSerializer(Interface.serializer())).toMutableList()
                    CompositeDecoder.DECODE_DONE -> break
                    else -> throw SerializationException("Index inconnu : $index")
                }
            }

            Projet(nom, classes, interfaces)
        }
    }
}
