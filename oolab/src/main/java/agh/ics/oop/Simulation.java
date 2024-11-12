package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Simulation {
    private List<MoveDirection> moves;
    private List<Animal> animals;
    private WorldMap world;

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap world) {
        this.animals = new ArrayList<>();
        for (Vector2d i:positions) {
            this.animals.add(new Animal(i));
        }
        this.moves = moves;
        this.world = world;
        for (Animal a:animals) {
            this.world.place(a);
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
