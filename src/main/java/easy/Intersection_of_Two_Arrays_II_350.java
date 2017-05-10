package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 5/9/17.
 */
public class Intersection_of_Two_Arrays_II_350 {

    public static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = 0;
        int n2 = 0;

        List<Integer> list = new ArrayList<>();

        while (n1 < nums1.length && n2 < nums2.length) {
            if (nums1[n1] == nums2[n2]) {
                list.add(nums1[n1]);
                n1++;
                n2++;
            } else if (nums1[n1] < nums2[n2]) {
                n1++;
            } else {
                n2++;
            }
        }

        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(intersect(new int[]{1,2,2,3,3,6,6,6}, new int[]{1,3,4,5,6,6}));
    }
}
