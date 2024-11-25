package agh.ics.oop.model;

import java.util.Objects;

public class Grass implements WorldElement {
    private final Vector2d position;

    public Grass(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "*";
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    @Override
    public boolean equals (Object other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (!(other instanceof Grass))
            return false;
        Grass that = (Grass) other;
        return this.position.equals(that.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.position);
    }
}
