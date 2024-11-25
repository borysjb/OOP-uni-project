package agh.ics.oop.model;

/**
 * The interface responsible for creating a


 */

public interface WorldElement {

    public Vector2d getPosition();

    @Override
    public String toString();

    public boolean isAt(Vector2d position);

    @Override
    public boolean equals(Object obj);

    @Override
    public int hashCode();

}
