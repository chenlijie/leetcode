package amazon.design.elevator;

import java.util.LinkedList;
import java.util.Queue;

public class ElevatorCenter {

    ElevatorController[] elevatorControllers;
    Button[][] floorButtons;
    Queue<Request> requests = new LinkedList<>();

    public ElevatorCenter() {
        elevatorControllers = new ElevatorController[3];

        for (int i = 0; i < elevatorControllers.length; i++) {
            elevatorControllers[i] = new ElevatorController(i);
            elevatorControllers[i].startElevator();
        }

        floorButtons = new Button[20][2];
        for (int i = 0; i < floorButtons.length; i++) {
            for (int j = 0; j < 2; j++) {
                final int floor = i + 1;
                if (i % 2 == 0) {
                    //up
                    floorButtons[i][j] = new Button(String.valueOf(floor), () -> {
                        System.out.println("Floor " + floor + " sends up request");
                        addRequest(new Request(Request.Direction.UP, floor));
                    });
                } else {
                    //down
                    floorButtons[i][j] = new Button(String.valueOf(i + 1), () -> {
                        System.out.println("Floor " + floor + " sends down request");
                        addRequest(new Request(Request.Direction.DOWN, floor));
                    });
                }
            }

        }
    }

    public synchronized void addRequest(Request request) {
        requests.add(request);
    }

    public void processNextRequest() {
        new Thread(
                () -> {
                    while (true) {
                        if (!requests.isEmpty()) {

                            for (ElevatorController controller : elevatorControllers) {
                                if (controller.getElevatorStatus() == Elevator.Status.PENDING) {
                                    controller.acceptRequest(requests.poll());
                                    break;
                                }
                            }
                        }
                    }
                }
        ).start();
    }

    public static void main(String[] args) throws InterruptedException {
        ElevatorCenter center = new ElevatorCenter();
        Thread.sleep(1000);
        center.processNextRequest();

        center.floorButtons[15][0].pressButton();

        center.floorButtons[5][0].pressButton();
    }

}
