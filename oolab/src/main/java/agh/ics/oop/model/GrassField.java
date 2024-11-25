package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> grassMap = new HashMap<>();

    public GrassField(int n) {
        int maxval = (int) Math.floor(Math.sqrt(10.0 * n));
        for (int i = 0; i < n; i++) {
            int xcoord = ThreadLocalRandom.current().nextInt(0, maxval + 1);
            int ycoord = ThreadLocalRandom.current().nextInt(0, maxval + 1);
            while (this.grassMap.containsKey(new Vector2d(xcoord, ycoord))) {
                xcoord = ThreadLocalRandom.current().nextInt(0, maxval + 1);
                ycoord = ThreadLocalRandom.current().nextInt(0, maxval + 1);
            }
            this.grassMap.put(new Vector2d(xcoord,ycoord), new Grass(new Vector2d(xcoord,ycoord)));
        }
    }

    public Map<Vector2d, Animal> getAnimalMap() {
        return super.animalMap;
    }

    public Map<Vector2d, Grass> getGrassMap() {
        return this.grassMap;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || this.grassMap.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (!super.isOccupied(position)) {
            return this.grassMap.get(position);
        } else {
            return super.objectAt(position);
        }
    }

    @Override
    public String toString() {
        Vector2d lowerbound = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2d upperbound = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Map.Entry<Vector2d, Animal> i : super.animalMap.entrySet()) {
            upperbound = upperbound.upperRight(i.getKey());
            lowerbound = lowerbound.lowerLeft(i.getKey());
        }
        for (Map.Entry<Vector2d, Grass> i : this.grassMap.entrySet()) {
            upperbound = upperbound.upperRight(i.getKey());
            lowerbound = lowerbound.lowerLeft(i.getKey());
        }
        return super.drawMap(lowerbound, upperbound);
    }
}
