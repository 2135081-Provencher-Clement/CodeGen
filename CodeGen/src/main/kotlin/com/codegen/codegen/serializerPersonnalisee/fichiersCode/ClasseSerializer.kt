package com.codegen.codegen.serializerPersonnalisee.fichiersCode

import com.codegen.codegen.composants.*
import com.codegen.codegen.fichiersCode.Classe
import com.codegen.codegen.fichiersCode.MotCleeClasse
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * Serializer personnalisé pour la classe Classe
 * Transforme une instance de la classe Classe en Json, et vice-versa
 *
 * @author Clément Provencher
 */
object ClasseSerializer : KSerializer<Classe> {

    /**
     * Le descripteur, indique comment la classe à été encodée et comment décoder la classe
     * Élémentaire lors du choix de quel sérialiseur à prendre lors d'une désérialisation
     *
     * @author Clément Provencher
     */
    @OptIn(ExperimentalSerializationApi::class)
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("com.codegen.codegen.composants.Classe")
    {
        element("visibilite", Visibilite.serializer().descriptor)
        element("nom", PrimitiveSerialDescriptor("nom", PrimitiveKind.STRING))
        element("motCleeClasse", MotCleeClasse.serializer().descriptor)
        element("proprietes", listSerialDescriptor(Propriete.serializer().descriptor))
        element("methodes", listSerialDescriptor(Methode.serializer().descriptor))
        element("constructeurs", listSerialDescriptor(Constructeur.serializer().descriptor))
    }

    /**
     * Sérialise une classe sous forme de Json
     *
     * @param encoder l'encodeur
     * @param value La classe à encoder en Json
     *
     * @author Clément Provencher
     */
    override fun serialize(encoder: Encoder, value: Classe) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, Visibilite.serializer(), value.visibilite)
            encodeStringElement(descriptor, 1, value.nom)
            encodeSerializableElement(descriptor, 2, MotCleeClasse.serializer(), value.motCleeClasse)
            encodeSerializableElement(descriptor, 3, ListSerializer(Propriete.serializer()), value.proprietes)
            encodeSerializableElement(descriptor, 4, ListSerializer(Methode.serializer()), value.methodes)
            encodeSerializableElement(descriptor, 5, ListSerializer(Constructeur.serializer()), value.constructeurs)
        }
    }

    /**
     * Désérailise un Json en Classe
     *
     * @param decoder le décodeur
     * @return Le Json, une fois décodé sous forme de classe
     *
     * @author Clément Provencher
     */
    override fun deserialize(decoder: Decoder): Classe {
        return decoder.decodeStructure(descriptor) {
            var visibilite = Visibilite.private
            var nom = ""
            var motCleeClasse = MotCleeClasse.classique
            var proprietes = mutableListOf<Propriete>()
            var methodes = mutableListOf<Methode>()
            var constructeurs = mutableListOf<Constructeur>()

            // Pour chaque élément du Json, désérialise chaque propriété selon le sérializeur approprié
            while(true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> visibilite = decodeSerializableElement(descriptor, 0, Visibilite.serializer())
                    1 -> nom = decodeStringElement(descriptor, 1)
                    2 -> motCleeClasse = decodeSerializableElement(descriptor, 2, MotCleeClasse.serializer())
                    3 -> proprietes = decodeSerializableElement(descriptor, 3, ListSerializer(Propriete.serializer())).toMutableList()
                    4 -> methodes = decodeSerializableElement(descriptor, 4, ListSerializer(Methode.serializer())).toMutableList()
                    5 -> constructeurs = decodeSerializableElement(descriptor, 5, ListSerializer(Constructeur.serializer())).toMutableList()
                    CompositeDecoder.DECODE_DONE -> break
                    else -> throw SerializationException("Index inconnu : $index")
                }
            }

            Classe(visibilite, nom, motCleeClasse, proprietes, methodes, constructeurs)
        }
    }
}
