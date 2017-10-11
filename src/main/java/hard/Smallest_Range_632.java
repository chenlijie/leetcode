package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by chenlijie on 9/10/17.
 */
public class Smallest_Range_632 {

    public int[] smallestRange2(List<List<Integer>> nums) {
        PriorityQueue<Element> queue = new PriorityQueue<>(
                new Comparator<Element>() {
                    @Override
                    public int compare(Element o1, Element o2) {
                        return o1.val - o2.val;
                    }
                }
        );

        int begin = Integer.MAX_VALUE;
        int end = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            max = Math.max(max, nums.get(i).get(0));
            end = max;
            begin = Math.min(begin, nums.get(i).get(0));
            queue.offer(new Element(i, 0, nums.get(i).get(0)));
        }

        int count = nums.size();

        while (count == queue.size()) {
            Element e = queue.poll();

            if (max-e.val < end-begin || (max-e.val == end-begin && e.val < begin)) {
                begin = e.val;
                end = max;
            }

            if (e.idx+1 < nums.get(e.rowId).size()) {
                e.idx = e.idx+1;
                e.val = nums.get(e.rowId).get(e.idx);
                queue.offer(e);
                max = Math.max(max, e.val);
            }
        }

        return new int[] {begin, end};
    }

    static class Element {
        int rowId;
        int idx;
        int val;

        public Element(int rowId, int idx, int val) {
            this.rowId = rowId;
            this.idx = idx;
            this.val = val;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int last = -1;
        int[] cur = new int[nums.size()];
        int left = Integer.MIN_VALUE;
        int right = 0;
        int begin = 0;
        int end = Integer.MAX_VALUE;

        while (true) {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < nums.size(); i++) {
                List<Integer> list = nums.get(i);
                int j = cur[i];
                while (j < list.size() && list.get(j) <= left) {
                    j++;
                }

                if (j == list.size()) {
                    return new int[] {begin, end};
                }

                cur[i] = j;

                if (list.get(j) < min) {
                    min = list.get(j);
                    last = i;
                }
            }
            left = min;

            int max = Integer.MIN_VALUE;

            for (int i = 0; i < nums.size(); i++) {
                List<Integer> list = nums.get(i);
                int j = cur[i];
                while (j < list.size() && list.get(j) < left) {
                    j++;
                }

                if (j == list.size()) {
                    return new int[] {begin, end};
                }

                cur[i] = j;

                if (list.get(j) > max) {
                    max = list.get(j);
                }
            }
            right = max;

            if (right-left < end-begin || (right-left == end-begin && left < begin)) {
                begin = left;
                end = right;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(new Smallest_Range_632()
                .smallestRange2(Arrays.asList(
                        Arrays.asList(4,10,15,24,26),
                        Arrays.asList(0,9,12,20),
                        Arrays.asList(5,18,22,30)
//                        Arrays.asList(1,2,3),
//                        Arrays.asList(1,2,3)
                        )));
    }

}
