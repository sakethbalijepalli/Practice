package Neetcode.neetcode150.Graphs.adjacencyList;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    void main() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.neighbors.add(node2);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        System.out.println(cloneGraph(node2));
    }
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();
        return dfs(node, oldToNew);
    }

    private Node dfs(Node node, Map<Node, Node> oldToNew) {
        if (node == null) {
            return null;
        }
        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);
        for (Node neighbour : node.neighbors) {
            copy.neighbors.add(dfs(neighbour, oldToNew));
        }

        return copy;
    }
}
