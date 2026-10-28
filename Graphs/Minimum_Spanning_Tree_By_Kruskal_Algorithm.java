package Graphs;

import java.util.*;

public class Minimum_Spanning_Tree_By_Kruskal_Algorithm {
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

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
        System.out.println(spanningTree(V, edges));
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent != y_parent) {
            if (rank[x_parent] < rank[y_parent]) {
                parent[x_parent] = y_parent;
            } else if (rank[x_parent] > rank[y_parent]) {
                parent[y_parent] = x_parent;
            } else {
                parent[y_parent] = x_parent;
                rank[x_parent]++;
            }
        }
    }

    public static int spanningTree(int V, int[][] edges) {
        parent = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        rank = new int[V];
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        return kruskal(edges);
    }

    public static int kruskal(int[][] edges) {
        int sum = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int parent_u = find(u);
            int parent_v = find(v);

            if (parent_u != parent_v) {
                sum += w;
                union(u, v);
            }
        }

        return sum;
    }
}