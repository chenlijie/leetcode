package microsoft;

public class LeastGasStation {

//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=342647&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B5%5D%3D5%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D3%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
    static class GasStation {
        int distanceToDestination;
        int availableGas;

        public GasStation(int distanceToDestination, int availableGas) {
            this.distanceToDestination = distanceToDestination;
            this.availableGas = availableGas;
        }
    }

    static int leastGasStation(GasStation[] stations, int remainOil, int remainDis) {
        return helper(stations, 0, remainOil, remainDis);
    }

    private static int helper(GasStation[] stations, int s, int remainOil, int remainDis) {
        //Have enough oil go to destination, don't need stop by any gas station.
        if (remainOil >= remainDis)
            return 0;

        //Don't have enough oil and there is no gas station left, that means we can reach destination
        //Final result is station number + 1
        if (s == stations.length)
            return stations.length;

        int stops = stations.length + 1;
        //try each possible solution: not skip next gas station, skip 1 gas station, skip 2 stations and so on.
        //stops is keep the min station need to stop by.
        for (int i = s; i < stations.length; i++) {
            //check if we can reach gas station i. Distance between current location to station i is
            //how far from current location to destination minus how far from station i to destination
            if (remainOil >= (remainDis - stations[i].distanceToDestination)) {
                stops = Math.min(stops, helper(stations, i + 1,
                        //If we reach station i, it costs remainDis - stations[i].distanceToDestination oil
                        //we can refill availableGas in station i
                        //finally we get available gas
                        remainOil - (remainDis - stations[i].distanceToDestination) + stations[i].availableGas,
                        stations[i].distanceToDestination) + 1);
            }
        }

        return stops;
    }


    public static void main(String[] args) {
        GasStation[] stations = new GasStation[3];

        stations[0] = new GasStation(30, 1);
        stations[1] = new GasStation(22, 10);
        stations[2] = new GasStation(12, 12);

        System.out.println(leastGasStation(stations, 20, 32));
    }
}
