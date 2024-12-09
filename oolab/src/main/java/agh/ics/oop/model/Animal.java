package agh.ics.oop.model;

import java.util.Objects;

public class Animal implements WorldElement {
    private Vector2d position;
    private MapDirection direction;

    public Animal(Vector2d position) {
        this.position = position;
        this.direction = MapDirection.NORTH;
    }

    public Animal() {
        this.position = new Vector2d(2, 2);
        this.direction = MapDirection.NORTH;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getDirection() {
        return this.direction;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return this.direction.toString();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection moveDirection, MoveValidator validator) {
        Vector2d newPos = this.position;

        switch (moveDirection) {
            case FORWARD -> newPos = this.position.add(this.direction.toUnitVector());
            case BACKWARD -> newPos = this.position.subtract(this.direction.toUnitVector());
            case LEFT -> this.direction = this.direction.prev();
            case RIGHT -> this.direction = this.direction.next();
        }

        if (moveDirection == MoveDirection.FORWARD || moveDirection == MoveDirection.BACKWARD) {
            if (validator.canMoveTo(newPos)) {
                this.position = newPos;
            }
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (!(other instanceof Animal))
            return false;
        Animal that = (Animal) other;
        return this.position.equals(that.getPosition()) && this.direction.equals(that.getDirection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.position, this.direction);
    }
}
