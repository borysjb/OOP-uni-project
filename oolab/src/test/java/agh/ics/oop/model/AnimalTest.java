package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    void testBlankConstructor() {
        Animal animal = new Animal();
        assertNotNull(animal);
        assertEquals(new Vector2d(2,2), animal.getPosition());
        assertEquals(MapDirection.NORTH, animal.getDirection());
    }

    @Test
    void testVectorConstructor() {
        Animal animal = new Animal(new Vector2d(3,1));
        assertNotNull(animal);
        assertEquals(new Vector2d(3,1), animal.getPosition());
        assertEquals(MapDirection.NORTH, animal.getDirection());
    }

    @Test
    void testToString() {
        Animal animal = new Animal(new Vector2d(3,1));
        assertEquals("pos: (3,1) direction: Północ", animal.toString());
    }

    @Test
    void testIsAt() {
        Animal animal = new Animal(new Vector2d(3,1));
        assertTrue(animal.isAt(new Vector2d(3,1)));
    }

    @Test
    void testVectorConstructorXHigh() {
        Animal animal = new Animal(new Vector2d(6,2));
        assertTrue(animal.isAt(new Vector2d(4,2)));
    }

    @Test
    void testVectorConstructorYHigh() {
        Animal animal = new Animal(new Vector2d(2,6));
        assertTrue(animal.isAt(new Vector2d(2,4)));
    }

    @Test
    void testVectorConstructorXLow() {
        Animal animal = new Animal(new Vector2d(-6,2));
        assertTrue(animal.isAt(new Vector2d(0,2)));
    }

    @Test
    void testVectorConstructorYLow() {
        Animal animal = new Animal(new Vector2d(2,-6));
        assertTrue(animal.isAt(new Vector2d(2,0)));
    }

    @Test
    void testMoveForward() {
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2,3)));
    }

    @Test
    void testMoveBackward() {
        Animal animal = new Animal();
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2,1)));
    }

    @Test
    void testMoveLeft() {
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, animal.getDirection());
    }

    @Test
    void testMoveRight() {
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, animal.getDirection());
    }

    @Test
    void testKickbackXLow () {
        Animal animal = new Animal(new Vector2d(0,1));
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(0,1)));
    }

    @Test
    void testKickbackXHigh () {
        Animal animal = new Animal(new Vector2d(4,1));
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(4,1)));
    }

    @Test
    void testKickbackYLow () {
        Animal animal = new Animal(new Vector2d(1,0));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(1,0)));
    }

    @Test
    void testKickbackYHigh () {
        Animal animal = new Animal(new Vector2d(1,4));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(1,4)));
    }
}