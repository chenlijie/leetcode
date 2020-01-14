package zillow;

import utility.Utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TaskPipeline {

//    大致题意是有一个pipeline of tasks, 每个task有{taskID, inputs, outputs},
//    每个task只有当所有inputs都存在时才能run, 给了initial的inputs和一堆tasks,
//    如何实现这个pipeline？理解问题的关键在于有的task的inputs是其他task的output,
//    所以才有执行先后顺序之分，题意就是让你找出执行的顺序，所以就成了topological sort和如何建模

    static class Task {
        int taskId;
        int[] inputs;
        int[] outputs;

        public Task(int taskId, int[] inputs, int[] outputs) {
            this.taskId = taskId;
            this.inputs = inputs;
            this.outputs = outputs;
        }
    }

    static int[] getTaskSequence(Task[] tasks) {
        int len = tasks.length;
        int[] indgrees = new int[len];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            indgrees[i] = tasks[i].inputs.length;
            if (indgrees[i] == 0)
                q.offer(i);
        }

        int[] ans = new int[len];
        int i = 0;

        while (!q.isEmpty()) {
            int v = q.poll();
            ans[i++] = v;

            for (int u : tasks[v].outputs) {
                if (--indgrees[u] == 0)
                    q.offer(u);
            }
        }

        Utils.printArray(ans);

        return ans;
    }

    public static void main(String[] args) {
        Task[] tasks = new Task[7];

        tasks[0] = new Task(0, new int[0], new int[] {4});
        tasks[1] = new Task(1, new int[0], new int[] {2});
        tasks[2] = new Task(2, new int[] {1,3}, new int[0]);
        tasks[3] = new Task(3, new int[0], new int[] {2,4});
        tasks[4] = new Task(4, new int[] {3}, new int[] {4});
        tasks[5] = new Task(5, new int[] {4}, new int[0]);
        tasks[6] = new Task(6, new int[0], new int[] {5});

        getTaskSequence(tasks);
    }
}
