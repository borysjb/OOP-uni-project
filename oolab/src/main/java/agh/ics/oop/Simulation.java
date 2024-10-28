package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Simulation {
    private List<Vector2d> positions;
    private List<MoveDirection> moves;


    public Simulation(List<Vector2d> positions, List<MoveDirection> moves) {
        this.positions = positions;
        this.moves = moves;
    }

    public void run() {
        List<Animal> animals = new ArrayList<>();
        for (Vector2d i:positions) {
            animals.add(new Animal(i));
        }

        for (int i = 0; i < moves.size(); i++) {
            animals.get(i%animals.size()).move(moves.get(i));
            System.out.println("Zwierzę " + i%animals.size() + " : " + animals.get(i%animals.size()).getPosition());
        }
    }


}
