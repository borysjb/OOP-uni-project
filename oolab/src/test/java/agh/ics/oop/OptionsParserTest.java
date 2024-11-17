package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    void forwardParsesCorrectly () {
        String[] toparse = {"f"};
        List<MoveDirection> expected = List.of(MoveDirection.FORWARD);
        assertEquals(expected, OptionsParser.Parse(toparse));
    }

    @Test
    void backwardParsesCorrectly () {
        String[] toparse = {"b"};
        List<MoveDirection> expected = List.of(MoveDirection.BACKWARD);
        assertEquals(expected, OptionsParser.Parse(toparse));
    }

    @Test
    void leftParsesCorrectly () {
        String[] toparse = {"l"};
        List<MoveDirection> expected = List.of(MoveDirection.LEFT);
        assertEquals(expected, OptionsParser.Parse(toparse));
    }

    @Test
    void rightParsesCorrectly () {
        String[] toparse = {"r"};
        List<MoveDirection> expected = List.of(MoveDirection.RIGHT);
        assertEquals(expected, OptionsParser.Parse(toparse));
    }

    @Test
    void multipleParseCorrectly() {
        String[] toparse = {"f","f","r","b"};
        List<MoveDirection> expected = List.of(MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.BACKWARD);
        assertEquals(expected, OptionsParser.Parse(toparse));
    }

    @Test
    void multipleWithErrorsParseCorrectly() {
        String[] toparse = {"f","f","x","r","b"};
        List<MoveDirection> expected = List.of(MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.BACKWARD);
        assertThrows(IllegalArgumentException.class, () -> {
            OptionsParser.Parse(toparse);
        });
    }

    @Test
    void errorsOnlyParseCorrectly() {
        String[] toparse = {"x","x","x"};
        List<MoveDirection> expected = List.of();
        assertThrows(IllegalArgumentException.class, () -> {
            OptionsParser.Parse(toparse);
        });
    }
}