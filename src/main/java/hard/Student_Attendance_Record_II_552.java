package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 5/3/17.
 */
public class Student_Attendance_Record_II_552 {

    /**
     * A L P
     *
     * ALLP, PLLA, PLLA
     *
     */

    public int checkRecord(int n) {

        int M = 1000000007;

        /*int[][][] dp = new int[n+1][2][3];
        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp[1][0][1] = 1;

        dp[1] = new int[][] {{1,1,0}, {1,0,0}};

        for (int i = 2; i <= n; i++) {
            dp[i][0][0] = (dp[0][0] + dp[0][1] + dp[0][2]);
            dp[i][0][1] = (dp[0][0]);
            dp[i][0][2] = (dp[0][1]);
            dp[i][1][0] = (dp[0][0] +
                            dp[0][1] +
                            dp[0][2] +
                            dp[1][0] +
                            dp[1][1] +
                            dp[1][2]);
            dp[i][1][1] = (dp[1][0]);
            dp[i][1][2] = (dp[1][1]);
        }
        return dp[0][0] + dp[0][1] + dp[0][2] + dp[1][0] + dp[1][1] + dp[1][2];*/

        /*int[][] dp = new int[2][3];
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[0][1] = 1;


        for (int i = 2; i <= n; i++) {
            int[][] temp = new int[2][3];
            temp[0][0] = (dp[0][0]%M + dp[0][1]%M + dp[0][2]%M)%M;
            temp[0][1] = (dp[0][0])%M;
            temp[0][2] = (dp[0][1]%M);
            temp[1][0] = ((dp[0][0]%M + dp[0][1]%M + dp[0][2]%M)%M + (dp[1][0]%M + dp[1][1]%M + dp[1][2]%M)%M)%M;
            temp[1][1] = (dp[1][0])%M;
            temp[1][2] = (dp[1][1])%M;
            dp = temp;
        }
        return dp[0][0] + dp[0][1] + dp[0][2] + dp[1][0] + dp[1][1] + dp[1][2];*/

        final int MOD = 1000000007;
        int[][][] f = new int[n + 1][2][3];

        f[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 3; k++) {
                    int val = f[i - 1][j][2]; // ...P
                    if (j > 0) val = (val + f[i - 1][j - 1][2]) % MOD; // ...A
                    if (k > 0) val = (val + f[i - 1][j][k - 1]) % MOD; // ...L
                    f[i][j][k] = val;
                }
        return f[n][1][2];
    }


    public static void main(String[] args) {
//        System.out.println(Math.floorMod(10, 3));
        System.out.println(new Student_Attendance_Record_II_552().checkRecord(1) == 3);
        System.out.println(new Student_Attendance_Record_II_552().checkRecord(5));
        System.out.println(new Student_Attendance_Record_II_552().checkRecord(5) == 94);
        System.out.println(new Student_Attendance_Record_II_552().checkRecord(8) == 861);
        System.out.println(new Student_Attendance_Record_II_552().checkRecord(20) == 2947811);
        System.out.println(new Student_Attendance_Record_II_552().checkRecord(100));
        System.out.println(new Student_Attendance_Record_II_552().checkRecord(100) == 985598218);

//        int[][][] dp = new int[2][2][3];
//        dp[1][1][0] = 1;
//        dp[1][0][1] = 1;
//
//        System.out.println(dp[1][1][1]);

    }
}
