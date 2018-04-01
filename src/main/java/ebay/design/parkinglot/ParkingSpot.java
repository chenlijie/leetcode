package ebay.design.parkinglot;

public class ParkingSpot {

    private int id;
    private VehicleSize size;
    private Vehicle vehicle;

    public ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    public void park(Vehicle v) {
        vehicle = v;
        v.setSpot(this);
    }

    public void unPark() {
        if (vehicle != null) {
            vehicle.setSpot(null);
            vehicle = null;
        }
    }
}
