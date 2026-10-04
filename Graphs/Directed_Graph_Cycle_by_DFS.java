package Graphs;

/*
Given a directed graph with V vertices numbered from 0 to V - 1 and E directed edges.
The graph is represented using a 2D array edges[][] of size E, where each entry edges[i] = [u, v] denotes a directed edge from vertex u to vertex v.

Check whether the graph contains any cycle. Return true if there exists at least one cycle in the graph; otherwise, return false.

Examples:

Input:
V = 4
edges[][] = [[0, 1], [1, 2], [2, 0], [2, 3]]

Output:
true

Explanation:
The diagram clearly shows a cycle 0 -> 1 -> 2 -> 0.

Input:
V = 4
edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]

Output:
false

Explanation:
No cycle in the graph.

Constraints:
1 ≤ V ≤ 10^5
0 ≤ E ≤ 10^5
0 ≤ edges[i][0], edges[i][1] < V
*/

/* Using DFS */

import java.util.*;

public class Directed_Graph_Cycle_by_DFS {
    public static void main(String[] args) {
        int V = 4;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 0},
                {2, 3}
        };

        boolean result = isCyclic(V, edges);
        System.out.println(result);
    }

    static boolean[] visited;
    static boolean[] inRecursion;

    public static boolean isCyclic(int V, int[][] edges) {
        // Code here

        visited = new boolean[V];
        inRecursion = new boolean[V];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0;i<V;i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            //graph.get(v).add(u);
        }

        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(solve(graph, i)) return true;
            }
        }

        return false;
    }

    public static boolean solve(Map<Integer, List<Integer>> graph, int u) {
        visited[u] = true;
        inRecursion[u] = true;

        for(int v : graph.get(u)){
            if(visited[v] && inRecursion[v]) return true;

            if(!visited[v]){
                if(solve(graph, v)) return true;
            }
        }

        inRecursion[u] = false;

        return false;
    }
}