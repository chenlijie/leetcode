package graph;

/**
 * Created by chenlijie on 8/30/17.
 */
public class UnWeightShortestPath {

    //num from 1 to num(inclusive)
    public void shortestPath(int[][] path, int num, int start) {

        int[][] state = readGraph(num);

        //update start vertex distance to itself to 0
        state[start][1] = 0;

        for (int currDist = 0; currDist < num; currDist++) {

            //loop each vertex
            for (int vertex = 1; vertex <= num; vertex++) {

                //update if it is unknown and equals to current distance
                if (state[vertex][0] == 0 && state[vertex][1] == currDist) {
                    //update as known
                    state[vertex][0] = 1;

                    int from = vertex;

                    //loop each path and find vertex starting from 'from' and update
                    for (int i = 0; i < path.length; i++) {
                        int to = path[i][1];
                        if (path[i][0] == from && state[to][1] == -1) {
                            state[to][1] = state[from][1] + 1;
                            state[to][2] = from;
                        }
                    }
                }
            }
        }
        printPath(start, state);
    }

    private void printPath(int start, int[][] state) {
        for (int i = 1; i < state.length; i++) {
            System.out.println("The shortest path from " + start + " to " + i + " is " + state[i][1]);
        }
    }

    /**
     *  First dimension - 0: unknown, 1: known
     *  Second dimension - distance, -1:
     *  Third dimension - path from which vertex
     *
     */
    private int[][] readGraph(int num) {

        int[][] state = new int[num+1][3];

        for (int i = 1; i <= num; i++) {
            state[i][0] = 0;
            state[i][1] = -1;
            state[i][2] = 0;
        }

        return state;
    }


    public static void main(String[] args) {
        int[][] path = new int[][] {
                {1, 2},
                {1, 4},
                {2, 4},
                {2, 5},
                {4, 3},
                {4, 7},
                {4, 6},
                {4, 5},
                {3, 1},
                {3, 6},
                {5, 7},
                {7, 6}
        };

        new UnWeightShortestPath().shortestPath(path, 7, 1);
    }
}
