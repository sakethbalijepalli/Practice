package DatastructuresAndAlgorithms;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UnionFind {
    public int[] arr;

    public UnionFind(int N) {
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
    }

    static void main() {
        UnionFind unionFind = new UnionFind(10);
        System.out.println((unionFind.connected(2, 3)));
        unionFind.union(2, 3);
        unionFind.union(1, 5);
        unionFind.union(5, 7);
        unionFind.union(0, 2);
        unionFind.union(7, 9);
        unionFind.union(4, 8);
        unionFind.printConnections();
        unionFind.printGraph();
    }

    public boolean connected(int p, int q) {
        return arr[p] == arr[q];
    }

    public void union(int p, int q) {
        int pid = arr[p];
        int qid = arr[q];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pid) {
                arr[i] = qid;
            }
        }
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
        Map<Integer, List<Integer>> groups = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            groups.putIfAbsent(arr[i], new ArrayList<>());
            groups.get(arr[i]).add(i);
        }

        for (int root : groups.keySet()) {
            List<Integer> nodes = groups.get(root);

            System.out.println("\nComponent " + root);

            System.out.println("   " + root);

            for (int node : nodes) {
                if (node != root) {
                    System.out.println("   └── " + node);
                }
            }
        }
    }


}