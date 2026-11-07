package Graphs;

import java.util.*;

/*
Zero-One BFS

Difficulty: Medium
Topics: Graph, BFS, Deque, Shortest Path

Problem Statement:

Given a directed, weighted graph with V vertices numbered from 0 to V-1
and E edges, where edges[i] = [u, v, w] represents a directed edge
from vertex u to vertex v with weight w.

The weight of every edge is either 0 or 1.

Given a source vertex src, find the shortest distance from src to
every other vertex.

Return an array containing the shortest distances.
If a vertex is unreachable from the source, its distance should be -1.

Examples:

Example 1:

Input:
V = 5, E = 6
src = 0
edges = [[0,1,0], [0,2,1], [1,2,1], [1,3,1], [2,4,0], [3,4,1]]

Output:
[0, 0, 1, 1, 1]

Explanation:
The shortest distances from source vertex 0 are:

0 -> 0 = 0
0 -> 1 = 0
0 -> 2 = 1
0 -> 1 -> 3 = 1
0 -> 1 -> 2 -> 4 = 1


Example 2:

Input:
V = 4, E = 2
src = 0
edges = [[0,1,1], [1,2,0]]

Output:
[0, 1, 1, -1]

Explanation:
Vertex 3 is unreachable from source vertex 0,
so its distance is -1.


Constraints:

1 <= V <= 10^5
0 <= E <= 2 * 10^5
0 <= u, v < V
w is either 0 or 1
0 <= src < V

Note:
For an undirected graph, add each edge in both directions.
*/

public class Zero_One_BFS {
    public static void main(String[] args) {
        int V = 5;
        int E = 6;
        int src = 0;

        int[][] edges = {
                {0, 1, 0},
                {0, 2, 1},
                {1, 2, 1},
                {1, 3, 1},
                {2, 4, 0},
                {3, 4, 1}
        };

        System.out.println(Arrays.toString(zeroOneBFS(V, E, edges, src)));
    }

    public static int[] zeroOneBFS(int V, int E, int[][] edges, int src) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new int[]{v, w});
        }

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Deque<Integer> deque = new ArrayDeque<>();

        distance[src] = 0;
        deque.offerFirst(src);

        while (!deque.isEmpty()) {
            int u = deque.pollFirst();

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int w = edge[1];

                if (distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;

                    if (w == 0) {
                        deque.offerFirst(v);
                    } else { // if(w==1)
                        deque.offerLast(v);
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }
}