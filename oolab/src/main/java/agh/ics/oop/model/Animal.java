package agh.ics.oop.model;

public class Animal {
    private Vector2d position;
    private MapDirection direction;

    public Animal(Vector2d position) {
        this.position = position;
        this.direction = MapDirection.NORTH;
    }

    public Animal() {
        this.position = new Vector2d(2,2);
        this.direction = MapDirection.NORTH;
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "pos: " + position.toString() + " direction: "+ direction.toString();
    }

    public boolean isAt (Vector2d position) {
        return this.position.equals(position);
    }

    public void move (MoveDirection direction) {
        switch (direction) {
            case FORWARD -> this.position = this.position.add(this.direction.toUnitVector());
            case BACKWARD -> this.position = this.position.subtract(this.direction.toUnitVector());
            case LEFT -> this.direction = this.direction.prev();
            case RIGHT -> this.direction = this.direction.next();
        }
        switch (this.position.getX()) {
            case -1 -> this.position = this.position.add(new Vector2d(1,0));
            case 5 -> this.position = this.position.add(new Vector2d(-1,0));
        }
        switch (this.position.getY()) {
            case -1 -> this.position = this.position.add(new Vector2d(0,1));
            case 5 -> this.position = this.position.add(new Vector2d(0,-1));
        }
    }
}
