package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] Parse (String[] parse) {
        MoveDirection[] data = new MoveDirection[parse.length];
        for (int i = 0; i < parse.length; i++) {
            String move = parse[i];
            switch (move) {
                case "f" -> data[i] = MoveDirection.FORWARD;
                case "b" -> data[i] = MoveDirection.BACKWARD;
                case "l" -> data[i] = MoveDirection.LEFT;
                case "r" -> data[i] = MoveDirection.RIGHT;
                default -> data[i] = null;
            }
        }
        return data;
    }
}
