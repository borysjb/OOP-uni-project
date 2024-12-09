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

            GrassField grassMap = new GrassField(10);
            RectangularMap rectMap = new RectangularMap(5,5);

            ConsoleMapDisplay display = new ConsoleMapDisplay();

            List<Simulation> simulations = new ArrayList<>();
            simulations.add(new Simulation(positions, directions, grassMap));
            simulations.add(new Simulation(positions, directions, rectMap));

            grassMap.addObserver(display);
            rectMap.addObserver(display);
            SimulationEngine engine = new SimulationEngine(simulations);
            engine.runAsync();

            for(int i = 0; i < 2000; i++) {
                grassMap = new GrassField(10);
                simulations.add(new Simulation(positions, directions, grassMap));
                grassMap.addObserver(display);
            }
            engine = new SimulationEngine(simulations);
            engine.runAsyncInThreadPool(10);



            engine.awaitSimulationsEnd();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.println("System zakonczyl dzialanie\n");
    }
}
