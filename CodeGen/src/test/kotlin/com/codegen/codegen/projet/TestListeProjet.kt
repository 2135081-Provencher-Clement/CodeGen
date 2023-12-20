package com.codegen.codegen.projet

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

/**
 *  Tests pour la classe ListeProjet
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestListeProjet {
    private lateinit var listeProjet: ListeProjet

    /**
     *  Cette fonction s'exécute avant chaque fonction de test
     *  Elle initialize les composants necessaires aux tests
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @BeforeEach
    fun initalize() {
        listeProjet = ListeProjet()
    }

    /**
     *  Test l'ajout et le retrait de projets de la liste de projets
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementProjets() {
        listeProjet.AjouterProjet(Projet())
        assertEquals(1, listeProjet.listeProjet.size, "Le nombre de projets dans la liste de projets devrait être de 1")
        listeProjet.RetirerProjet(listeProjet.listeProjet[0])
        assertEquals(0, listeProjet.listeProjet.size, "Le nombre de projets dans la liste de projets devrait être de 0")
    }
}
