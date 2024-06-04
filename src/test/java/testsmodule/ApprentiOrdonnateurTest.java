package testsmodule;

import modele.*;
import org.junit.Before;
import org.junit.Test;
import vue.ConstantesCanvas;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * La classe `ApprentiOrdonnateurTest` contient des tests unitaires pour la classe `ApprentiOrdonnateur`.
 */
public class ApprentiOrdonnateurTest {
    private ApprentiOrdonnateur apprenti;

    /**
     * Configure le test.
     * Cette méthode est appelée avant chaque méthode de test pour initialiser l'instance de `ApprentiOrdonnateur`.
     */
    @Before
    public void setUp() {
        apprenti = new ApprentiOrdonnateur();
    }

    /**
     * Teste la méthode setPositionApprenti et getPositionApprenti.
     * Vérifie si la position de l'apprenti est correctement définie et récupérée.
     */
    @Test
    public void testSetAndGetPositionApprenti() {
        Position newPosition = new Position(5, 5);
        apprenti.setPositionApprenti(newPosition);
        assertEquals(newPosition, apprenti.getPositionApprenti());
    }

    /**
     * Teste la méthode setTemples et getListTemples.
     * Vérifie si la liste des temples est correctement définie et récupérée.
     */
    @Test
    public void testSetAndGetTemples() {
        Collection<Temple> temples = new ArrayList<>();
        Position position = new Position(10,10);
        Integer couleur = 6;
        Cristal cristal = new Cristal(6);
        Temple temple = new Temple(position, couleur, cristal);

        Position position2 = new Position(10,10);
        Integer couleur2 = 6;
        Cristal cristal2 = new Cristal(6);
        Temple temple2 = new Temple(position2, couleur2, cristal2);
        temples.add(temple);
        temples.add(temple2);

        apprenti.setTemples(temples);
        assertEquals(temples, apprenti.getListTemples());
    }

    /**
     * Teste la méthode getCristal.
     * Vérifie si le cristal de l'apprenti n'est pas nul et si sa couleur est correcte.
     */
    @Test
    public void testGetCristal() {
        assertNotNull(apprenti.getCristal());
        assertEquals(0, apprenti.getCristal().getCoulCristal());
    }

    /**
     * Teste la méthode setCoulCristal.
     * Vérifie si la couleur du cristal de l'apprenti est correctement définie.
     */
    @Test
    public void testSetCoulCristal() {
        apprenti.setCoulCristal(3);
        assertEquals(3, apprenti.getCristal().getCoulCristal());
    }

    /**
     * Teste la méthode toString.
     * Vérifie si la représentation sous forme de chaîne de caractères de l'apprenti est correcte.
     */
    @Test
    public void testToString() {
        Position initialPosition = new Position((ConstantesCanvas.LARGEUR_CANVAS / ConstantesCanvas.CARRE) / 2,
                (ConstantesCanvas.HAUTEUR_CANVAS / ConstantesCanvas.CARRE) / 2);
        String expectedString = "La position de l'apprenti : " + initialPosition + " []";
        assertEquals(expectedString, apprenti.toString());
    }

    /**
     * Teste la méthode echangeCristal.
     * Vérifie si l'échange de cristal entre l'apprenti et le temple à sa position actuelle se fait correctement.
     */
    @Test
    public void testEchangeCristal() {
        Collection<Temple> temples = new ArrayList<>();
        Position position = new Position(1,1);
        Integer couleur = 1;
        Cristal cristal = new Cristal(1);
        Temple temple = new Temple(position, couleur, cristal);
        temples.add(temple);
        apprenti.setTemples(temples);
        Position posi = new Position(1,1);
        apprenti.setPositionApprenti(posi);

        apprenti.echangeCristal();
        System.out.println(apprenti.getPositionApprenti());

        assertEquals(1, apprenti.getCristal().getCoulCristal());
        assertEquals(0, temple.getCristal().getCoulCristal());
    }
}

