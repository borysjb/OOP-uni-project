package agh.ics.oop.model;

/**
 * The interface responsible for creating a


 */

public interface WorldElement {

    public Vector2d getPosition();

    public String toString();

    public boolean isAt(Vector2d position);

}
