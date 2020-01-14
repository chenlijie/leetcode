package microsoft.onsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathFormString {

    //http://www.1point3acres.com/bbs/thread-375273-1-1.html

//    Given a string and a graph. Each node in the graph contains a
// character as a value. There may be duplicate characters in the graph.
// Return true if there is a path that can form the string, and each node is
// visited at least once. Each node can be visited as many times as you need.
// For example: String="abcba", graph="a-b-c" => true. String="abcba",
// graph="a-b-c-d" => false, because node d is not visited.

    private static class Node {
        char val;
        List<Node> adj = new ArrayList<>();

        public Node(char val) {
            this.val = val;
        }
    }

    static boolean canFormString(Node[] nodes, String s) {
        Map<Node, Integer> visits = new HashMap<>();

        for (int i = 0; i < nodes.length; i++) {
            if (helper(nodes, nodes[i], s, 0, visits)) {
                System.out.println(true);
                return true;
            }
        }

        System.out.println(false);
        return false;
    }

    static boolean helper(Node[] nodes, Node node, String s, int i, Map<Node, Integer> visits) {
        if (i == s.length()) {
            return visits.size() == nodes.length;
        }

        if (node.val == s.charAt(i)) {
            visits.put(node, visits.getOrDefault(node, 0) + 1);

            for (Node n : node.adj) {
                if (helper(nodes, n, s, i + 1, visits))
                    return true;
            }

            if (visits.get(node) == 1) {
                visits.remove(node);
            } else {
                visits.put(node, visits.get(node) - 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[4];
        nodes[0] = new Node('a');
        nodes[1] = new Node('a');
        nodes[2] = new Node('c');
        nodes[3] = new Node('a');

        nodes[0].adj.add(nodes[1]);

        nodes[1].adj.add(nodes[0]);
        nodes[1].adj.add(nodes[2]);

        nodes[2].adj.add(nodes[1]);
        nodes[2].adj.add(nodes[3]);

        nodes[3].adj.add(nodes[2]);


        canFormString(nodes, "aacacb");
    }
}
