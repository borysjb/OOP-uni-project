package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MapDirectionTest {
    @Test
    public void nextTest() {
        MapDirection testN = MapDirection.NORTH;
        MapDirection testS = MapDirection.SOUTH;
        MapDirection testW = MapDirection.WEST;
        MapDirection testE = MapDirection.EAST;
        assertEquals(MapDirection.EAST, testN.next());
        assertEquals(MapDirection.SOUTH, testE.next());
        assertEquals(MapDirection.WEST, testS.next());
        assertEquals(MapDirection.NORTH, testW.next());
    }

    @Test
    public void prevTest() {
        MapDirection testN = MapDirection.NORTH;
        MapDirection testS = MapDirection.SOUTH;
        MapDirection testW = MapDirection.WEST;
        MapDirection testE = MapDirection.EAST;
        assertEquals(MapDirection.WEST, testN.prev());
        assertEquals(MapDirection.NORTH, testE.prev());
        assertEquals(MapDirection.EAST, testS.prev());
        assertEquals(MapDirection.SOUTH, testW.prev());
    }

    @Test
    public void toStringWorks() {
        MapDirection testN = MapDirection.NORTH;
        MapDirection testS = MapDirection.SOUTH;
        MapDirection testW = MapDirection.WEST;
        MapDirection testE = MapDirection.EAST;
        assertEquals("Północ", testN.toString());
        assertEquals("Południe", testS.toString());
        assertEquals("Zachód", testW.toString());
        assertEquals("Wschód", testE.toString());
    }

    @Test
    public void toUnitVectorWorks() {
        MapDirection testN = MapDirection.NORTH;
        MapDirection testS = MapDirection.SOUTH;
        MapDirection testW = MapDirection.WEST;
        MapDirection testE = MapDirection.EAST;
        assertEquals(new Vector2d(0,1), testN.toUnitVector());
        assertEquals(new Vector2d(0,-1), testS.toUnitVector());
        assertEquals(new Vector2d(-1,0), testW.toUnitVector());
        assertEquals(new Vector2d(1, 0), testE.toUnitVector());
    }
  
}