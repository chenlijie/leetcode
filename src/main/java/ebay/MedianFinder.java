package ebay;

import java.util.*;

public class MedianFinder {

    Deque<Integer> q1 = new ArrayDeque<>();
    Deque<Integer> q2 = new ArrayDeque<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (q2.isEmpty()) {
            q2.addLast(num);
        } else if (q1.isEmpty()) {
            if (num <= q2.getFirst()) {
                q1.addLast(num);
            } else {
                q1.addLast(q2.removeFirst());
                q2.addLast(num);
            }
        } else {
            if (num <= q1.getFirst()) {
                q1.addFirst(num);
                if (q1.size() > q2.size()) {
                    q2.addFirst(q1.removeLast());
                }
            } else if (num >= q2.getLast()) {
                if (q2.size() > q1.size()) {
                    q1.addLast(q2.removeFirst());
                }
                q2.addLast(num);
            } else if (num >= q1.getLast() && num <= q2.getFirst()) {
                if (q1.size() == q2.size()) {
                    q2.addFirst(num);
                } else {
                    q1.addLast(num);
                }
            } else if (num < q1.getLast()) {
                if (q1.size() == q2.size()) {
                    q2.addFirst(q1.removeLast());
                }
                Stack<Integer> stack = new Stack<>();
                while (!q1.isEmpty() && num < q1.getLast()) {
                    stack.push(q1.removeLast());
                }
                q1.addLast(num);
                while (!stack.isEmpty()) {
                    q1.addLast(stack.pop());
                }
            } else {
                if (q2.size() > q1.size()) {
                    q1.addLast(q2.removeFirst());
                }

                Stack<Integer> stack = new Stack<>();
                while (!q2.isEmpty() && num > q2.getFirst()) {
                    stack.push(q2.removeFirst());
                }
                q2.addFirst(num);
                while (!stack.isEmpty()) {
                    q2.addFirst(stack.pop());
                }
            }
        }

    }

    public double findMedian() {
        if (q2.isEmpty()) {
            return 0;
        } else if (q2.size() > q1.size()) {
            return q2.getFirst();
        } else {
            return (q1.getLast() + q2.getFirst()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();


        finder.addNum(12);
        finder.addNum(10);
        finder.addNum(13);
        finder.addNum(11);
        finder.addNum(5);
        finder.addNum(15);
        finder.addNum(1);
        finder.addNum(11);
        finder.addNum(6);
        finder.addNum(17);
        finder.addNum(14);
        finder.addNum(8);
        finder.addNum(17);
        finder.addNum(6);
        finder.addNum(4);
        finder.addNum(16);
        finder.addNum(8);
        finder.addNum(10);
        finder.addNum(2);
        finder.addNum(12);
        finder.addNum(0);

        finder.findMedian();

        List<Integer> list = new ArrayList<>();
        list.add(0, 1);
    }
}
