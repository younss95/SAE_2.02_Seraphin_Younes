package testsmodule;

import static org.junit.Assert.assertEquals;

import javafx.geometry.Pos;
import modele.Position;
import vue.ConstantesCanvas;
import modele.Temple;
import modele.Cristal;
import org.junit.Before;
import org.junit.Test;

public class TempleTest {
    private Temple temple;


    @Before
    public void setUp() {
        Position position = new Position(10,10);
        Integer couleur = 6;
        Cristal cristal = new Cristal(6);
        temple = new Temple(position, couleur, cristal);
    }

    @Test
    public void testGetPosiTemple() {
        assertEquals(new Position(10,10), temple.getPosiTemple());
    }

    @Test
    public void testGetCoulTemple() {
        assertEquals(6, temple.getCoulTemple());
    }

    @Test
    public void testGetCristal() {
        assertEquals(6, temple.getCristal());
    }

    @Test
    public void testToString() {
        assertEquals("{Posi : " + temple.getPosiTemple() + " ; CoulTemple : " + temple.getCoulTemple() + " ; Cristal : " + temple.getCristal() + "}", temple.toString());
    }

}
