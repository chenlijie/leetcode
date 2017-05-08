package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 4/26/17.
 */
public class Triangle_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle, 0, new int[triangle.size()], 0, Integer.MAX_VALUE);
    }

    private int minimumTotal(List<List<Integer>> triangle, int level, int[] nums, int idx, int min) {

        nums[level] = triangle.get(level).get(idx);

        if (level == triangle.size()-1) {
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                temp += nums[i];
            }
            return min < temp ? min : temp;
        }

        min = minimumTotal(triangle, 1+level, nums, idx, min);
        min = minimumTotal(triangle, 1+level, nums, 1+idx, min);

        return min;
    }

    /**
     *          0
     *         0 1
     *        0 1 2   <- start
     *       0 1 2 3
     *
     *          -1
     *         2   3
     *
     */

    public int minimumTotal2(List<List<Integer>> triangle) {

        for (int i = triangle.size()-2; i >= 0; i--) {

            for (int j = 0; j <= i; j++) {

                if (triangle.get(i+1).get(j) < triangle.get(i+1).get(j+1)) {
                    triangle.get(i).set(j, triangle.get(i).get(j)+triangle.get(i+1).get(j));
                } else {
                    triangle.get(i).set(j, triangle.get(i).get(j)+triangle.get(i+1).get(j+1));
                }
            }
        }

        return triangle.get(0).get(0);

    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(-1);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(2);
        list2.add(3);

        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(1);
        list3.add(-1);
        list3.add(-3);

        List<Integer> list4 = new ArrayList<Integer>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(list1);
        list.add(list2);
//        list.add(list3);
//        list.add(list4);

        System.out.println(new Triangle_120().minimumTotal(list));
        System.out.println(new Triangle_120().minimumTotal2(list));

    }

}
