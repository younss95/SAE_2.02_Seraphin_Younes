package testsmodule;

import static org.junit.Assert.assertEquals;

import modele.Position;
import modele.Temple;
import modele.Cristal;
import org.junit.Before;
import org.junit.Test;

public class TempleTest {
    private Temple temple;


    /**
     * Configure le test.
     * Cette méthode est appelée avant chaque méthode de test pour initialiser l'instance de `Temple` avec des valeurs spécifiques.
     */
    @Before
    public void setUp() {
        Position position = new Position(10, 10);
        Integer couleur = 6;
        Cristal cristal = new Cristal(6);
        temple = new Temple(position, couleur, cristal);
    }

    /**
     * Teste la méthode getPosiTemple.
     * Vérifie si la position du temple est correctement récupérée.
     */

    @Test
    public void testGetPosiTemple() {
        assertEquals(new Position(10,10), temple.getPosiTemple());
    }


    /**
     * Teste la méthode getCoulTemple.
     * Vérifie si la couleur du temple est correctement récupérée.
     */
    @Test
    public void testGetCoulTemple() {
        assertEquals(6, temple.getCoulTemple());
    }

    /**
     * Teste la méthode getCristal.
     * Vérifie si le cristal du temple est correctement récupéré.
     */
    @Test
    public void testGetCristal() {
        assertEquals(new Cristal(6), temple.getCristal());
    }

    /**
     * Teste la méthode toString.
     * Vérifie si la représentation sous forme de chaîne de caractères du temple est correcte.
     */
    @Test
    public void testToString() {
        String expectedString = "{Posi : " + temple.getPosiTemple() + " ; CoulTemple : " + temple.getCoulTemple() + " ; Cristal : " + temple.getCristal() + "}";
        assertEquals(expectedString, temple.toString());
    }

}
