package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> Parse (String[] parse) throws IllegalArgumentException {
        List <MoveDirection> data = new ArrayList<>();
        for (int i = 0; i < parse.length; i++) {
            String move = parse[i];
            switch (move) {
                case "f" -> data.add(MoveDirection.FORWARD);
                case "forward" -> data.add(MoveDirection.FORWARD);
                case "fwd" -> data.add(MoveDirection.FORWARD);
                case "b" -> data.add(MoveDirection.BACKWARD);
                case "backward" -> data.add(MoveDirection.BACKWARD);
                case "bck" -> data.add(MoveDirection.BACKWARD);
                case "r" -> data.add(MoveDirection.RIGHT);
                case "right" -> data.add(MoveDirection.RIGHT);
                case "rt" -> data.add(MoveDirection.RIGHT);
                case "l" -> data.add(MoveDirection.LEFT);
                case "left" -> data.add(MoveDirection.LEFT);
                case "lt" -> data.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(move + " is not legal move specification");
            }
        }
        return data;
    }
}
