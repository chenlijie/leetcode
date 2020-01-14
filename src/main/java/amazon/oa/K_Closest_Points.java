package amazon.oa;

import java.util.*;

/**
 *
 */
public class K_Closest_Points {

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Point{");
            sb.append("x=").append(x);
            sb.append(", y=").append(y);
            sb.append('}');
            return sb.toString();
        }
    }

    public static Point[] kClosest(Point[] points, Point origin, int k) {
        Queue<Point> queue = new PriorityQueue<Point>(k, (p1, p2) -> {
            double d1 = Math.pow(p1.x - origin.x, 2) + Math.pow(p1.y - origin.y, 2);
            double d2 = Math.pow(p2.x - origin.x, 2) + Math.pow(p2.y - origin.y, 2);

            if (d1 < d2) {
                return 1;
            } else if (d1 > d2) {
                return -1;
            } else {
                if (p1.x < p2.x) {
                    return 1;
                } else if (p1.x > p2.x) {
                    return -1;
                } else {
                    if (p1.y < p2.y) {
                        return 1;
                    } else if (p1.y > p2.y) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        for (Point p : points) {
            queue.offer(p);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        Point[] ans = new Point[k < queue.size() ? k : queue.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = queue.poll();
        }

        return ans;
    }

    public static List<List<Integer>> closestXDestination(int numDestination, List<List<Integer>> allocations, int numDeliveries) {
        Queue<List<Integer>> queue = new PriorityQueue<>(numDeliveries, (l1, l2) -> {
            long d1 = (long) Math.pow(l1.get(0), 2) + (long) Math.pow(l1.get(1), 2);
            long d2 = (long) Math.pow(l2.get(0), 2) + (long) Math.pow(l2.get(1), 2);

            if (d1 < d2) {
                return 1;
            } else if (d1 > d2) {
                return -1;
            } else {
                return 0;
            }
        });

        for (Iterator<List<Integer>> it = allocations.iterator(); it.hasNext();) {
            queue.offer(it.next());

            if (queue.size() > numDeliveries) {
                queue.poll();
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (numDeliveries-- > 0 && !queue.isEmpty()) {
            ans.add(queue.poll());
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> allocations = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);
        allocations.add(list);
        list = new ArrayList<>();
        list.add(3);list.add(4);
        allocations.add(list);
        list = new ArrayList<>();
        list.add(1);list.add(-1);
        allocations.add(list);

        System.out.println(closestXDestination(3, allocations, 2));

        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(1, -1);
        Point[] p = new Point[] {p1, p2, p3};
        p = kClosest(p, new Point(0, 0), 1);

        for (Point t : p) {
            System.out.println(t);
        }


    }
}
