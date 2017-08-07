package easy;

import java.util.Arrays;

/**
 * Created by chenlijie on 8/7/17.
 */
public class Assign_Cookies_455 {

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int j = 0;

        for (int i = 0; i < g.length; i++) {

            while (j < s.length) {
                if (s[j++] >= g[i]) {
                    count++;
                    break;
                }
            }

        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1,2,3,5}, new int[]{1,2,4}));
    }
}
