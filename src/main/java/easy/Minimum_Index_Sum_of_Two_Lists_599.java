package easy;

import java.util.*;

/**
 * Created by chenlijie on 8/6/17.
 */
public class Minimum_Index_Sum_of_Two_Lists_599 {

    public static String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> index = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            index.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        Map<Integer, List<String>> common = new HashMap<>();

        for (int i = 0; i < list2.length; i++) {

            if (index.get(list2[i]) != null && (i+index.get(list2[i])) <= min) {
                min = i+index.get(list2[i]);
                common.putIfAbsent(min, new ArrayList<>());
                common.get(min).add(list2[i]);
            }
        }

        return common.get(min).toArray(new String[common.get(min).size()]);
    }

    public static void main(String[] args) {
        System.out.println(findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"}, new String[]{"KFC","Burger King","Tapioca Express","Shogun"}));
    }
}
