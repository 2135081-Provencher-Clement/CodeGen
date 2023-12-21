package com.codegen.codegen.composants

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

/**
 *  Tests pour la classe Methode
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestMethode {
    private lateinit var methode: Methode

    /**
     *  Cette fonction s'exécute avant chaque fonction de test
     *  Elle initialize les composants necessaires aux tests
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @BeforeEach
    fun initalize() {
        methode = Methode()
    }

    /**
     *  Test l'ajout et le retrait de paramètres de la méthode
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementParametre() {
        methode.AjouterParametre(Parametre())
        assertEquals(1, methode.parametres.size, "Le nombre de paramètres dans la méthode devrait être 1")
        methode.RetirerParametre(methode.parametres[0])
        assertEquals(0, methode.parametres.size, "Le nombre de paramètres dans la méthode devrait être 0")
    }
}
