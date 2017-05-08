package medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by chenlijie on 5/2/17.
 */
public class Largest_Number_179 {

    public String largestNumber(int[] nums) {

        List<String> list = new ArrayList<>();

        for (int i : nums) {
            list.add(i+"");
        }

        Collections.sort(list, (o1, o2) -> {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
        });

        if ("0".equals(list.get(0)))
            return "0";

        return list.stream().collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        System.out.println(new Largest_Number_179().largestNumber(new int[]{9051,5526,2264,5041,1630,5906,6787,8382,4662,4532,6804,4710,4542,2116,7219,8701,8308,957,8775,4822,396,8995,8597,8308,3088}));
//        System.out.println(new Largest_Number_179().largestNumber(new int[]{8308, 8, 308}).equals("34333"));
//        System.out.println(new Largest_Number_179().largestNumber(new int[]{12, 121}).equals("12121"));
//        System.out.println(new Largest_Number_179().largestNumber(new int[]{121, 12}).equals("12121"));
//        System.out.println(new Largest_Number_179().largestNumber(new int[]{3, 31}).equals("331"));
//        System.out.println(new Largest_Number_179().largestNumber(new int[]{3, 31, 34}).equals("34331"));
//        System.out.println(new Largest_Number_179().largestNumber(new int[]{3, 31, 0, 34}).equals("343310"));
//        System.out.println(new Largest_Number_179().largestNumber(new int[]{3, 31, 0, 341}).equals("3413310"));
    }
}
