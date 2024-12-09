package agh.ics.oop.model;

import agh.ics.oop.model.util.Boundary;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.floor;

public class EarthMap extends AbstractWorldMap {
    int width, height;
    HashMap<Vector2d, Grass> grassMap;

    public EarthMap(int width, int height, int initGrass, char type) {
        this.width = width;
        this.height = height;
        this.grassMap = new HashMap<>();
        for (int i = 0; i < initGrass; i++) {
            Vector2d pos = genGrass(type);
            putGrass(pos);
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.getY()>=0 && position.getY()<=height;
    }

    @Override
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
        animal.setPosition(new Vector2d(animal.getPosition().getX()%width, animal.getPosition().getY()));
        this.animalMap.put(animal.getPosition(), animal);

        if(direction == MoveDirection.RIGHT || direction == MoveDirection.LEFT) {
            message += " to " + animal.getDirection();
        } else {
            message += " to " + animal.getPosition();
        }
        super.mapChanged(message);
    }

    @Override
    public Boundary getCurrentBounds() {
        return new Boundary(new Vector2d(0, 0), new Vector2d(width, height));
    }

    public Vector2d genGrass(char type) throws IllegalArgumentException {
        if (type == 'E') {
            int soil = ThreadLocalRandom.current().nextInt(0, 5);
            if (soil == 0) {
                int xcoord = ThreadLocalRandom.current().nextInt(0, width + 1);
                int ycoord = ThreadLocalRandom.current().nextInt(0, height + 1);
                if (ycoord > height*0.4 && ycoord < height*0.6) {
                    ycoord = ThreadLocalRandom.current().nextInt(0, height + 1);
                }
            } else {
                int xcoord = ThreadLocalRandom.current().nextInt(0, width + 1);
                int ycoord = ThreadLocalRandom.current().nextInt((int)floor(height*0.4), (int)floor(height*0.6));
            }
        } else if (type == 'C') {
            return new Vector2d(width/2, height/2);
        } else {
            throw new IllegalArgumentException("Unsupported character type: " + type);
        }
        return null;
    }

    public void putGrass(Vector2d position) {
        grassMap.put(position, new Grass(position));
    }
}
