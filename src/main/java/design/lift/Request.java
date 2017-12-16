package design.lift;

/**
 * Created by chenlijie on 12/3/17.
 */
public class Request {
    private int toFloor;

    public Request(int _toFloor) {
        toFloor = _toFloor;
    }

    public int getToFloor() {
        return toFloor;
    }
}
