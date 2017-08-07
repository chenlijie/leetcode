package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenlijie on 8/2/17.
 */
public class Course_Schedule_207 {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {


        Queue<Integer> headQ = new LinkedList<>();
        Queue<Integer> tailQ = new LinkedList<>();
        int len = prerequisites.length;

        for (int i = 0; i < len; i++) {
            boolean[] read = new boolean[prerequisites.length];
            if (read[i]) {
                continue;
            }
            read[i] = true;

            int h = prerequisites[i][0];
            int t = prerequisites[i][1];

            headQ.add(h);
            tailQ.add(t);

            while (tailQ.size() != 0) {

                int size = tailQ.size();
                for (int j = 0; j < size; j++) {

                    int tailNum = tailQ.poll();
                    for (int k = 0; k < len; k++) {
                        if (tailNum == prerequisites[k][0]) {
                            if (read[k]) {
                                return false;
                            }
                            read[k] = true;
                            headQ.add(prerequisites[k][0]);
                            tailQ.add(prerequisites[k][1]);
                        }
                    }
                }
            }

            /*while (headQ.size() != 0) {

                int size = headQ.size();

                for (int j = 0; j < size; j++) {

                    int headNum = headQ.poll();
                    for (int k = 0; k < len; k++) {
                        if (headNum == prerequisites[k][1]) {
                            if (read[k]) {
                                return false;
                            }
                            read[k] = true;
                            headQ.add(prerequisites[k][0]);
                            tailQ.add(prerequisites[k][1]);
                        }
                    }
                }
            }*/

        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(canFinish(3, new int[][]{{1,0}, {2,1}}));
//        System.out.println(canFinish(3, new int[][]{{4,3}, {3,2}, {2,1}, {1,0}, {0,2}}));
//        System.out.println(canFinish(3, new int[][]{{4,3}, {3,2}, {2,1}, {1,0}, {0,2}}));
//        System.out.println(canFinish(3, new int[][]{{5,3,1,9,3,7},{4,2,0,8,7,5}}));
    }

}
