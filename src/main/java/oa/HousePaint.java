package oa;

/**
 * Created by chenlijie on 11/29/17.
 */
public class HousePaint {

    /*
    costs[row][col][color] 0: R, 1:G, 2:B
    paintCosts[2][6]
    0: RGB 012 <- 3, 4
    1: RBG 021<- 2, 5
    2: GRB 102<- 0, 5
    3: GBR 120<- 1, 4
    4: BRG 201<- 0, 3
    5: BGR 210<- 1, 2
     */

    void getPaintCosts(int[][][] costs, int[][] paintCosts, int r, int c) {
        paintCosts[r][0] = costs[0][c][0] + costs[1][c][1] + costs[2][c][2];
        paintCosts[r][1] = costs[0][c][0] + costs[1][c][2] + costs[2][c][1];
        paintCosts[r][2] = costs[0][c][1] + costs[1][c][0] + costs[2][c][2];
        paintCosts[r][3] = costs[0][c][1] + costs[1][c][2] + costs[2][c][0];
        paintCosts[r][4] = costs[0][c][2] + costs[1][c][0] + costs[2][c][1];
        paintCosts[r][5] = costs[0][c][2] + costs[1][c][1] + costs[2][c][0];
    }
    
    int minCost(int[][][] costs) {
        int[][] paintCosts = new int[2][6];

        getPaintCosts(costs, paintCosts, 0, 0);
        
        int len = costs[0].length;
        
        for (int i = 1; i < len; i++) {
            getPaintCosts(costs, paintCosts, 1, i);
            paintCosts[1][0] +=  Math.min(paintCosts[0][3], paintCosts[0][4]);
            paintCosts[1][1] +=  Math.min(paintCosts[0][2], paintCosts[0][5]);
            paintCosts[1][2] +=  Math.min(paintCosts[0][0], paintCosts[0][5]);
            paintCosts[1][3] +=  Math.min(paintCosts[0][1], paintCosts[0][4]);
            paintCosts[1][4] +=  Math.min(paintCosts[0][0], paintCosts[0][3]);
            paintCosts[1][5] +=  Math.min(paintCosts[0][1], paintCosts[0][2]);
            
            swap(paintCosts);
        }
        
        int min = paintCosts[0][0];
        
        for (int i : paintCosts[0]) {
            min = Math.min(min, i);
        }
        
        return min;
    }

    void swap(int[][] paintCosts) {
        int[] t = paintCosts[0];
        paintCosts[0] = paintCosts[1];
        paintCosts[1] = t;
    }

    public static void main(String[] args) {
        int[][][] cost = new int[3][2][3];
        cost[0] = new int[][] {
                {1, 10, 10},
                {5, 2, 1}
        };
        cost[1] = new int[][] {
                {10, 1, 10},
                {20, 5, 1}
        };
        cost[2] = new int[][] {
                {10, 10, 1},
                {3, 2, 2}
        };

        HousePaint house = new HousePaint();
        System.out.println(house.minCost(cost));
    }
}
