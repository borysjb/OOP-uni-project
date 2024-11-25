package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, Animal> animalMap = new HashMap<>();
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getPosition())) {
            return false;
        } else {
            animalMap.put(animal.getPosition(), animal);
            return true;
        }
    }

    public boolean canMoveTo(Vector2d position) {
        return !animalMap.containsKey(position);
    }

    protected String drawMap(Vector2d low, Vector2d high) {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(low, high);
    }

    public void move(Animal animal, MoveDirection direction) {
        this.animalMap.remove(animal.getPosition());
        animal.move(direction, this);
        this.animalMap.put(animal.getPosition(), animal);
    }

    public boolean isOccupied(Vector2d position) {
        return this.animalMap.containsKey(position);
    }

    public WorldElement objectAt(Vector2d position) {
        return this.animalMap.get(position);
    }
}
