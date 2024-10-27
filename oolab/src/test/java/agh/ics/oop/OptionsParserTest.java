package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    void forwardParsesCorrectly () {
        String[] toparse = new String[1];
        toparse[0] = "f";
        MoveDirection[] expected = new MoveDirection[1];
        expected[0] = MoveDirection.FORWARD;
        assertArrayEquals(expected, OptionsParser.Parse(toparse));
    }

    @Test
    void backwardParsesCorrectly () {
        String[] toparse = new String[1];
        toparse[0] = "b";
        MoveDirection[] expected = new MoveDirection[1];
        expected[0] = MoveDirection.BACKWARD;
        assertArrayEquals(expected, OptionsParser.Parse(toparse));
    }

    @Test
    void leftParsesCorrectly () {
        String[] toparse = new String[1];
        toparse[0] = "l";
        MoveDirection[] expected = new MoveDirection[1];
        expected[0] = MoveDirection.LEFT;
        assertArrayEquals(expected, OptionsParser.Parse(toparse));
    }

    @Test
    void rightParsesCorrectly () {
        String[] toparse = new String[1];
        toparse[0] = "r";
        MoveDirection[] expected = new MoveDirection[1];
        expected[0] = MoveDirection.RIGHT;
    }
}