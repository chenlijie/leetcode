package ebay.design.parkinglot;

import java.util.LinkedList;
import java.util.Queue;

public class ParkingLot {

    Queue<ParkingSpot> smallSpots;
    Queue<ParkingSpot> mediumSpots;
    Queue<ParkingSpot> largeSpots;
    Queue<ParkingSpot> xLargeSpots;

    public ParkingLot() {
        smallSpots = new LinkedList<>();
        mediumSpots = new LinkedList<>();
        largeSpots = new LinkedList<>();
        xLargeSpots = new LinkedList<>();
    }

    boolean parkVehicle(Vehicle v) {
        ParkingSpot spot = null;
        if (v.size == VehicleSize.SMALL) {
            if (!smallSpots.isEmpty())
                spot = smallSpots.poll();
        } else if (v.size == VehicleSize.MEDIUM) {
            if (!mediumSpots.isEmpty())
                spot = mediumSpots.poll();
        } else if (v.size == VehicleSize.LARGE) {
            if (!largeSpots.isEmpty())
                spot = largeSpots.poll();
        } else {
            if (!xLargeSpots.isEmpty())
                spot = xLargeSpots.poll();
        }

        if (spot == null)
            return false;

        spot.park(v);
        return true;
    }

    void unParkVehicle(ParkingSpot spot) {
        spot.unPark();
    }

}
