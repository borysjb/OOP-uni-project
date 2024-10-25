package agh.ics.oop;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.Vector2d;

public class World {

    static boolean checkeq (Vector2d a, Vector2d b) {
        return (a.equals(b) == a.toString().equals(b.toString()));
    }

    public static void main (String[] args) {
        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, -1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection testdir = MapDirection.NORTH;
        System.out.println(testdir);
        testdir = testdir.prev();
        System.out.println(testdir);
        System.out.println(testdir.toUnitVector());
    }
}
