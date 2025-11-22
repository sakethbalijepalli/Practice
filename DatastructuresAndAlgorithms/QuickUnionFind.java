package DatastructuresAndAlgorithms;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class QuickUnionFind {
    public int[] arr;

    public QuickUnionFind(int N) {
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
    }

    static void main() {
        QuickUnionFind unionFind = new QuickUnionFind(10);
        unionFind.union(4, 3);
        unionFind.union(3, 8);
        unionFind.union(6, 5);
        unionFind.union(9, 4);
        unionFind.union(2, 1);
        unionFind.union(5, 0);
        unionFind.union(7, 2);
        unionFind.union(6, 1);
        unionFind.union(7, 3);
        unionFind.printConnections();
        unionFind.printGraph();


    }

    private int root(int i) {
        while (i != arr[i]) {
            i = arr[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        arr[i] = j;
    }

    public void printConnections() {
        Map<Integer, List<Integer>> groups = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            groups.putIfAbsent(arr[i], new ArrayList<>());
            groups.get(arr[i]).add(i);
        }

        for (Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
            System.out.println("Component " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public void printGraph() {
        Map<Integer, List<Integer>> tree = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int parent = arr[i];
            tree.putIfAbsent(parent, new ArrayList<>());
            if (parent != i) {
                tree.get(parent).add(i);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                System.out.println("\nTree rooted at " + i);
                printTreeDFS(i, tree, 0);
            }
        }
    }

    private void printTreeDFS(int node, Map<Integer, List<Integer>> tree, int depth) {
        System.out.println(" ".repeat(depth * 4) + node);

        if (tree.containsKey(node)) {
            for (int child : tree.get(node)) {
                printTreeDFS(child, tree, depth + 1);
            }
        }
    }


}