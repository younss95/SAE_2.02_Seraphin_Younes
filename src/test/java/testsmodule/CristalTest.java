package testsmodule;

import static org.junit.Assert.assertEquals;

import modele.Cristal;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * La classe `CristalTest` contient des tests unitaires pour la classe `Cristal`.
 */
public class CristalTest {
    private Cristal cristal;

    /**
     * Configure le test.
     * Cette méthode est appelée avant chaque méthode de test pour initialiser l'instance de `Cristal` avec une couleur de cristal spécifique.
     */
    @Before
    public void setUp() {
        cristal = new Cristal(6);
    }

    /**
     * Teste la méthode setCoulCristal.
     * Vérifie si la couleur du cristal est correctement définie.
     */
    @Test
    public void testSetCoulCristal() {
        cristal.setCoulCristal(6);
        assertEquals(6, cristal.getCoulCristal());
    }

    /**
     * Teste la méthode equalsCoul.
     * Vérifie si la méthode renvoie true lorsque la couleur du cristal correspond à la couleur du paramètre et false sinon.
     */
    @Test
    public void testEqualsCoul() {
        // Test lorsque la couleur du cristal correspond à la couleur du paramètre
        assertTrue(cristal.equalsCoul(6));

        // Test lorsque la couleur du cristal ne correspond pas à la couleur du paramètre
        assertFalse(cristal.equalsCoul(55)); // Remplacez par une autre valeur de couleur
    }

    /**
     * Teste la méthode getCoulCristal.
     * Vérifie si la couleur du cristal est correctement récupérée.
     */
    @Test
    public void testGetCoulCristal() {
        assertEquals(6, cristal.getCoulCristal());
    }

    /**
     * Teste la méthode toString.
     * Vérifie si la représentation sous forme de chaîne de caractères du cristal est correcte.
     */
    @Test
    public void testToString() {
        assertEquals("Couleur du cristal : " + cristal.getCoulCristal(), cristal.toString());
    }
}
