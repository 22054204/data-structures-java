
package Graphs;

import java.util.*;

/*
Problem: Bellman Ford Algorithm

Given a weighted directed graph with V vertices numbered from
0 to V-1 and E edges, represented by edges[][], where
edges[i] = [u, v, w] represents a directed edge from u to v
with weight w. You are also given a source vertex src.

Find the shortest distances from src to all other vertices.

If a vertex is unreachable from src, mark its distance as 100000000.
If the graph contains a reachable negative-weight cycle,
return [-1].

Example 1:
Input:
V = 5
edges = [[1,3,2], [4,3,-1], [2,4,1], [1,2,1], [0,1,5]]
src = 0

Output:
[0, 5, 6, 6, 7]

Explanation:
0 -> 1 has distance 5.
0 -> 1 -> 2 has distance 6.
0 -> 1 -> 2 -> 4 -> 3 has distance 6.
0 -> 1 -> 2 -> 4 has distance 7.

Example 2:
Input:
V = 4
edges = [[0,1,4], [1,2,-6], [2,3,5], [3,1,-2]]
src = 0

Output:
[-1]

Explanation:
The graph contains a negative-weight cycle:
1 -> 2 -> 3 -> 1.

Constraints:
1 <= V <= 100
1 <= E <= V * (V - 1)
-1000 <= w <= 1000
0 <= src < V
*/

public class Bellman_Ford {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
                {1, 3, 2},
                {4, 3, -1},
                {2, 4, 1},
                {1, 2, 1},
                {0, 1, 5}
        };
        int src = 0;

        System.out.println(bellmanFord(V, edges, src));
    }

    public static ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] dist = new int[V];
        int INF = 100000000;

        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (dist[u] != INF && dist[u] + w < dist[v]) {
                result.add(-1);
                return result;
            }
        }

        for (int num : dist) {
            result.add(num);
        }

        return result;
    }
}
