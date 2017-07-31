package easy;

import java.util.*;

/**
 * Created by chenlijie on 7/24/17.
 */
public class Sort_Characters_By_Frequency_451 {

    public static String frequencySort(String s) {

        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : s.toCharArray()) {
            map1.putIfAbsent(c, 0);
            map1.put(c, map1.get(c)+1);
        }

        Map<Integer, List<Character>> map2 = new HashMap<>();
        for (Character c : map1.keySet()) {
            map2.putIfAbsent(map1.get(c), new ArrayList<>());
            map2.get(map1.get(c)).add(c);
        }

        Integer [] nums = map2.keySet().toArray(new Integer[map2.keySet().size()]);
        Arrays.sort(nums);

        StringBuilder builder = new StringBuilder("");
        for (int i = nums.length-1; i >= 0; i--) {

            List<Character> cList = map2.get(nums[i]);
            for (int j = 0; j < cList.size(); j++) {

                for (int k = 0; k < nums[i]; k++) {
                    builder.append(cList.get(j));
                }
            }
        }

        return builder.toString();
    }

    public static String frequencySort2(String s) {
        int[] count = new int[256];
        StringBuilder sb = new StringBuilder();
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) count[s.charAt(i)]++;
        for (int i = 0; i < s.length()+1; i++) list.add(new ArrayList<Integer>());
        for (int i = 0; i < count.length; i++) if (count[i] != 0) list.get(count[i]).add(i);

        for (int i = list.size()-1; i >= 0; i--){
            if (list.get(i) != null){
                List<Integer> temp = list.get(i);
                for(int k = 0; k < temp.size(); k++){
                    for (int m = 0; m < i; m++){
                        sb.append(Character.toChars(temp.get(k)));
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort2("baaacc"));
    }
}
