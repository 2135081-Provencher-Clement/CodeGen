package com.codegen.codegen.composants

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

/**
 *  Tests pour la classe Constructeur
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestConstructeur {
    private lateinit var constructeur: Constructeur

    /**
     *  Cette fonction s'exécute avant chaque fonction de test
     *  Elle initialize les composants necessaires aux tests
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @BeforeEach
    fun initalize() {
        constructeur = Constructeur()
    }

    /**
     *  Test l'ajout et le retrait de propriétés du constructeur
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementProprietes() {
        constructeur.AjouterPropriete(Propriete())
        assertEquals(1, constructeur.proprietes.size, "Il devrait y avoir 1 propriété dans le constructeur")
        constructeur.RetirerPropriete(constructeur.proprietes[0])
        assertEquals(0, constructeur.proprietes.size, "Il devrait y avoir 0 propriétés dans le constructeur")
    }
}
