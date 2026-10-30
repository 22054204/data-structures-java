package Graphs;

import java.util.*;

public class Print_Shortest_Path {
    /*
    Print Shortest Path

    Given a weighted undirected graph with V vertices numbered from 1 to V
    and m edges, where edges[i] = [a, b, w] represents an edge between
    vertices a and b with weight w.

    Find the shortest path from vertex 1 to vertex V.
    If no path exists, return a list containing only -1.

    If a path exists, return a list whose first element is the total
    weight of the shortest path, followed by the vertices in that path.

    Example 1:
    Input:
    V = 5, m = 6
    edges = [[1,2,2], [2,5,5], [2,3,4], [1,4,1], [4,3,3], [3,5,1]]
    Output:
    [5, 1, 4, 3, 5]

    Example 2:
    Input:
    V = 4, m = 4
    edges = [[1,2,2], [2,3,4], [1,4,1], [4,3,3]]
    Output:
    [1, 1, 4]

    Constraints:
    2 <= V <= 10^4
    0 <= m <= 2 * 10^4
    1 <= a, b <= V
    1 <= w <= 10^5
    */

    public static void main(String[] args) {
        int V = 5;
        int m = 6;

        int[][] edges = {
                {1, 2, 2},
                {2, 5, 5},
                {2, 3, 4},
                {1, 4, 1},
                {4, 3, 3},
                {3, 5, 1}
        };

        List<Integer> result = shortestPath(V, m, edges);
        System.out.println(result);
    }

    public static List<Integer> shortestPath(int V, int m, int[][] edges) {
        int src = 1;
        int dest = V;

        int[] distance = new int[V + 1];
        int[] parent = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        Arrays.fill(distance, Integer.MAX_VALUE);

        List<Integer> result = new ArrayList<>();
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();

        for (int i = 1; i <= V; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Arrays::compare);

        distance[src] = 0;
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int d = arr[0];
            int u = arr[1];

            if (distance[u] < d) continue;

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int w = edge[1];

                if (d + w < distance[v]) {
                    parent[v] = u;
                    distance[v] = d + w;
                    pq.offer(new int[]{distance[v], v});
                }
            }
        }

        if (distance[dest] == Integer.MAX_VALUE) {
            result.add(-1);
            return result;
        }

        int i = dest;

        while (i != parent[i]) {
            result.add(i);
            i = parent[i];
        }

        result.add(src);
        Collections.reverse(result);
        result.add(0, distance[dest]);

        return result;
    }
}