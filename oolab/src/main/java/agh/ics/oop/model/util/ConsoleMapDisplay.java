package agh.ics.oop.model.util;

import agh.ics.oop.model.WorldMap;

import java.util.Observable;

public class ConsoleMapDisplay implements MapChangeListener{
    private int updates;

    public ConsoleMapDisplay() {
        updates = 0;
    }

    @Override
    public void mapChanged(WorldMap map, String message) {
        System.out.println("Operation: " + message);
        System.out.println(map);
        updates++;
        System.out.println("Updates up to this moment: " + updates);
    }
}
