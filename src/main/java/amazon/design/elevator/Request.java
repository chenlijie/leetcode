package amazon.design.elevator;

public class Request {

    enum Direction {
        UP, DOWN
    }

    public Direction direction;
    public int floor;

    public Request(Direction direction, int floor) {
        this.direction = direction;
        this.floor = floor;
    }
}
