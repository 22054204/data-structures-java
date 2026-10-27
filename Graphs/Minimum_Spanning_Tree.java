package Graphs;

import java.util.*;

public class Minimum_Spanning_Tree {
    /*
    Minimum Spanning Tree

    Given a weighted, undirected, and connected graph with V vertices
    and a 2D array edges[][], where each element edges[i] = [u, v, w]
    represents an edge between vertices u and v with weight w, return
    the sum of the weights of all edges in the graph's Minimum Spanning Tree (MST).

    Examples:

    Input: V = 3, E = 3, edges = [[0, 1, 5], [1, 2, 3], [0, 2, 1]]
    Output: 4
    Explanation: The spanning tree resulting in a weight of 4 is shown above.

    Input: V = 2, E = 1, edges = [[0, 1, 5]]
    Output: 5
    Explanation: Only one spanning tree is possible, which has a weight of 5.

    Constraints:
    2 <= V <= 1000
    V-1 <= E <= (V*(V-1))/2
    1 <= w <= 1000
    The graph is connected and doesn't contain self-loops or multiple edges.
    */

    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
        System.out.println(spanningTree(V, edges));
    }

    public static int spanningTree(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] mat : edges) {
            int u = mat[0];
            int v = mat[1];
            int w = mat[2];

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Arrays::compare);
        pq.offer(new int[]{0, 0});
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] arr = pq.remove();
            int w = arr[0];
            int u = arr[1];

            if (visited[u]) continue;

            visited[u] = true;
            sum += w;

            for (int[] edge : graph.get(u)) {
                int v_ = edge[0];
                int w_ = edge[1];

                if (visited[v_]) continue;
                pq.offer(new int[]{w_, v_});
            }
        }

        return sum;
    }
}