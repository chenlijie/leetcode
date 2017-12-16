package design.lift;

/**
 * Created by chenlijie on 12/3/17.
 */
public class Elevator {
    public static Elevator instance = null;
    private int currentFloor;

    public Elevator() {
        if (instance == null) {  // late loading and eager loading
            // connection pool
            synchronized (Elevator.class) {
                instance = new Elevator();
            }
        }
    }

    public static Elevator getInstance() {
        if (instance == null) {
            synchronized (Elevator.class) {
                instance = new Elevator();
            }
        }
        return instance;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int moveToTargetFloor(int toFloor) {
        currentFloor = toFloor;
        return currentFloor;
    }

    public void moveUp() {};
    public void moveDown() {};
}
