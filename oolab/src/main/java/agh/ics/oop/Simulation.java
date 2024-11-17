package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Simulation {
    private final List<MoveDirection> moves;
    private final List<Animal> animals;
    private final WorldMap world;

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap world) {
        this.animals = new ArrayList<>();
        this.moves = moves;
        this.world = world;
        for (Vector2d i : positions) {
            try {
                world.place(new Animal(i));
                this.animals.add(new Animal(i));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public List<MoveDirection> getMoves() {
        return moves;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void run() {
        System.out.println("Simulation started");
        System.out.println(world);
        for (int i = 0; i < moves.size(); i++) {
            Animal currentAnimal = animals.get(i % animals.size());
            MoveDirection moveDirection = moves.get(i);

            world.move(currentAnimal, moveDirection);

            System.out.println("Po ruchu " + (i + 1) + ":" + " ("+moveDirection+")");
            System.out.println(world.toString());
        }
    }
}
