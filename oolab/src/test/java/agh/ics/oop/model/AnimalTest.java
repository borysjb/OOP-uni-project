package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AnimalTest implements MoveValidator {

    @Override
    public boolean canMoveTo(Vector2d position) {
        return true;
        // na potrzeby testów zakładamy brak ograniczeń mapy
    }

    @Test
    void testToString() {
        Animal animal = new Animal();
        assertEquals("^", animal.toString());
        animal.move(MoveDirection.RIGHT, this);
        assertEquals(">", animal.toString());
        animal.move(MoveDirection.RIGHT, this);
        assertEquals("v", animal.toString());
        animal.move(MoveDirection.RIGHT, this);
        assertEquals("<", animal.toString());
    }

    @Test
    void defaultConstructor() {
        Animal animal = new Animal();
        assertEquals(new Vector2d(2,2), animal.getPosition());
    }

    @Test
    void parameterConstructor() {
        Animal animal = new Animal(new Vector2d(6,9));
        assertEquals(new Vector2d(6,9), animal.getPosition());
    }

    @Test
    void isAtTest() {
        Animal animal = new Animal(new Vector2d(6,9));
        assertTrue(animal.isAt(new Vector2d(6,9)));
    }



    @Test
    void move() {
        Animal animal = new Animal(new Vector2d(5,5));

        //right turn
        animal.move(MoveDirection.RIGHT, this);
        assertTrue(animal.isAt(new Vector2d(5,5)));
        assertEquals(MapDirection.EAST, animal.getDirection());

        //forward
        animal.move(MoveDirection.FORWARD, this);
        assertTrue(animal.isAt(new Vector2d(6,5)));
        assertEquals(MapDirection.EAST, animal.getDirection());

        //left turn
        animal.move(MoveDirection.LEFT, this);
        assertTrue(animal.isAt(new Vector2d(6,5)));
        assertEquals(MapDirection.NORTH, animal.getDirection());

        //backward
        animal.move(MoveDirection.BACKWARD, this);
        assertTrue(animal.isAt(new Vector2d(6,4)));
        assertEquals(MapDirection.NORTH, animal.getDirection());
    }

}