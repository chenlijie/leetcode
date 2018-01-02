package hard;

/**
 * Created by chenlijie on 8/5/17.
 */
public class Trapping_Rain_Water_42 {

    public static int trap(int[] height) {

        if (height.length <= 1)
            return 0;

        int len = height.length;
        int area = 0;

        for (int l = 0, r = 1; r < len; r++) {
            int reduce = 0;
            while (r < len && height[l] > height[r]) {
                reduce += height[r];
                r++;
            }
            if (r < len) {
                area += (r-l)*height[l]-reduce;
                l = r;
            }
        }

        for (int r = len-1, l = len-2; l >= 0; l--) {
            int reduce = 0;
            while (l >= 0 && height[r] >= height[l]) {
                reduce += height[l];
                l--;
            }
            if (l >= 0) {
                area += (r-l)*height[r]-reduce;
                r = l;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{2, 0, 2}));

        int[][] a = new int[][]{{1}};
        System.out.println(a.length);
        System.out.println(a[0].length);
    }
}
