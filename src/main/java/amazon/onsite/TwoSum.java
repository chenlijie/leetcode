package amazon.onsite;

import java.util.*;

public class TwoSum {

//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=354001&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%255B3089%255D%255Bvalue%255D%255B3%255D%3D3%26searchoption%255B3089%255D%255Btype%255D%3Dcheckbox%26searchoption%255B3046%255D%255Bvalue%255D%3D5%26searchoption%255B3046%255D%255Btype%255D%3Dradio&page=1
//     2 sum with and without 重复， 需要找出所有的结果. 涓
    static List<List<Integer>> sumWithDuplicate(int[] nums, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(t - nums[i])) {
                int cnt = map.get(t - nums[i]);
                while (cnt-- > 0) {
                    ans.add(Arrays.asList(t - nums[i], nums[i]));
                }
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        System.out.println(ans);
        return ans;
    }

    static List<List<Integer>> sumWithoutDuplicate(int[] nums, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(t - nums[i])) {
                if (t - nums[i] < nums[i]) {
                    map.put(t - nums[i], nums[i]);
                } else {
                    map.put(nums[i], t - nums[i]);
                }
            } else if (!map.containsKey(nums[i])) {
                map.put(nums[i], null);
            }
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() != null)
                ans.add(Arrays.asList(e.getKey(), e.getValue()));
        }
        System.out.println(ans);
        return ans;
    }

    static List<List<Integer>> sumWithoutDuplicate_2(int[] nums, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == t) {
                ans.add(Arrays.asList(nums[i], nums[j]));

                while (i < j && nums[i] == nums[i + 1]) i++;
                while (i < j && nums[j] == nums[j - 1]) j--;
                i++;
                j--;
            } else if (nums[i] + nums[j] > t){
                j--;
            } else {
                i++;
            }
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
//        sumWithDuplicate(new int[] {3, 2, 3, 1, -1, 4, 8, -1, 5}, 7);
        sumWithoutDuplicate_2(new int[] {3, 2, 3, 1, 5, 5, 5, 1, 8, 1, 1, -1, -1, 3, 3, 4, 4, -1, 4, 8, -1, 5}, 7);
        sumWithoutDuplicate_2(new int[0], 2);

        Random r = new Random();
        System.out.println(1<<31);
        System.out.println(1L<<63);
        System.out.println(Long.MIN_VALUE);
    }
}
