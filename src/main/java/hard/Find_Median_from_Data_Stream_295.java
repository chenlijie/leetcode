package hard;

import java.util.PriorityQueue;
import java.util.Queue;

public class Find_Median_from_Data_Stream_295 {

    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> {return i2 - i1;});

    public Find_Median_from_Data_Stream_295() {

    }

    public void addNum(int num) {
        if (minHeap.size() == 0 || num >= minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }

        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size())
            return minHeap.peek();

        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        Find_Median_from_Data_Stream_295 d = new Find_Median_from_Data_Stream_295();
        d.addNum(1);
        System.out.println(d.findMedian());
    }
}
