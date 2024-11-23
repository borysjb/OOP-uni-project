package agh.ics.oop;
import agh.ics.oop.model.*;
import agh.ics.oop.model.util.ConsoleMapDisplay;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main (String[] args) {
        try {
            List<MoveDirection> directions = OptionsParser.Parse(args);
            List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
            //List<MoveDirection> directions = List.of();
            //List<Vector2d> positions = List.of();

            GrassField map = new GrassField(10);
            ConsoleMapDisplay display = new ConsoleMapDisplay();
            map.addObserver(display);

            Simulation simulation = new Simulation(positions, directions, map);
            simulation.run();

            RectangularMap rectMap = new RectangularMap(5,5);
            display = new ConsoleMapDisplay();
            rectMap.addObserver(display);
            simulation = new Simulation(positions, directions, rectMap);

            simulation.run();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
