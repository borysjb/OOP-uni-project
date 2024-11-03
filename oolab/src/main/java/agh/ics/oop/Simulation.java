package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Simulation {
    private List<MoveDirection> moves;
    private List<Animal> animals;

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves) {
        this.animals = new ArrayList<>();
        for (Vector2d i:positions) {
            this.animals.add(new Animal(i));
        }
        this.moves = moves;
    }

    public List<MoveDirection> getMoves() {
        return moves;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void run() {
        for (int i = 0; i < moves.size(); i++) {
            animals.get(i%animals.size()).move(moves.get(i));
            System.out.println("Zwierzę " + i%animals.size() + " : " + animals.get(i%animals.size()));
        }
    }


}
