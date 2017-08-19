package medium;

/**
 * Created by chenlijie on 8/18/17.
 */
public class Container_With_Most_Water_11 {


    public static int maxArea(int[] height) {

        int i = 0;
        int j = height.length-1;
        int max = j * Math.min(height[i], height[j]);

        while (i < j) {

            if (height[i] < height[j]) {
                int t = height[i];
                while (i < j) {
                    if (height[i] > t) {
                        break;
                    }
                    i++;
                }
            } else {
                int t = height[j];
                while (i < j) {
                    if (height[j] > t) {
                        break;
                    }
                    j--;
                }
            }

            max = Math.max((j - i)*Math.min(height[i], height[j]), max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{2,30,30,2}));
    }
}
