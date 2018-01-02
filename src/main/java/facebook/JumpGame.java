package facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chenlijie on 12/25/17.
 */
public class JumpGame {

    List<Integer> jump(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int len = nums.length;
        int[] from = new int[len];
        for (int i = 0; i < len; i++) {
            from[i] = -1;
        }

        int maxSoFar = 0;
        for (int i = 0; i < len; i++) {
            int to = i + nums[i];
            maxSoFar = Math.max(to, maxSoFar);
            if (maxSoFar < i) {
                break;
            }
            setFrom(from, i, i+1, Math.min(to, len-1));
        }

        int i = len - 1;
        while (from[i] != -1) {
            ans.add(i);
            i = from[i];
        }
        if (!ans.isEmpty())
            ans.add(0);

        Collections.sort(ans);
        return ans;
    }

    void setFrom(int[] from, int val, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (from[i] == -1) {
                from[i] = val;
            }
        }
    }

    public static void main(String[] args) {
        JumpGame game = new JumpGame();
//        System.out.print(game.jump(new int[]{2,3,1,1,2,0,1}));
        System.out.print(game.jump(new int[]{4, 1, 1, 1, 0}));
    }
}
