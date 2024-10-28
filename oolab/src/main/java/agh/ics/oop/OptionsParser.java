package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> Parse (String[] parse) {
        List <MoveDirection> data = new ArrayList<>();
        for (int i = 0; i < parse.length; i++) {
            String move = parse[i];
            switch (move) {
                case "f" -> data.add(MoveDirection.FORWARD);
                case "b" -> data.add(MoveDirection.BACKWARD);
                case "l" -> data.add(MoveDirection.LEFT);
                case "r" -> data.add(MoveDirection.RIGHT);
            }
        }
        return data;
    }
}
