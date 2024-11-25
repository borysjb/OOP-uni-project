package agh.ics.oop.model.util;

import agh.ics.oop.model.WorldMap;

import java.util.Observable;

public class ConsoleMapDisplay implements MapChangeListener{
    private int updates;

    public ConsoleMapDisplay() {
        updates = 0;
    }

    @Override
    public synchronized void mapChanged(WorldMap map, String message) {
        updates++;
        System.out.println("\n" +
                "Map ID: " + map.getID() + "\n" +
                "Operation: " + message + "\n" +
                "Current state:\n" + map + "\n" +
                "Updates up to this moment: " + updates + "\n");
    }
}
