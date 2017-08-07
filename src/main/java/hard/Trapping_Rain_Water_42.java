package hard;

/**
 * Created by chenlijie on 8/5/17.
 */
public class Trapping_Rain_Water_42 {

    public static int trap(int[] height) {

        int first = 0;
        int second = 0;
        int start = 0;
        int sum = 0;
        boolean down = false;
        boolean up = false;

        for (int i = 0; i < height.length; i++) {

            while (height[i] >= first) {
                first = height[i];
                i++;
            }

            start = i;


            if (first == 0) {
                first = height[i];
                start = i;
            } else {
                if (height[i] < first) {
                    down = true;
                }

                if (height[i] >= first) {
                    for (int j = start+1; j < i; j++) {
                        sum = sum + first - height[j];
                    }
                    first = height[i];
                    start = i;
                }

            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
