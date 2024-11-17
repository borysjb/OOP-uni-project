package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main (String[] args) {
        try {
            List<MoveDirection> directions = OptionsParser.Parse(args);
            List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
            //List<MoveDirection> directions = List.of();
            //List<Vector2d> positions = List.of();
            Simulation simulation = new Simulation(positions, directions, new GrassField(10));
            simulation.run();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
