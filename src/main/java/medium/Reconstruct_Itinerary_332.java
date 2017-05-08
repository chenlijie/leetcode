package medium;

import java.util.*;

/**
 * Created by chenlijie on 4/30/17.
 */
public class Reconstruct_Itinerary_332 {


    public List<String> findItinerary2(String[][] tickets) {

        Map<String, LinkedList<String>> map = new HashMap<>();

        for (String[] s : tickets) {
            if (!map.containsKey(s[0])) {
                map.put(s[0], new LinkedList<>());
            }
            if ("JFK".equals(s[0]) && !map.get("JFK").isEmpty() && map.get("JFK").peek().compareTo(s[1]) > 0) {
                map.get(s[0]).addFirst(s[1]);
            } else {
                map.get(s[0]).add(s[1]);
            }
        }

        List<String> list = new ArrayList<>();

        String departure = "JFK";

        Stack<String> stack = new Stack<String>();
        stack.push("JFK");
        while(!stack.isEmpty()) {
            String next = stack.peek();
            if(map.containsKey(next) && !map.get(next).isEmpty()) {
                stack.push(map.get(next).poll());
            } else {
                list.add(next);
                stack.pop();
            }
        }
        Collections.reverse(list);

        return list;
    }

    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<String, PriorityQueue<String>>();
        path = new LinkedList<String>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<String>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }

    public static void main(String[] args) {
//        String[][] tickets = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
//        String[][] tickets = new String[][]{{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
//        String[][] tickets = new String[][]{{"MUC","JFK"},{"JFK","MUC"}};
        String[][] tickets = new String[][]{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};

        for (String s : new Reconstruct_Itinerary_332().findItinerary2(tickets)) {
            System.out.print(s + ",");
        }
    }
}
