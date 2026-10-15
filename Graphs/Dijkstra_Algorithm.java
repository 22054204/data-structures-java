package Graphs;

/*
Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges,
represented by a 2D array edges[][], where edges[i] = [u, v, w] represents an edge
between nodes u and v having weight w.

Find the shortest distance of all the vertices from the source vertex src, and return
an array of integers where the ith element denotes the shortest distance between the
source vertex and vertex i.

Note:
The graph is connected and doesn't contain any negative weight edge.
It is guaranteed that all the shortest distances will fit in a 32-bit integer.

Examples:

Input:
V = 3, edges[][] = [[0, 1, 1], [1, 2, 3], [0, 2, 6]], src = 2

Output:
[4, 3, 0]

Explanation:
For 2 to 0, minimum distance will be 4. By following path 2 -> 1 -> 0.
For 2 to 1, minimum distance will be 3. By following path 2 -> 1.
For 2 to 2, minimum distance will be 0.

Input:
V = 5, edges[][] = [[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]], src = 0

Output:
[0, 4, 8, 10, 10]

Explanation:
For 0 to 1, minimum distance is 4.
For 0 to 2, minimum distance is 8.
For 0 to 3, minimum distance is 10.
For 0 to 4, minimum distance is 10.

Constraints:
1 ≤ V ≤ 10^6
1 ≤ E = edges.size() ≤ 10^6
0 ≤ edges[i][0], edges[i][1] < V
0 ≤ edges[i][2] ≤ 10^4
0 ≤ src < V
*/

import java.util.*;

public class Dijkstra_Algorithm {
    public static void main(String[] args) {
        int V = 3;

        int[][] edges = {
                {0, 1, 1},
                {1, 2, 3},
                {0, 2, 6}
        };

        int src = 2;

        ArrayList<Integer> result = dijkstra(V, edges, src);
        System.out.println(result);
    }

    public static ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int[] res = new int[V];
        Arrays.fill(res, Integer.MAX_VALUE);

        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        for(int i=0;i<V;i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[1])
        );

        res[src] = 0;
        minHeap.offer(new int[]{src, 0}); // {node, dist}

        while(!minHeap.isEmpty()){
            int[] arr = minHeap.poll();

            int u = arr[0]; // node
            int d = arr[1]; // dist

            if(d > res[u]) continue;

            for(int[] edge:graph.get(u)){
                int v = edge[0];
                int w = edge[1];

                if(d + w < res[v]){
                    res[v] = d + w;
                    minHeap.offer(new int[]{v, res[v]});
                }
            }
        }

        for(int num:res){
            result.add(num);
        }

        return result;
    }
}