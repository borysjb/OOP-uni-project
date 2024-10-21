package agh.ics.oop.model;

public class Vector2d {
    private final int x;
    private final int y;
    public Vector2d (int x, int y) {
        this.x = x;
        this.y = y;
    }

    private String stringify(int x, int y) {
        return "(" + x + ", " + y + ")";
    }

    public String get() {
        return stringify(this.x, this.y);
    }

    boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }

    Vector2d upperRight (Vector2d other) {
        return new Vector2d(Math.max(other.x, this.x), Math.max(other.y, this.y);
    }

    Vector2d lowerLeft (Vector2d other) {
        return new Vector2d(Math.min(this.x,other.x), Math.min(this.y, other.y));
    }

    Vector2d opposite () {
        return new Vector2d(- this.x, - this.y);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
