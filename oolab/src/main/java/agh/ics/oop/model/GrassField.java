package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField implements WorldMap {
    Map<Vector2d, Grass> grassMap = new HashMap<>();
    Map<Vector2d, Animal> animalMap = new HashMap<>();

    public GrassField(int n) {
        int maxval = (int) Math.floor(Math.sqrt(10.0 *n));
        for (int i = 0; i < n; i++) {
            int xcoord = ThreadLocalRandom.current().nextInt(0, maxval + 1);
            int ycoord = ThreadLocalRandom.current().nextInt(0, maxval + 1);
            while (grassMap.containsKey(new Vector2d(xcoord, ycoord))) {
                xcoord = ThreadLocalRandom.current().nextInt(0, maxval + 1);
                ycoord = ThreadLocalRandom.current().nextInt(0, maxval + 1);
            }
            grassMap.put(new Vector2d(xcoord,ycoord), new Grass(new Vector2d(xcoord,ycoord)));
        }
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animalMap.get(position) == null) {
            return grassMap.get(position);
        } else {
            return animalMap.get(position);
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }
}
