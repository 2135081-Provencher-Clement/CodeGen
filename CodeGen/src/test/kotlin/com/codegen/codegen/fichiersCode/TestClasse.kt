package com.codegen.codegen.fichiersCode

import com.codegen.codegen.composants.Constructeur
import com.codegen.codegen.composants.Methode
import com.codegen.codegen.composants.Propriete
import com.codegen.codegen.composants.Visibilite
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import java.security.InvalidParameterException

/**
 *  Tests pour la classe Classe
 *
 *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
 */
class TestClasse {
    private lateinit var classe: Classe

    /**
     *  Cette fonction s'exécute avant chaque fonction de test
     *  Elle initialize les composants necessaires aux tests
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @BeforeEach
    fun initalize() {
        classe = Classe()
    }

    /**
     *  Test l'ajout et le retrait de propriétés de la classe
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementProprietes() {
        classe.AjouterPropriete(Propriete())
        assertEquals(1, classe.proprietes.size, "Le nombre de propriétés dans la classe devrait être de 1")
        classe.RetirerPropriete(classe.proprietes[0])
        assertEquals(0, classe.proprietes.size, "Le nombre de propriétés dans la classe devrait être de 0")
    }

    /**
     *  Test l'ajout et le retrait de méthodes de la classe
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementMethodes() {
        classe.AjouterMethode(Methode())
        assertEquals(1, classe.methodes.size, "Le nombre de méthodes dans la classe devrait être de 1")
        classe.RetirerMethode(classe.methodes[0])
        assertEquals(0, classe.methodes.size, "Le nombre de méthodes dans la classe devrait être de 0")
    }

    /**
     *  Test l'ajout et le retrait de constructeurs de la classe
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testChangementConstructeurs() {
        classe.AjouterConstructeur(Constructeur())
        assertEquals(1, classe.constructeurs.size, "Le nombre de constructeurs dans la classe devrait être de 1")
        classe.RetirerConstructeur(classe.constructeurs[0])
        assertEquals(0, classe.constructeurs.size, "Le nombre de constructeurs dans la classe devrait être de 0")
    }

    /**
     *  Test si le système va lever une exception si la visibilité de la classe est privé
     *
     *  @author Cedric Garand - 2135500@etudiant.cegepvicto.ca
     */
    @Test
    fun testVisibilite() {
        assertThrows(
            InvalidParameterException::class.java,
            { classe.visibilite = Visibilite.private }, "InvalidParameterException devrait être lancé"
        )
    }
}
