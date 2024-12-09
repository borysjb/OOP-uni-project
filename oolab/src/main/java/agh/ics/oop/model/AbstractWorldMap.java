package agh.ics.oop.model;

import agh.ics.oop.model.util.Boundary;
import agh.ics.oop.model.util.IncorrectPositionException;
import agh.ics.oop.model.util.MapChangeListener;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, Animal> animalMap = new HashMap<>();
    private List<MapChangeListener> listeners = new ArrayList<>();
    UUID ID = UUID.randomUUID();

    public void place(Animal animal) throws IncorrectPositionException {
        if(!canMoveTo(animal.getPosition())) {
            throw new IncorrectPositionException(animal.getPosition());
        } else {
            animalMap.put(animal.getPosition(), animal);
            mapChanged("Placed new animal on position " + animal.getPosition());
        }
    }

    @Override
    public UUID getID() {
        return ID;
    }

    public void addObserver(MapChangeListener l) {
        this.listeners.add(l);
    }

    public void removeObserver(MapChangeListener l) {
        this.listeners.remove(l);
    }

    public boolean canMoveTo(Vector2d position) {
        return !animalMap.containsKey(position);
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        Boundary bounds = this.getCurrentBounds();
        return visualizer.draw(getCurrentBounds().lowerbound(), getCurrentBounds().upperbound());
    }

    public void move(Animal animal, MoveDirection direction) {
        String message = "";
        if(direction == MoveDirection.RIGHT || direction == MoveDirection.LEFT) {
            message += "Changed the direction of animal on " + animal.getPosition() +
                    " from " + animal.getDirection();
        } else {
            message += "Moved animal from " + animal.getPosition();
        }

        this.animalMap.remove(animal.getPosition());
        animal.move(direction, this);
        this.animalMap.put(animal.getPosition(), animal);

        if(direction == MoveDirection.RIGHT || direction == MoveDirection.LEFT) {
            message += " to " + animal.getDirection();
        } else {
            message += " to " + animal.getPosition();
        }
        mapChanged(message);
    }

    public boolean isOccupied(Vector2d position) {
        return this.animalMap.containsKey(position);
    }

    public WorldElement objectAt(Vector2d position) {
        return getElements().get(position);
    }

    public HashMap<Vector2d, WorldElement> getElements() {
        HashMap<Vector2d, WorldElement> elements = new HashMap<>();
        for(Animal animal : this.animalMap.values()) {
            elements.put(animal.getPosition(), animal);
        }
        return elements;
    }

    protected void mapChanged(String message) {
        for(MapChangeListener l : listeners) {
            l.mapChanged(this, message);
        }
    }
}
