package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    void forwardParsesCorrectly () {
        String[] toparse = {"f"};
        MoveDirection[] expected = {MoveDirection.FORWARD};
        assertArrayEquals(expected, OptionsParser.Parse(toparse));
    }

    @Test
    void backwardParsesCorrectly () {
        String[] toparse = {"b"};
        MoveDirection[] expected = {MoveDirection.BACKWARD};
        assertArrayEquals(expected, OptionsParser.Parse(toparse));
    }

    @Test
    void leftParsesCorrectly () {
        String[] toparse = {"l"};
        MoveDirection[] expected = {MoveDirection.LEFT};
        assertArrayEquals(expected, OptionsParser.Parse(toparse));
    }

    @Test
    void rightParsesCorrectly () {
        String[] toparse = {"r"};
        MoveDirection[] expected = {MoveDirection.RIGHT};
        assertArrayEquals(expected, OptionsParser.Parse(toparse));
    }

    @Test
    void multipleParseCorrectly() {
        String[] toparse = {"f","f","r","b"};
        MoveDirection[] expected = {MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.BACKWARD};
        assertArrayEquals(expected, OptionsParser.Parse(toparse));
    }
}