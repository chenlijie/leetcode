package amazon.design.elevator;

public class Elevator {

    public enum Status {
        UP, DOWN, PENDING, MAINTENANCE
    }

    int id;
    Button[] buttons;
    Status status;
    int currentFloor;

    public Elevator(int id) {
        this.id = id;
        currentFloor = 1;

        buttons = new Button[10];
        for (int i = 0; i < 7; i++) {
            final int floor = i + 1;
            buttons[i] = new Button((i + 1) + "", () -> System.out.println("stop on floor " + floor));
        }

        buttons[7] = new Button("open", () -> openDoor());
        buttons[8] = new Button("close", () -> closeDoor());
        buttons[9] = new Button("help", () -> System.out.println("help"));
    }

    public void openDoor() {
        System.out.println(id + " is opening door at floor " + currentFloor);
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void closeDoor() {
        System.out.println(id + " is closing door at floor " + currentFloor);
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveToNextFloor() {
        if (status == Status.UP)
            currentFloor++;
        else if (status == Status.DOWN)
            currentFloor--;

        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
