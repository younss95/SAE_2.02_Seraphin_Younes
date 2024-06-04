package testsmodule;

import modele.ApprentiOrdonnateur;
import modele.Cristal;
import modele.Position;
import modele.Temple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vue.ConstantesCanvas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

public class ApprentiOrdonnateurTest {

    private ApprentiOrdonnateur apprenti;
    private Collection<Temple> temples;
    private Temple temple1;

    @BeforeEach
    public void setUp() {
        apprenti = new ApprentiOrdonnateur();
        temples = new ArrayList<>();

        Position position = new Position(10,10);
        Integer couleur = 6;
        Cristal cristal = new Cristal(6);
        temple1 = new Temple(position, couleur, cristal);
        temples.add(temple1);

        Position position2 = new Position(3,13);
        Integer couleur2 = 2;
        Cristal cristal2 = new Cristal(1);
        temple1 = new Temple(position2, couleur2, cristal2);
        temples.add(temple1);

        apprenti.setTemples(temples);
    }

    @Test
    public void testGetPositionApprenti() {
        Position initialPosition = new Position((ConstantesCanvas.LARGEUR_CANVAS / ConstantesCanvas.CARRE) / 2,
                (ConstantesCanvas.HAUTEUR_CANVAS / ConstantesCanvas.CARRE) / 2);
        assertEquals(initialPosition, apprenti.getPositionApprenti());
    }

    @Test
    public void testSetPositionApprenti() {
        Position newPosition = new Position(5, 5);
        apprenti.setPositionApprenti(newPosition);
        assertEquals(newPosition, apprenti.getPositionApprenti());
    }

    @Test
    public void testEchangeCristal() {
        // Déplacer l'apprenti à la position du temple1 pour échanger les cristaux
        apprenti.setPositionApprenti(new Position(2, 2));

        // Couleur initiale des cristaux
        int couleurInitialeApprenti = apprenti.getCristal().getCoulCristal();
        int couleurInitialeTemple = temples.iterator().next().getCristal().getCoulCristal();

        apprenti.echangeCristal();

        // Vérifier si les couleurs ont été échangées
        assertEquals(couleurInitialeTemple, apprenti.getCristal().getCoulCristal());
        assertEquals(couleurInitialeApprenti, temples.iterator().next().getCristal().getCoulCristal());
    }

    @Test
    public void testEchangeCristalNoTemple() {
        // Déplacer l'apprenti à une position sans temple
        apprenti.setPositionApprenti(new Position(10, 10));
        apprenti.echangeCristal();

        // Vérifier qu'aucune exception n'est levée et qu'il n'y a pas eu d'échange
        assertEquals(0, apprenti.getCristal().getCoulCristal());
    }

    @Test
    public void testSetCoulCristal() {
        apprenti.setCoulCristal(2);
        assertEquals(2, apprenti.getCristal().getCoulCristal());
    }
}
