package agh.ics.oop.model;

import agh.ics.oop.model.util.Boundary;
import agh.ics.oop.model.util.IncorrectPositionException;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, Animal> animalMap = new HashMap<>();
    public void place(Animal animal) throws IncorrectPositionException {
        if(!canMoveTo(animal.getPosition())) {
            throw new IncorrectPositionException(animal.getPosition());
        } else {
            animalMap.put(animal.getPosition(), animal);
        }
    }

    public boolean canMoveTo(Vector2d position) {
        return !animalMap.containsKey(position);
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        Boundary bounds = this.getCurrentBounds();
        return visualizer.draw(bounds.lowerbound(), bounds.upperbound());
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
