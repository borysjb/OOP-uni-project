package agh.ics.oop.model;

public class Animal {
    private Vector2d position;
    private MapDirection direction;

    public Animal(Vector2d position) {
        if (position.getX()>4) position = new Vector2d(4, position.getY());
        if (position.getX()<0) position = new Vector2d(0, position.getY());
        if (position.getY()>4) position = new Vector2d(position.getX(), 4);
        if (position.getY()<0) position = new Vector2d(position.getX(), 0);
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
        return "( " + position.toString() + " , "+ direction.toString() + " )";
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
        if (this.position.getX()>4) this.position = new Vector2d(4, this.position.getY());
        if (this.position.getX()<0) this.position = new Vector2d(0, this.position.getY());
        if (this.position.getY()>4) this.position = new Vector2d(this.position.getX(), 4);
        if (this.position.getY()<0) this.position = new Vector2d(this.position.getX(), 0);
    }
}
