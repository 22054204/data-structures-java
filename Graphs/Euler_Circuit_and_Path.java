package Graphs;

import java.util.*;

public class Euler_Circuit_and_Path {
    /*
    Euler Circuit and Path

    An Eulerian Path is a path in a graph that visits every edge exactly once.
    An Eulerian Circuit is an Eulerian Path which starts and ends at the same vertex.

    Given an undirected graph as an adjacency list adj, where adj[i] stores
    all the nodes that have an edge with i:

    - Return 2 if the graph contains an Eulerian Circuit.
    - Else if the graph contains an Eulerian Path, return 1.
    - Otherwise, return 0.

    Examples:

    Input: Refer to the problem statement's first graph.
    Output: 2
    Explanation: An Eulerian circuit is:
    1 -> 2 -> 0 -> 1

    Input: Refer to the problem statement's second graph.
    Output: 1
    Explanation: An Eulerian path is:
    1 -> 0 -> 2

    Constraints:
    1 <= V, E <= 10^4
    0 <= adj[i][j] <= V-1
    */

    public static void main(String[] args) {
        int V = 3;
        int[][] adj = {
                {1, 2},
                {0, 2},
                {0, 1}
        };

        System.out.println(isEulerCircuit(V, adj));
    }

    public static int isEulerCircuit(int V, int[][] adj) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Convert adjacency list input to HashMap
        for (int u = 0; u < V; u++) {
            for (int v : adj[u]) {
                graph.get(u).add(v);
            }
        }

        if (!isConnected(graph, V)) return 0;

        int oddCount = 0;

        for (int i = 0; i < V; i++) {
            if (graph.get(i).size() % 2 != 0) {
                oddCount++;
            }
        }

        if (oddCount > 2) return 0;
        if (oddCount == 2) return 1;

        return 2;
    }

    public static boolean isConnected(Map<Integer, List<Integer>> graph, int V) {
        int nonZeroDegreeVertex = -1;

        for (int i = 0; i < V; i++) {
            if (graph.get(i).size() > 0) {
                nonZeroDegreeVertex = i;
                break;
            }
        }

        if (nonZeroDegreeVertex == -1) return true;

        boolean[] visited = new boolean[V];

        DFS(graph, nonZeroDegreeVertex, visited);

        for (int i = 0; i < V; i++) {
            if (!visited[i] && graph.get(i).size() != 0) {
                return false;
            }
        }

        return true;
    }

    public static void DFS(Map<Integer, List<Integer>> graph, int u, boolean[] visited) {
        visited[u] = true;

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                DFS(graph, v, visited);
            }
        }
    }
}