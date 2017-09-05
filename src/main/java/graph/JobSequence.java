package graph;

import java.util.Arrays;

/**
 * Created by chenlijie on 8/31/17.
 */
public class JobSequence {

    static class Job implements Comparable<Job> {
        char id;
        int dead;
        int profit;

        public Job(char id, int dead, int profit) {
            this.id = id;
            this.dead = dead;
            this.profit = profit;
        }

        @Override
        public int compareTo(Job o) {
            return o.profit-this.profit;
        }
    }

    static class DisjointSet {
        int[] parent;

        public DisjointSet(int n) {
            this.parent = new int[n+1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        public int find(int s) {
            if (s != parent[s]) {
                parent[s] = find(parent[s]);
            }
            return parent[s];
        }

        public void merge(int u, int v) {
            parent[v] = u;
        }
    }

    private int findMaxDead(Job[] jobs) {
        int max = -1;
        for (Job job : jobs) {
            max = Math.max(max, job.dead);
        }
        return max;
    }

    public void scheduleJob(Job[] jobs) {
        Arrays.sort(jobs);
        DisjointSet set = new DisjointSet(findMaxDead(jobs));

        int sum = 0;
        for (int i = 0; i < jobs.length; i++) {

            int availableSlot = set.find(jobs[i].dead);
            if (availableSlot > 0) {

                System.out.print(jobs[i].id);
                set.merge(set.find(availableSlot-1), set.find(availableSlot));
                sum += jobs[i].profit;
            }
        }
        System.out.println();
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Job[] jobs = new Job[5];

        jobs[0] = new Job('a',2,100);
        jobs[1] = new Job('b',1,19);
        jobs[2] = new Job('c',2,27);
        jobs[3] = new Job('d',1,25);
        jobs[4] = new Job('e',3,15);

        new JobSequence().scheduleJob(jobs);
    }
}
