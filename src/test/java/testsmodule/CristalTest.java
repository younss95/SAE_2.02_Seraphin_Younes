package testsmodule;

import static org.junit.Assert.assertEquals;

import modele.Cristal;
import modele.Position;
import modele.Temple;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CristalTest {
    private Cristal cristal;


    @Before
    public void setUp() {
        cristal = new Cristal(6);
    }

    @Test
    public void testSetCoulCristal() {
        cristal.setCoulCristal(6);
        assertEquals(6, cristal.getCoulCristal());
    }

    @Test
    public void testEqualsCoul() {
        // Test lorsque la couleur du temple correspond à la couleur du paramètre
        assertTrue(cristal.equalsCoul(6));

        // Test lorsque la couleur du temple ne correspond pas à la couleur du paramètre
        assertFalse(cristal.equalsCoul(55)); // Remplacez par une autre valeur de couleur
    }

    @Test
    public void testGetCoulCristal() {
        assertEquals(6, cristal.getCoulCristal());
    }

    public void TestToString(){
        assertEquals("Couleur du cristal : " + cristal.getCoulCristal(), cristal.toString());
    }
}
