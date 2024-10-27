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
  
}