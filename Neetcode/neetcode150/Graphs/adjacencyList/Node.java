package Neetcode.neetcode150.Graphs.adjacencyList;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        // 1. Gather just the primitive integer values of the neighbors
        List<Integer> neighborValues = new ArrayList<>();
        if (neighbors != null) {
            for (Node n : neighbors) {
                neighborValues.add(n.val);
            }
        }

        // 2. Print the current node value and its neighbors' IDs safely
        return "Node{" +
                "val=" + val +
                ", neighbors=" + neighborValues + // Breaks the circular recursion!
                '}';
    }
}
