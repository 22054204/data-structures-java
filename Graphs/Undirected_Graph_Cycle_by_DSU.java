package Graphs;

/*
Given an undirected graph with V vertices and E edges, represented as a 2D array edges[][],
where each entry edges[i] = [u, v] denotes an edge between vertices u and v,
determine whether the graph contains a cycle or not.

Note: The graph can have multiple components.

Examples:

Input:
V = 4, E = 4
edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]

Output:
true

Explanation:
The graph contains a cycle: 0 -> 1 -> 2 -> 0.

Input:
V = 4, E = 3
edges[][] = [[0, 1], [1, 2], [2, 3]]

Output:
false

Explanation:
No cycle in the graph.

Constraints:
1 ≤ V, E ≤ 10^5
0 ≤ edges[i][0], edges[i][1] < V
*/

/* By DSU */

import java.util.*;

public class Undirected_Graph_Cycle_by_DSU {
    public static void main(String[] args) {
        int V = 4;

        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {2, 3}
        };

        boolean result = isCycle(V, edges);
        System.out.println(result);
    }

    static int[] parent;
    static int[] rank;

    public static boolean isCycle(int V, int[][] edges) {
        // Code here

        parent = new int[V];

        for(int i=0;i<V;i++){
            parent[i] = i;
        }

        rank = new int[V];

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];

            int parent_u = find(u);
            int parent_v = find(v);

            if(parent_u == parent_v) return true;

            union(u, v);
        }

        return false;
    }

    public static int find(int x) {
        return parent[x]==x?x:(parent[x]=find(parent[x]));
    }

    public static void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);

        if(x_parent==y_parent) return;
        else{
            if(rank[x_parent]>rank[y_parent]){
                parent[y_parent] = x_parent;
            }else if(rank[x_parent]<rank[y_parent]){
                parent[x_parent] = y_parent;
            }else if(rank[x_parent]==rank[y_parent]){
                parent[y_parent] = x_parent;
                rank[x_parent]++;
            }
        }
    }
}