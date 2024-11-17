package agh.ics.oop.model;

import agh.ics.oop.model.util.Boundary;

import java.util.Map;
import java.util.Observable;

public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<Vector2d, Animal> getAnimals() {
        return super.animalMap;
    }

    @Override
    public Boundary getCurrentBounds() {
         return new Boundary(new Vector2d(0, 0), new Vector2d(width, height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position)
                && position.follows(new Vector2d(0, 0))
                && position.precedes(new Vector2d(width, height));
    }

}
