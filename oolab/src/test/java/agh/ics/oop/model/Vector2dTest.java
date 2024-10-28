package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    @Test
    void equalVectorsAreEqual() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);

        assertTrue(v1.equals(v2));
    }

    @Test
    void diffVectorsAreNotEqual() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,2);

        assertFalse(v1.equals(v2));
    }

    @Test
    void nonVectorsAreNotEqual() {
        Vector2d v1 = new Vector2d(1,2);
        int[] v2 = {1,2};

        assertFalse(v1.equals(v2));
    }

    @Test
    void vectorIsEqualToItself() {
        Vector2d v1 = new Vector2d(1,2);
        assertTrue(v1.equals(v1));
    }

    @Test
    void toStringGivesString() {
        Vector2d v1 = new Vector2d(1,2);

        assertEquals("(1,2)", v1.toString());
    }

    @Test
    void precedingVectorPrecedesVector () {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,1);

        assertTrue(v2.precedes(v1));
    }

    @Test
    void nonprecedingVectorDoesNotPrecedeVector () {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,2);

        assertFalse(v2.precedes(v1));
    }
    @Test
    void vectorPrecedesItself () {
        Vector2d v1 = new Vector2d(1,2);

        assertTrue(v1.precedes(v1));
    }

    @Test
    void followingVectorFollowsVector () {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,2);

        assertTrue(v2.follows(v1));
    }

    @Test
    void nonfollowingVectorDoesNotFollowVector () {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,1);

        assertFalse(v2.follows(v1));
    }

    @Test
    void vectorFollowsItself () {
        Vector2d v1 = new Vector2d(1,2);

        assertTrue(v1.follows(v1));
    }

    @Test
    void upperRightWorks () {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,1);

        Vector2d v3 = v1.upperRight(v2);

        assertEquals(new Vector2d(2,2), v3);
    }

    @Test
    void lowerLeftWorks () {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,1);

        Vector2d v3 = v1.lowerLeft(v2);

        assertEquals(new Vector2d(1,1), v3);
    }

    @Test
    void addingWorks () {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,2);

        Vector2d v3 = v1.add(v2);

        assertEquals(new Vector2d(3,4), v3);
    }

    @Test
    void subtractingWorks () {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,2);

        Vector2d v3 = v1.subtract(v2);

        assertEquals(new Vector2d(-1,0), v3);
    }

    @Test
    void oppositeWorks () {
        Vector2d v1 = new Vector2d(1,2);

        Vector2d v2 = v1.opposite();

        assertEquals(new Vector2d(-1,-2), v2);
    }
}