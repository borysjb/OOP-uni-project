package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassTest {

    @Test
    void getPosition() {
        Grass grass = new Grass(new Vector2d(0,0));
        assertEquals(new Vector2d(0,0), grass.getPosition());
    }

    @Test
    void testToString() {
        Grass grass = new Grass(new Vector2d(2,2));
        assertEquals("*", grass.toString());
    }

    @Test
    void isAt() {
        Grass grass = new Grass(new Vector2d(2,2));
        assertTrue(grass.isAt(new Vector2d(2,2)));
    }

    @Test
    void isNotAt() {
        Grass grass = new Grass(new Vector2d(2,2));
        assertFalse(grass.isAt(new Vector2d(2,4)));
    }

}