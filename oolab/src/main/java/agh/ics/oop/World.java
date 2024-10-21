package agh.ics.oop;

public class World {
    public enum MoveDirection {
        FORWARD,
        BACKWARD,
        RIGHT,
        LEFT
    }
    /* run ver1 (zadania 8-10)
    static void run() {
        System.out.println("zwierzak idzie do przodu");
    }*/
    /* run ver 2 (zadania 11-13)
    static void run(String[] moves) {
        System.out.println("zwierzak idzie do przodu");
        for (String move : moves) {
            System.out.println(move);
        }
    }*/
    static void run(MoveDirection[] moves) {
        for (MoveDirection move : moves) {
            String message = switch (move) {
                case FORWARD -> "zwierzak idzie do przodu";
                case BACKWARD -> "zwierzak idzie do tyłu";
                case LEFT -> "zwierzak skręca w lewo";
                case RIGHT -> "zwierzak skręca w prawo";
                default -> "nieznana komenda";
            };

            System.out.println(message);
        }
    }
    public static void main (String[] args) {
        System.out.println("system wystartował");
        MoveDirection[] moves = OptionsParser.Parse(args);
        run(moves);
        System.out.println("system zakończył działanie");
    }
}
