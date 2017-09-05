package medium;

import java.util.*;

/**
 * Created by chenlijie on 9/1/17.
 */
public class Clone_Graph_133 {


      static class UndirectedGraphNode {
          int label;
          List<UndirectedGraphNode> neighbors;
          UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
      }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null) {
            return null;
        }

        Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<>();
        UndirectedGraphNode clonedGraph = cloneHelper(node, nodeMap);

        return clonedGraph;
    }

    private UndirectedGraphNode cloneHelper(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> nodeMap) {
        nodeMap.putIfAbsent(node.label, new UndirectedGraphNode(node.label));
        UndirectedGraphNode clonedNode = nodeMap.get(node.label);

        for (UndirectedGraphNode graphNode : node.neighbors) {
            clonedNode.neighbors.add(cloneHelper(graphNode, nodeMap));
        }
        return clonedNode;
    }
}

