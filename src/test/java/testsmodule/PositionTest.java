package testsmodule;

import static org.junit.Assert.assertEquals;

import modele.Position;
import org.junit.Before;
import org.junit.Test;

/**
 * La classe `PositionTest` contient des tests unitaires pour la classe `Position`.
 */
public class PositionTest {
    private Position position;

    /**
     * Configure le test.
     * Cette méthode est appelée avant chaque méthode de test pour initialiser l'instance de `Position` avec des valeurs spécifiques.
     */
    @Before
    public void setUp() {
        position = new Position(1, 2);
    }

    /**
     * Teste la méthode getAbscisse.
     * Vérifie si l'abscisse de la position est correctement récupérée.
     */
    @Test
    public void testGetAbscisse() {
        assertEquals(1, position.getAbscisse());
    }

    /**
     * Teste la méthode getOrdonnee.
     * Vérifie si l'ordonnée de la position est correctement récupérée.
     */
    @Test
    public void testGetOrdonnee() {
        assertEquals(2, position.getOrdonnee());
    }

    /**
     * Teste la méthode setAbscisse.
     * Vérifie si l'abscisse de la position est correctement définie.
     */
    @Test
    public void testSetAbscisse() {
        position.setAbscisse(5);
        assertEquals(5, position.getAbscisse());
    }

    /**
     * Teste la méthode setOrdonnee.
     * Vérifie si l'ordonnée de la position est correctement définie.
     */
    @Test
    public void testSetOrdonnee() {
        position.setOrdonnee(6);
        assertEquals(6, position.getOrdonnee());
    }

    /**
     * Teste la méthode toString.
     * Vérifie si la représentation sous forme de chaîne de caractères de la position est correcte.
     */
    @Test
    public void testToString() {
        assertEquals("(1, 2)", position.toString());
    }
}
