package com.codegen.codegen.serializerPersonnalisee.composants

import com.codegen.codegen.composants.Methode
import com.codegen.codegen.composants.Parametre
import com.codegen.codegen.composants.Visibilite
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * Serializer personnalisé pour la classe Méthode
 * Transforme une instance de la classe Méthode en Json, et vice-versa
 *
 * @author Clément Provencher
 */
object MethodeSerializer : KSerializer<Methode> {

    /**
     * Le descripteur, indique comment la méthode à été encodée et comment décoder la méthode
     * Élémentaire lors du choix de quel sérialiseur à prendre lors d'une désérialisation
     *
     * @author Clément Provencher
     */
    @OptIn(ExperimentalSerializationApi::class)
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("com.codegen.codegen.composants.Methode")
    {
        element("visibilite", Visibilite.serializer().descriptor)
        element("typeRetour", PrimitiveSerialDescriptor("typeRetour", PrimitiveKind.STRING))
        element("nom", PrimitiveSerialDescriptor("nom", PrimitiveKind.STRING))
        element("parametres", listSerialDescriptor(Parametre.serializer().descriptor)) // Généré par ChatGPT (Le 18 novembre 2023)
        element("virtuelle", PrimitiveSerialDescriptor("virtuelle", PrimitiveKind.BOOLEAN))
    }


    /**
     * Sérialise une méthode sous forme de Json
     *
     * @param encoder l'encodeur
     * @param value La méthode à encoder en Json
     *
     * @author Clément Provencher
     */
    override fun serialize(encoder: Encoder, value: Methode) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, Visibilite.serializer(), value.visibilite)
            encodeStringElement(descriptor, 1, value.typeRetour)
            encodeStringElement(descriptor, 2, value.nom)
            encodeSerializableElement(descriptor, 3, ListSerializer(Parametre.serializer()), value.parametres)
            encodeBooleanElement(descriptor, 4, value.virtuelle)
        }
    }

    /**
     * Désérailise un Json en Méthode
     *
     * @param decoder le décodeur
     * @return Le Json, une fois décodé sous forme de méthode
     *
     * @author Clément Provencher
     */
    override fun deserialize(decoder: Decoder): Methode {
        return  decoder.decodeStructure(descriptor) {
            var visibilite = Visibilite.private
            var typeRetour = ""
            var nom = ""
            var parametres = mutableListOf<Parametre>()
            var virtuelle = false

            // Pour chaque élément du Json, désérialise chaque propriété selon le sérializeur approprié
            while(true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> visibilite = decodeSerializableElement(descriptor, 0, Visibilite.serializer())
                    1 -> typeRetour = decodeStringElement(descriptor, 1)
                    2 -> nom = decodeStringElement(descriptor, 2)
                    3 -> parametres = decodeSerializableElement(descriptor, 3, ListSerializer(Parametre.serializer())).toMutableList()
                    4 -> virtuelle = decodeBooleanElement(descriptor, 4)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> throw SerializationException("Index inconnu : $index")
                }
            }

            Methode( visibilite, typeRetour, nom, parametres, virtuelle)
        }
    }

}
