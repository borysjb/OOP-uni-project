package agh.ics.oop.model;

public class Animal {
    private Vector2d position;
    private MapDirection direction;
    private static final Vector2d lowerbound = new Vector2d(0, 0);
    private static final Vector2d upperbound = new Vector2d(4, 4);

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
            case FORWARD -> {
                Vector2d newpos = this.position.add(this.direction.toUnitVector());
                if(newpos.follows(lowerbound) && newpos.precedes(upperbound)) {
                    this.position = newpos;
                }
            }
            case BACKWARD -> {
                Vector2d newpos = this.position.subtract(this.direction.toUnitVector());
                if(newpos.follows(lowerbound) && newpos.precedes(upperbound)) {
                    this.position = newpos;
                }
            }
            case LEFT -> this.direction = this.direction.prev();
            case RIGHT -> this.direction = this.direction.next();
        }
    }
}
