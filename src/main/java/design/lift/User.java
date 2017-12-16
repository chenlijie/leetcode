package design.lift;

/**
 * Created by chenlijie on 12/3/17.
 */
public class User {

    private String name;

    public void pressButton(int toFloor) {
        Request req = new Request(toFloor);
        RequestProcessCenter  center = new RequestProcessCenter();
        center.addRequest(req);
    }
}
