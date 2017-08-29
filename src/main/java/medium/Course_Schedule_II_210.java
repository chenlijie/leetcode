package medium;

/**
 * Created by chenlijie on 8/18/17.
 */
public class Course_Schedule_II_210 {


    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] courses = new int[numCourses];
        int[] indegrees = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][0]]++;
        }

        int seq = 0;
        while (seq < numCourses) {

            int pre = -1;

            for (int i = 0; i < indegrees.length; i++) {
                if (indegrees[i] == 0) {
                    indegrees[i]--;
                    pre = i;
                    break;
                }
            }
            if (pre == -1) {
                return new int[0];
            }

            for (int j = 0; j < prerequisites.length; j++) {
                if (pre == prerequisites[j][1]) {
                    indegrees[prerequisites[j][0]]--;
                }
            }

            courses[seq++] = pre;
        }

        return courses;
    }

    public static void main(String[] args) {
//        for (int i : findOrder(4, new int[][]{
//                {1,0},
//                {2,0},
//                {3,1},
//                {3,2}
//        })) {
//            System.out.print(i + "  ");
//        }

        System.out.println();
        for (int i : findOrder(2, new int[][]{
                {1, 0},
                {0, 1}
        })) {
            System.out.print(i + "  ");
        }
    }
}
