package agh.ics.oop.model;

import agh.ics.oop.model.util.IncorrectPositionException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void testConstructor() {
        GrassField field = new GrassField(50);
        int maxval = (int) Math.floor(Math.sqrt(500.0));

        Map<Vector2d, Grass> map = field.getGrassMap();

        assertEquals(50, map.size());
        for(Map.Entry<Vector2d, Grass> entry : map.entrySet()) {
            Vector2d pos = entry.getKey();
            assertTrue(pos.precedes(new Vector2d(maxval, maxval)));
            assertTrue(pos.follows(new Vector2d(0, 0)));
        }
    }

    @Test
    void testPlace() {
        GrassField field = new GrassField(0);
        try {
            field.place(new Animal(new Vector2d(4, 4)));
        } catch (IncorrectPositionException ex) {
            System.out.println("this shouldn't happen");
        }

        Map<Vector2d, Animal> animals = new HashMap<>();
        animals.put(new Vector2d(4,4), new Animal(new Vector2d(4,4)));

        assertEquals(animals, field.getAnimalMap());
    }

    @Test
    void canMoveToEmptySpace() {
        GrassField field = new GrassField(0);

        assertTrue(field.canMoveTo(new Vector2d(4,4)));
    }

    @Test
    void cantMoveToAnimal() {
        GrassField field = new GrassField(0);
        try {
            field.place(new Animal(new Vector2d(4, 4)));
        } catch (IncorrectPositionException e) {
            throw new RuntimeException(e);
        }

        assertFalse(field.canMoveTo(new Vector2d(4,4)));
    }

    @Test
    void canMoveToGrass() {
        GrassField field = new GrassField(1);
        Map<Vector2d, Grass> grass = field.getGrassMap();
        Vector2d grasspos = grass.entrySet().iterator().next().getKey();

        assertTrue(field.canMoveTo(grasspos));
    }

    @Test
    void moveValid() {
        GrassField field = new GrassField(0);
        Animal animal = new Animal(new Vector2d(4,4));
        try {
            field.place(animal);
        } catch (IncorrectPositionException e) {
            throw new RuntimeException(e);
        }
        field.move(animal, MoveDirection.FORWARD);

        assertTrue(field.isOccupied(new Vector2d(4,5)));
        assertFalse(field.isOccupied(new Vector2d(4,4)));
    }

    @Test
    void moveInvalid() {
        GrassField field = new GrassField(0);
        Animal animal = new Animal(new Vector2d(4,4));
        Animal anotherAnimal = new Animal(new Vector2d(4,5));
        try {
            field.place(animal);
            field.place(anotherAnimal);
        } catch (IncorrectPositionException e) {
            throw new RuntimeException(e);
        }

        field.move(animal, MoveDirection.FORWARD);
        assertTrue(field.isOccupied(new Vector2d(4,4)));
        assertTrue(field.isOccupied(new Vector2d(4,5)));
    }

    @Test
    void isOccupiedAnimal() {
        GrassField field = new GrassField(0);
        Animal animal = new Animal(new Vector2d(4,4));
        try {
            field.place(animal);
        } catch (IncorrectPositionException e) {
            throw new RuntimeException(e);
        }

        assertTrue(field.isOccupied(new Vector2d(4,4)));
    }

    @Test
    void isOccupiedGrass() {
        GrassField field = new GrassField(1);
        Map<Vector2d, Grass> grass = field.getGrassMap();
        Vector2d grasspos = grass.entrySet().iterator().next().getKey();

        assertTrue(field.isOccupied(grasspos));
    }

    @Test
    void objectAtAnimal() {
        GrassField field = new GrassField(0);
        Animal animal = new Animal(new Vector2d(4,4));
        try {
            field.place(animal);
        } catch (IncorrectPositionException e) {
            throw new RuntimeException(e);
        }

        assertEquals(animal, field.objectAt(new Vector2d(4,4)));
    }

    @Test
    void objectAtGrass() {
        GrassField field = new GrassField(1);
        Map<Vector2d, Grass> grass = field.getGrassMap();
        Vector2d grasspos = grass.entrySet().iterator().next().getKey();
        Grass grassinst = new Grass(grasspos);

        assertEquals(grassinst, field.objectAt(grasspos));
    }

    @Test
    void objectAtPrioritizesAnimal() {
        GrassField field = new GrassField(1);
        Map<Vector2d, Grass> grass = field.getGrassMap();
        Vector2d grasspos = grass.entrySet().iterator().next().getKey();
        Animal animal = new Animal(grasspos);
        try {
            field.place(animal);
        } catch (IncorrectPositionException e) {
            throw new RuntimeException(e);
        }

        assertEquals(animal, field.objectAt(grasspos));
    }

}