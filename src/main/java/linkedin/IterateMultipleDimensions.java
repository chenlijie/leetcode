package linkedin;

/**
 * Created by chenlijie on 12/16/17.
 */
public class IterateMultipleDimensions {

    public static void main(String[] args) {
        int[][][][] d = new int[5][4][3][2];

        System.out.println(d.length);
        System.out.println(d[0].length);
        System.out.println(d[0][0].length);
        System.out.println(d[0][0][0].length);
        System.out.println();

        d[0][0][0][0] = 0;
        d[0][0][0][1] = 1;
        d[0][0][1][0] = 10;
        d[0][0][1][1] = 11;
        d[0][1][0][0] = 100;
        d[0][1][0][1] = 101;
        d[0][1][1][0] = 110;
        d[0][1][1][1] = 111;
        d[1][0][0][0] = 1000;
        d[1][0][0][1] = 1001;
        d[1][0][1][0] = 1010;
        d[1][0][1][1] = 1011;
        d[1][1][0][0] = 1100;
        d[1][1][0][1] = 1101;
        d[1][1][1][0] = 1110;
        d[1][1][1][1] = 1111;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
//                        System.out.println(d[i][j][k][l]);
                    }
                }
            }
        }

//        System.out.println(d.length);
    }

    static void print(int[] d, int k) {
        if (k == 1) {
            for (int i = 0; i < d.length; i++) {
                System.out.println(d[i]);
            }
        } else {
            print(new int[]{d[0]}, k-1);
        }
    }
}
