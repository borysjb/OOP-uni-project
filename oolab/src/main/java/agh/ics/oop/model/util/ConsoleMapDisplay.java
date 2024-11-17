package agh.ics.oop.model.util;

import agh.ics.oop.model.WorldMap;

public class ConsoleMapDisplay implements MapChangeListener{
    private int updates;

    public ConsoleMapDisplay() {
        updates = 0;
    }

    @Override
    public void mapChanged(WorldMap map, String message) {
        MapVisualizer visualizer = new MapVisualizer(map);
        System.out.println("Operation: " + message);
        System.out.println(visualizer.draw(
                map.getCurrentBounds().lowerbound(),
                map.getCurrentBounds().upperbound())
        );
        updates++;
        System.out.println("Updates up to this moment: " + updates);
    }

    public int getUpdates() {
        return this.updates;
    }
}
