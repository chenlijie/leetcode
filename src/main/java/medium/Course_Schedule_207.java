package medium;

import java.util.*;

/**
 * Created by chenlijie on 8/2/17.
 */
public class Course_Schedule_207 {


    //BFS
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        LinkedList<Integer>[] adj = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> toVisit = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                toVisit.offer(i);
            }
        }

        while (!toVisit.isEmpty()) {

            int pre = toVisit.poll();
            visited[pre] = true;

            Iterator<Integer> i = adj[pre].iterator();

            while (i.hasNext()) {
                int next = i.next();
                indegree[next]--;

                if (indegree[next] == 0) {
                    toVisit.offer(next);
                }
            }
        }


        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    //DFS
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        LinkedList<Integer>[] adj = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> toVisit = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                toVisit.offer(i);
            }
        }

        while (!toVisit.isEmpty()) {
            int pre = toVisit.poll();

            visited[pre] = true;
            Iterator<Integer> i = adj[pre].iterator();

            while (i.hasNext()) {
                DFSUtil(i.next(), visited, indegree, adj);
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private static void DFSUtil(int s, boolean[] visited, int[] indegree, LinkedList<Integer>[] adj) {
        if (!visited[s]) {
            if (--indegree[s] == 0) {
                visited[s] = true;

                Iterator<Integer> i = adj[s].iterator();

                while (i.hasNext()) {
                    DFSUtil(i.next(), visited, indegree, adj);
                }
            }
        }

    }

    //DFS isCyclic
    public static boolean canFinish3(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (isCyclicUtil(i, visited, recStack, adj)) {
                return false;
            }
        }

        return true;

    }

    private static boolean isCyclicUtil(int s, boolean[] visited, boolean[] recStack, List<Integer>[] adj) {
        if (!visited[s]) {
            visited[s] = true;
            recStack[s] = true;

            for (int i : adj[s]) {
                if (!visited[i] && isCyclicUtil(i, visited, recStack, adj)) {
                    return true;
                } else if (recStack[i]) {
                    return true;
                }
            }
        }

        recStack[s] = false;
        return false;
    }

    public static boolean canFinish4(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;
    }

    private static boolean dfs(ArrayList[] graph, boolean[] visited, int course){
        if(visited[course])
            return false;
        else
            visited[course] = true;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFinish4(3, new int[][]{{2, 0}, {2, 1}}));

//        System.out.println(canFinish(5, new int[][]{{1,0}, {0,2}, {2, 3}, {4, 0}, {1, 4}}));
//        System.out.println(canFinish3(5, new int[][]{{1,0}, {0,2}, {2, 3}, {4, 0}, {1, 4}}));
//
//        System.out.println(canFinish(3, new int[][]{{1, 0}, {2, 0}, {2, 1}}));
//        System.out.println(canFinish3(3, new int[][]{{1, 0}, {2, 0}, {2, 1}}));
//        System.out.println(canFinish(3, new int[][]{{4,3}, {3,2}, {2,1}, {1,0}, {0,2}}));
//        System.out.println(canFinish(3, new int[][]{{4,3}, {3,2}, {2,1}, {1,0}, {0,2}}));
//        System.out.println(canFinish(3, new int[][]{{5,3,1,9,3,7},{4,2,0,8,7,5}}));
    }


}
