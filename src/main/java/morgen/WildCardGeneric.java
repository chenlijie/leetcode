package morgen;

import java.util.*;

public class WildCardGeneric {


    public static void addToList(List<? extends Number> list) {
//        list.add(1);

        List<? extends Number> list2 = new ArrayList<>();
//        list2.add(2);
    }

    public static void shortTest() {
        Set set = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            set.add(i);
            set.remove(i - 1);
        }

        System.out.println(set);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int[] nums = new int[] {1, 8, 4, 5, 9, 7, 2, 11, 0};
        for (int i : nums) {
            if (queue.size() < 3)
                queue.add(i);
            else if (i > queue.peek()) {
                queue.poll();
                queue.offer(i);
            }
        }

        System.out.println(queue.peek());

        factorial(20000);
    }

    static int factorial(int n) {
        if (n == 1)
            return 1;

        return factorial(n - 1);
    }
}
