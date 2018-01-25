package facebook.fblist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TaskCoolDown {

//    LC621的变种，给出任务单和同种任务之间的cool down间隔，要求计算每个任务的执⾏行行时间列列
//    表。⽐比如任务单为[1, 1, 2, 1], cool down间隔为2，那么每个任务的执⾏行行时间应该是[0, 3, 4, 6]。这题
//    用hashtable可以得出O(n)的解法
//    链接：http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=297109&ctid=456

    static List<Integer> leastInterval(char[] tasks, int n) {
        List<Integer> res = new LinkedList<>();
        int[] count = new int[128];
        int[] pos = new int[128];
        Arrays.fill(pos, -n-1);
        int curPos = 0;
        for(char c: tasks) {
            if(curPos - pos[c] > n) {
                pos[c] = curPos;
// res.add(pos[c]);
                curPos++;
            } else {
                pos[c] += n + 1;
// res.add(pos[c]);
                curPos = pos[c] + 1;
            }
            res.add(pos[c]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'1','1','3','1'}, 2));
    }
}
