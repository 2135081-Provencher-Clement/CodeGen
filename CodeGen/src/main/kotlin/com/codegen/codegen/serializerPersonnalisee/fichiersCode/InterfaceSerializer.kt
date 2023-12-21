package com.codegen.codegen.serializerPersonnalisee.fichiersCode

import com.codegen.codegen.composants.Constructeur
import com.codegen.codegen.composants.Methode
import com.codegen.codegen.composants.Propriete
import com.codegen.codegen.composants.Visibilite
import com.codegen.codegen.fichiersCode.Classe
import com.codegen.codegen.fichiersCode.Interface
import com.codegen.codegen.fichiersCode.MotCleeClasse
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*


/**
 * Serializer personnalisé pour la classe Interface
 * Transforme une instance de la classe Interface en Json, et vice-versa
 *
 * @author Clément Provencher
 */
object InterfaceSerializer : KSerializer<Interface> {

    /**
     * Le descripteur, indique comment la classe à été encodée et comment décoder la classe
     * Élémentaire lors du choix de quel sérialiseur à prendre lors d'une désérialisation
     *
     * @author Clément Provencher
     */
    @OptIn(ExperimentalSerializationApi::class)
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("com.codegen.codegen.composants.Interface")
    {
        element("visibilite", Visibilite.serializer().descriptor)
        element("nom", PrimitiveSerialDescriptor("nom", PrimitiveKind.STRING))
        element("proprietes", listSerialDescriptor(Propriete.serializer().descriptor))
        element("methodes", listSerialDescriptor(Methode.serializer().descriptor))
    }

    /**
     * Sérialise une interface sous forme de Json
     *
     * @param encoder l'encodeur
     * @param value L'interface à encoder en Json
     *
     * @author Clément Provencher
     */
    override fun serialize(encoder: Encoder, value: Interface) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, Visibilite.serializer(), value.visibilite)
            encodeStringElement(descriptor, 1, value.nom)
            encodeSerializableElement(descriptor, 2, ListSerializer(Propriete.serializer()), value.proprietes)
            encodeSerializableElement(descriptor, 3, ListSerializer(Methode.serializer()), value.methodes)
        }
    }

    /**
     * Désérailise un Json en interface
     *
     * @param decoder le décodeur
     * @return Le Json, une fois décodé sous forme d'interface
     *
     * @author Clément Provencher
     */
    override fun deserialize(decoder: Decoder): Interface {
        return  decoder.decodeStructure(descriptor) {
            var visibilite = Visibilite.private
            var nom = ""
            var proprietes = mutableListOf<Propriete>()
            var methodes = mutableListOf<Methode>()

            // Pour chaque élément du Json, désérialise chaque propriété selon le sérializeur approprié
            while(true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> visibilite = decodeSerializableElement(descriptor, 0, Visibilite.serializer())
                    1 -> nom = decodeStringElement(descriptor, 1)
                    2 -> proprietes = decodeSerializableElement(descriptor, 2, ListSerializer(Propriete.serializer())).toMutableList()
                    3 -> methodes = decodeSerializableElement(descriptor, 3, ListSerializer(Methode.serializer())).toMutableList()
                    CompositeDecoder.DECODE_DONE -> break
                    else -> throw SerializationException("Index inconnu : $index")
                }
            }

            Interface(visibilite, nom, proprietes, methodes)
        }
    }
}
