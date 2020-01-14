package medium;

import java.util.*;

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
        for (int i : findOrder2(2, new int[][]{
                {1, 0},
        })) {
            System.out.print(i + "  ");
        }
    }

    public static int[] findOrder2(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<>();

        for (int[] p : prerequisites) {
            indegree[p[0]]++;
            //adj[p[1]].add(p[0]);
            adj[p[0]].add(p[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        Stack<Integer> ans = new Stack<>();
        //boolean[] rec = new boolean[numCourses];

        //0: not visted yet, 1: visting, 2: visited
        int[] status = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (status[i] == 0 && dfs(i, adj, ans, status))
                return new int[0];
        }


        int[] res = new int[numCourses];
        int i = ans.size() - 1;
        while (!ans.isEmpty())
            res[i--] = ans.pop();

        return res;
    }

    static boolean dfs(int i, List<Integer>[] adj, Stack<Integer> ans, int[] status) {
        status[i] = 1;

        for (int j : adj[i]) {
            if (status[i] == 1)
                return true;
            else if (status[i] == 0 && dfs(j, adj, ans, status))
                return true;
        }

        ans.push(i);
        status[i] = 2;
        return false;
    }
}
