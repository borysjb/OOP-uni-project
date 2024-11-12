package agh.ics.oop.model;

public class Animal {
    private Vector2d position;
    private MapDirection direction;
    private static final Vector2d lowerbound = new Vector2d(-1000000000, -1000000000);
    private static final Vector2d upperbound = new Vector2d(1000000000, 1000000000);
    //nie chcę ograniczać zwierzaków tutaj, są już ograniczone w RectangularMap
    //w razie próby "spawnu" zwierzaka poza mapą zostanie on po prostu zignorowany przez RectangularMap

    public Animal(Vector2d position) {
        position = position.lowerLeft(upperbound);
        position = position.upperRight(lowerbound);
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
}
