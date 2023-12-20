package com.codegen.codegen.fichiersCode

import com.codegen.codegen.composants.Methode
import com.codegen.codegen.composants.Propriete
import com.codegen.codegen.composants.Visibilite
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.security.InvalidParameterException

/**
 *  Tests pour la classe Interface
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestInterface {
    private lateinit var uneInterface: Interface

    /**
     *  Cette fonction s'exécute avant chaque fonction de test
     *  Elle initialize les composants necessaires aux tests
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @BeforeEach
    fun initalize() {
        uneInterface = Interface()
        uneInterface.visibilite = Visibilite.public
    }

    /**
     *  Test l'ajout et le retrait de propriétés de l'interface
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementProprietes() {
        val propriete = Propriete()
        propriete.visibilite = Visibilite.public
        uneInterface.AjouterPropriete(propriete)
        assertEquals(1, uneInterface.proprietes.size, "Le nombre de propriétés dans l'interface devrait être de 1")
        uneInterface.RetirerPropriete(uneInterface.proprietes[0])
        assertEquals(0, uneInterface.proprietes.size, "Le nombre de propriétés dans l'interface devrait être de 0")
    }

    /**
     *  Test l'ajout et le retrait de méthodes de l'interface
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementMethodes() {
        val methode = Methode()
        methode.visibilite = Visibilite.public
        uneInterface.AjouterMethode(methode)
        assertEquals(1, uneInterface.methodes.size, "Le nombre de méthodes dans l'interface devrait être de 1")
        uneInterface.RetirerMethode(uneInterface.methodes[0])
        assertEquals(0, uneInterface.methodes.size, "Le nombre de méthodes dans l'interface devrait être de 0")
    }

    /**
     *  Test si le système va lever une exception si la visibilité de l'interface est privé
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testVisibilite() {
        assertThrows(
            InvalidParameterException::class.java,
            { uneInterface.visibilite = Visibilite.private }, "InvalidParameterException devrait être lancé"
        )
    }
}
