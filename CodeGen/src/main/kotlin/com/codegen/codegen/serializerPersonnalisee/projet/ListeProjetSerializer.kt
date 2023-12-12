package com.codegen.codegen.serializerPersonnalisee.projet

import com.codegen.codegen.projet.ListeProjet
import com.codegen.codegen.projet.Projet
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * Serializer personnalisé pour la classe ListeProjet
 * Transforme une instance de la classe ListeProjet en Json, et vice-versa
 *
 * @author Clément Provencher
 */
object ListeProjetSerializer : KSerializer<ListeProjet> {

    /**
     * Le descripteur, indique comment la liste de projets à été encodée et comment décoder la liste de projets
     * Élémentaire lors du choix de quel sérialiseur à prendre lors d'une désérialisation
     *
     * @author Clément Provencher
     */
    @OptIn(ExperimentalSerializationApi::class)
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("com.codegen.codegen.projet.Projet")
    {
        element("listeProjets", listSerialDescriptor(Projet.serializer().descriptor))
    }

    /**
     * Sérialise une liste de projets sous forme de Json
     *
     * @param encoder l'encodeur
     * @param value La liste de projet à encoder en Json
     *
     * @author Clément Provencher
     */
    override fun serialize(encoder: Encoder, value: ListeProjet) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, ListSerializer(Projet.serializer()), value.listeProjet)
        }
    }

    /**
     * Désérailise un Json en Liste de projets
     *
     * @param decoder le décodeur
     * @return Le Json, une fois décodé sous forme de liste de projets
     *
     * @author Clément Provencher
     */
    override fun deserialize(decoder: Decoder): ListeProjet {
        return  decoder.decodeStructure(descriptor) {
            var listeProjet : List<Projet> = listOf()
            // Pour chaque élément du Json, désérialise chaque propriété selon le sérializeur approprié
            while(true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> listeProjet = decodeSerializableElement(descriptor, 0, ListSerializer(Projet.serializer()))
                    CompositeDecoder.DECODE_DONE -> break
                    else -> throw SerializationException("Index inconnu : $index")
                }
            }

            ListeProjet(listeProjet)
        }
    }
}
