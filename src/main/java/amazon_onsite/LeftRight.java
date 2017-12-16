package amazon_onsite;

import java.util.*;

/**
 * Created by chenlijie on 12/6/17.
 */
public class LeftRight {

    List<List<Integer>> leftRight(List<Integer> nums, char[] op) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(nums);

        for (int i = 0; i < op.length; i++) {
            int len = res.get(0).size();
            if (op[i] == 'L') {
                turn(res, 0, len/2);
            } else {
                turn(res, len/2, len);
            }
            System.out.println(res);
        }

        return res;
    }

    void turn(List<List<Integer>> res, int start, int end) {
        int size = res.size();
        Stack<Integer> stack = new Stack<>();

        for (int i = size-1; i >= 0; i--) {
            for (int j = start; j < end; j++) {
                stack.push(res.get(i).remove(start));
            }
        }

        for (int i = 0; i < size; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = start; j < end; j++) {
                temp.add(stack.pop());
            }
            res.add(0, temp);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            list.add(i);
        }
        System.out.println(new LeftRight().leftRight(list, new char[]{'L', 'L', 'R'}));
    }
}
