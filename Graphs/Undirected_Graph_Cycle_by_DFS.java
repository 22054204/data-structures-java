package Graphs;

/*
Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether the graph contains a cycle or not.

Note: The graph can have multiple components.

Examples:

Input:
V = 4, E = 4
edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]

Output:
true

Explanation:
1 -> 2 -> 0 -> 1 is a cycle.

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

/* Using DFS */

import java.util.*;

public class Undirected_Graph_Cycle_by_DFS {
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

    static boolean[] visited;

    public static boolean isCycle(int V, int[][] edges) {
        // Code here

        visited = new boolean[V];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0;i<V;i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(solve(graph, i, -1)) return true;
            }
        }

        return false;
    }

    public static boolean solve(Map<Integer, List<Integer>> graph, int u, int parent) {
        visited[u] = true;

        for(int v : graph.get(u)){
            if(v==parent) continue;

            if(visited[v]) return true; // cycle detect

            if(solve(graph, v, u)) return true;
        }

        return false;
    }
}