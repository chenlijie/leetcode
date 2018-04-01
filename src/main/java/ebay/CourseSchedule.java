package ebay;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjs = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjs[i] = new ArrayList<>();
        }

        int[] indgrees = new int[numCourses];
        for (int[] pre : prerequisites) {
            adjs[pre[1]].add(pre[0]);
            indgrees[pre[0]]++;
        }

//         Queue<Integer> q = new LinkedList<>();

//         int count = 0;
//         for (int i = 0; i < numCourses; i++) {
//             if (indgrees[i] == 0) {
//                 q.offer(i);
//             }
//         }

//         while (!q.isEmpty()) {
//             int v = q.poll();
//             count++;

//             for (int u : adjs[v]) {
//                 if (--indgrees[u] == 0)
//                     q.offer(u);
//             }
//         }

//         return count == numCourses;

        boolean[] visited = new boolean[numCourses];
        boolean[] rec = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            // if (!visited[i] && isCyclic(i, adjs, visited, rec))
            if (isCyclic(i, adjs, visited, rec))
                return false;
        }

        return true;
    }

    boolean isCyclic(int v, List<Integer>[] adjs, boolean[] visited, boolean[] rec) {
        if (!visited[v]) {
            rec[v] = true;

            for (int u : adjs[v]) {
                if (rec[u] || isCyclic(u, adjs, visited, rec))
                    return true;
            }

            visited[v] = true;
        }
        rec[v] = false;

        return false;
    }

    public static void main(String[] args) {
        CourseSchedule c = new CourseSchedule();
        c.canFinish(2, new int[][]{
                {0,1},
                {1,0},
        });
    }
}
