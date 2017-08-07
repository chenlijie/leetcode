package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by chenlijie on 8/6/17.
 */
public class Intersection_of_Two_Arrays_349 {

    public static int[] intersection(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], nums1[i]);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.get(nums2[i]) != null) {
                set.add(nums2[i]);
            }
        }

        int[] result = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            result[i++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(intersection(new int[]{1, 2, 2, 1, 3, 4, 5, 3, 3}, new int[]{2, 3, 5}));
    }
}
