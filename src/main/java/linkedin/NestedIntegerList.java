package linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 12/8/17.
 */
public class NestedIntegerList {

    /**
     * Given a nested list of integers, returns the sum of all integers in the list weighted by their depth
     * For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1’s at depth 1, one 2 at depth 2)
     * Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 3, one 4 at depth 2, one 6 at depth 1)
     */

    static int sumOfNestedList(List nestedList) {
        return helper(nestedList, 1);
    }

    static int helper(List nestedList, int depth) {
        int sum = 0;
        for (int i = 0; nestedList != null && i < nestedList.size(); i++) {
            if (isInteger(nestedList.get(i))) {
                sum += (int)nestedList.get(i) * depth;
            } else {
                sum += helper((List)nestedList.get(i), depth + 1);
            }
        }
        return sum;
    }

    static int sumOfReversedNestedList(List nestedList) {
        int[] sum = new int[1];
        reversehelper(nestedList, sum);
        return sum[0];
    }

    static int reversehelper(List nestedList, int[] sum) {
        int d = 1;
        for (int i = 0; nestedList != null && i < nestedList.size(); i++) {
            if (isInteger(nestedList.get(i))) {
                sum[0] += (int)nestedList.get(i) * 1;
            } else {
                d = reversehelper((List)nestedList.get(i), sum) + 1;
            }
        }
        return d;
    }

    static boolean isInteger(Object obj) {
        return obj instanceof Integer;
    }

    public static void main(String[] args) {
        List list = new ArrayList();
//        list.add(Arrays.asList(1, 1));
//        list.add(2);
//        list.add(Arrays.asList(1, 1));
        list.add(1);

        List list2 = new ArrayList();
        list2.add(4);
        list2.add(Arrays.asList(6));
        list.add(list2);
        list.add(new ArrayList<>());
        list.add(null);

        System.out.println(sumOfNestedList(list));
    }
}
