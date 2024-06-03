package testsmodule;

import static org.junit.Assert.assertEquals;

import modele.Position;
import org.junit.Before;
import org.junit.Test;

public class PositionTest {
    private Position position;

    @Before
    public void setUp() {
        position = new Position(1, 2);
    }

    @Test
    public void testGetX() {
        assertEquals(1, position.getAbscisse());
    }

    @Test
    public void testGetY() {
        assertEquals(2, position.getOrdonnee());
    }

    @Test
    public void testSetX() {
        position.setAbscisse(5);
        assertEquals(5, position.getAbscisse());
    }

    @Test
    public void testSetY() {
        position.setOrdonnee(6);
        assertEquals(6, position.getOrdonnee());
    }

    @Test
    public void testToString() {
        assertEquals("(-15, -14)", position.toString());
    }
}
