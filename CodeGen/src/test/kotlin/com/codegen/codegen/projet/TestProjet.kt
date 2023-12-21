package com.codegen.codegen.projet

import com.codegen.codegen.fichiersCode.Classe
import com.codegen.codegen.fichiersCode.Interface
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

/**
 *  Tests pour la classe Projet
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestProjet {
    private lateinit var projet: Projet

    /**
     *  Cette fonction s'exécute avant chaque fonction de test
     *  Elle initialize les composants necessaires aux tests
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @BeforeEach
    fun initalize() {
        projet = Projet()
    }

    /**
     *  Test l'ajout et le retrait de classes du projet
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementClasses() {
        projet.AjouterClasse(Classe())
        assertEquals(1, projet.classes.size, "Le nombre de classes dans le projet devrait être de 1")
        projet.RetirerClasse(projet.classes[0])
        assertEquals(0, projet.classes.size, "Le nombre de classes dans le projet devrait être de 0")
    }

    /**
     *  Test l'ajout et le retrait d'interfaces du projet
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementInterfaces() {
        projet.AjouterInterface(Interface())
        assertEquals(1, projet.interfaces.size, "Le nombre d'interfaces dans le projet devrait être de 1")
        projet.RetirerInterface(projet.interfaces[0])
        assertEquals(0, projet.interfaces.size, "Le nombre d'interfaces dans le projet devrait être de 0")
    }
}
