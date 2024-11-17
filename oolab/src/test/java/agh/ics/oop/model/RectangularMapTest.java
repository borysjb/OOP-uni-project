package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    public void constructor() {
        RectangularMap map = new RectangularMap(5,4);
        assertEquals(5, map.getWidth());
        assertEquals(4, map.getHeight());
    }

    @Test
    public void canMakeValidMove() {
        RectangularMap map = new RectangularMap(5,4);
        assertTrue(map.canMoveTo(new Vector2d(2,2)));
    }

    @Test
    public void cantMoveToExistingAnimal() {
        RectangularMap map = new RectangularMap(5,4);
        map.place(new Animal());
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
    }

    @Test
    public void cantMoveBeyondTopEdge () {
        RectangularMap map = new RectangularMap(5,4);
        assertFalse(map.canMoveTo(new Vector2d(4,5)));
    }

    @Test
    public void cantMoveBeyondBottomEdge () {
        RectangularMap map = new RectangularMap(5,4);
        assertFalse(map.canMoveTo(new Vector2d(5,-1)));
    }

    @Test
    public void cantMoveBeyondLeftEdge () {
        RectangularMap map = new RectangularMap(5,4);
        assertFalse(map.canMoveTo(new Vector2d(-1,5)));
    }

    @Test
    public void cantMoveBeyondRightEdge () {
        RectangularMap map = new RectangularMap(5,4);
        assertFalse(map.canMoveTo(new Vector2d(6,3)));
    }

    @Test
    public void placeValid() {
        RectangularMap map = new RectangularMap(5,4);
        assertTrue(map.place(new Animal()));
    }

    @Test
    public void placeInvalidOccupied() {
        RectangularMap map = new RectangularMap(5,4);
        map.place(new Animal());
        assertFalse(map.place(new Animal()));
    }

    @Test
    public void placeInvalidEdge() {
        RectangularMap map = new RectangularMap(5,4);
        assertFalse(map.place(new Animal(new Vector2d(2,6))));
    }

    @Test
    public void isNotOccupied() {
        RectangularMap map = new RectangularMap(5,4);
        assertFalse(map.isOccupied(new Vector2d(2,2)));
    }

    @Test
    public void isOccupied() {
        RectangularMap map = new RectangularMap(5,4);
        map.place(new Animal());
        assertTrue(map.isOccupied(new Vector2d(2,2)));
    }

    @Test
    public void objectAt() {
        RectangularMap map = new RectangularMap(5,4);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(2,3));
        Animal animal3 = new Animal(new Vector2d(3,4));
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

        assertEquals(animal2, map.objectAt(new Vector2d(2,3)));
    }


}