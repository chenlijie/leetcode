package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class K_diff_Pairs_in_an_Array_532 {

    public static int findPairs(int[] nums, int k) {
        if (k < 0)
            return 0;

        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        //|a-b|=k
        //a-b=k, a-b=-k
        //a=b+k, a=b-k
        //b=a-k, b=a+k
        for (int i : nums) {
            if (set.contains(i - k)) {
                if (i - k < i) {
                    map.put(i-k, i);
                } else {
                    map.put(i, i-k);
                }
                cnt++;
            } else if (set.contains(k + i)) {
                if (k + i < i) {
                    map.put(k+i, i);
                } else {
                    map.put(i, k+i);
                }
                cnt++;
            }

            set.add(i);
        }

        return map.size();
    }

    public static void main(String[] args) {
        int[] array = new int[] {6,3,5,7,2,3,3,8,2,4};
        System.out.println(findPairs(array, 2));
    }
}
