package agh.ics.oop;

public class OptionsParser {
    public static World.MoveDirection[] Parse (String[] parse) {
        World.MoveDirection[] data = new World.MoveDirection[parse.length];
        for (int i = 0; i < parse.length; i++) {
            String move = parse[i];
            switch (move) {
                case "f" -> data[i] = World.MoveDirection.FORWARD;
                case "b" -> data[i] = World.MoveDirection.BACKWARD;
                case "l" -> data[i] = World.MoveDirection.LEFT;
                case "r" -> data[i] = World.MoveDirection.RIGHT;
            }
        }
        return data;
    }
}
