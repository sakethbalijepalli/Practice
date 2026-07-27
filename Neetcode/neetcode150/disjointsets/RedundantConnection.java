package Neetcode.neetcode150.disjointsets;

import java.util.Arrays;

public class RedundantConnection {
    int[] parent;

    void main() {
        RedundantConnection redundantConnection = new RedundantConnection();
        System.out.println(Arrays.toString(redundantConnection.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {3, 4},{2, 4}})));
    }

    // {{1,2},{1,3},{3,4},{2,4}}
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        for(int i = 1; i <= n;i++){
            parent[i] = i;
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];

            int edgeU = find(u);
            int edgeV = find(v);

            if(edgeU == edgeV){
                return e;
            }

            parent[edgeU] = edgeV;
        }
        return new int[0];
    }

    private int find(int u){
        if(parent[u] == u){
            return u;
        }

        return parent[u] = find(parent[u]);
    }

}
