package amazon.design.elevator;

import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorController {

    public Elevator elevator;
    public boolean isStarted = false;
    public Queue<Request> upQueue = new PriorityQueue<>((r1, r2) -> r1.floor - r2.floor);
    public Queue<Request> downQueue = new PriorityQueue<>((r1, r2) -> r2.floor - r1.floor);

    public ElevatorController(int id) {
        elevator = new Elevator(id);
    }

    public void startElevator() {
        isStarted = true;
        elevator.status = Elevator.Status.PENDING;

//        new Thread(
//                () -> {
                    while (isStarted) {
                        if (elevator.status == Elevator.Status.UP) {

                            elevator.moveToNextFloor();
                            System.out.println(elevator.id + " is going up to floor " + elevator.currentFloor);


                            if (elevator.currentFloor == upQueue.peek().floor) {
                                elevator.openDoor();
                                upQueue.poll();
                                elevator.closeDoor();
                            }

                            if (!upQueue.isEmpty()) {

                            } else if (!downQueue.isEmpty()) {
                                elevator.status = Elevator.Status.DOWN;
                            } else {
                                elevator.status = Elevator.Status.PENDING;
                            }


                        } else if (elevator.status == Elevator.Status.DOWN) {
                            System.out.println(elevator.id + " is going down to floor " + elevator.currentFloor);
                            elevator.moveToNextFloor();

                            if (elevator.currentFloor == downQueue.peek().floor) {
                                elevator.openDoor();
                                downQueue.poll();
                                elevator.closeDoor();
                            }

                            if (!downQueue.isEmpty()) {

                            } else if (!upQueue.isEmpty()) {
                                elevator.status = Elevator.Status.DOWN;
                            } else {
                                elevator.status = Elevator.Status.PENDING;
                            }

                        } else if (elevator.status == Elevator.Status.PENDING){
//                            System.out.println(elevator.id + " is waiting for new reqeust");
//                            try {
//                                Thread.sleep(1 * 1000);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                            try {
                                elevator.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println(elevator.id + " is in maintenance");
//                try {
//                    elevator.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                        }

                    }
//                }
//        ).start();
    }

    public void shutDownElevator() {
        isStarted = false;
    }

    public synchronized void acceptRequest(Request request) {
        if (request.floor > elevator.currentFloor) {
            elevator.status = Elevator.Status.UP;
            upQueue.add(request);
        } else if (request.floor < elevator.currentFloor) {
            elevator.status = Elevator.Status.DOWN;
            downQueue.add(request);
        } else {
            elevator.openDoor();
        }
    }

    public Elevator.Status getElevatorStatus() {
        return elevator.status;
    }
}
