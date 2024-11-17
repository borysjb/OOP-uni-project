package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void singleSimulatesCorrectly () {
        List<Vector2d> positions = List.of(new Vector2d(2,2));
        String[] input = {"f","f","r","b"};
        List <MoveDirection> moves = OptionsParser.Parse(input);
        Simulation simulation = new Simulation(positions, moves, new RectangularMap(4,4));
        simulation.run();
        List<Animal> simulatedAnimals = simulation.getAnimals();
        assertTrue(simulatedAnimals.get(0).isAt(new Vector2d(1,4)));
    }

    @Test
    void multipleSimulatesCorrectly () {
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,3), new Vector2d(1,2));
        String[] input = {"f","b","r","l","f","f","r","f","b"};
        List <MoveDirection> moves = OptionsParser.Parse(input);
        Simulation simulation = new Simulation(positions, moves, new RectangularMap(4,4));
        simulation.run();
        List<Animal> simulatedAnimals = simulation.getAnimals();
        assertTrue(simulatedAnimals.get(0).isAt(new Vector2d(2,3)));
        assertTrue(simulatedAnimals.get(1).isAt(new Vector2d(3,4)));
        assertTrue(simulatedAnimals.get(2).isAt(new Vector2d(1,2)));
    }

}