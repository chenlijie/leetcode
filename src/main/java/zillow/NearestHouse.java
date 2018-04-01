package zillow;

import utility.Utils;

public class NearestHouse {


    static double[] nearestHouse(double[][] pos) {
        double minDistance = Double.MAX_VALUE;
        double[] ans = new double[3];

        for (int i = 0; i < pos.length; i++) {
            int distance = 0;
            for (int j = 0; j < pos.length; j++) {
                if (distance >= minDistance)
                    break;

                distance += Math.sqrt(Math.pow(pos[i][0] - pos[j][0], 2)
                                    + Math.pow(pos[i][1] - pos[j][1], 2)
                                    + Math.pow(pos[i][2] - pos[j][2], 2));
            }

            if (distance < minDistance) {
                ans = pos[i];
                minDistance = distance;
            }
        }

        Utils.printArray(ans);
        return ans;
    }

    static double[] nearestHouse_2(double[][] pos) {

        double x = 0;
        double y = 0;
        double z = 0;

        for (double[] p : pos) {
            x += p[0];
            y += p[1];
            z += p[2];
        }

        double[] center = new double[] {x / 3, y / 3, z / 3};

        double minDistance = Double.MAX_VALUE;
        double[] ans = new double[3];

        for (double[] p : pos) {
            double distance = Math.sqrt(Math.pow(center[0] - p[0], 2)
                                    + Math.pow(center[1] - p[1], 2)
                                    + Math.pow(center[2] - p[2], 2));

            if (distance < minDistance) {
                ans = p;
                distance = minDistance;
            }
        }

        Utils.printArray(ans);
        return ans;
    }

    public static void main(String[] args) {
        double[][] pos = new double[][] {
                {2, 0, 0},
                {0, 2, 0},
                {0, 0, 3},
                {1, 1, 1},
        };

        nearestHouse(pos);
        nearestHouse_2(pos);
    }
}

