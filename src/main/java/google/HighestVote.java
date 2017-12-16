package google;

import java.util.*;

/**
 * Created by chenlijie on 11/14/17.
 */
public class HighestVote {

    /**
     Give a vote list = [(a, 100), (b, 150), (a, 200)] # (name, timestamp) and time T
     Find the highest number of votes (or anyone with the highest number of votes) at T
     ex: T = 100 -> a, T = 150 -> a or b, T = 200 -> a

     followup1, give one more input K, find Top K votes at T

     followup2, the same vote list, K, but given the Top K votes list, find the time T.
     */

    static String findHighestVote(List<String> names, List<Long> times, long t) {
        Map<String, Integer> counts = new HashMap<>();
        int max = 0;
        String name = null;

        for (int i = 0; i < names.size(); i++) {
            if (times.get(i) <= t) {
                counts.put(names.get(i), 1 + counts.getOrDefault(names.get(i), 0));
                if (counts.get(names.get(i)) > max) {
                    max = counts.get(names.get(i));
                    name = names.get(i);
                }
            }
        }

        return name;
    }

    static class Vote {
        String name;
        int vote;

        public Vote(String name, int vote) {
            this.name = name;
            this.vote = vote;
        }
    }

    static List<String> findTopK(List<Vote> votes, int k) {
        PriorityQueue<Vote> queue = new PriorityQueue<>((a,b)->(b.vote - a.vote));
        for (Vote v : votes) {
            queue.offer(v);
        }

        votes.get(2).vote = 10;

        List<String> names = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Vote v = queue.poll();
            names.add(v.name + " -> " + v.vote);
        }

        return names;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("a", "b", "a", "c", "b", "c", "c", "b");
        List<Long> times = Arrays.asList(100l, 150l, 200l, 250l, 50l, 10l, 300l, 1l);

        System.out.println(findHighestVote(names, times, 200l));

        Vote a = new Vote("a", 2);
        Vote b = new Vote("b", 4);
        Vote c = new Vote("c", 1);
        Vote d = new Vote("d", 3);

        System.out.println(findTopK(Arrays.asList(a, b, c, d), 2));
    }
}
