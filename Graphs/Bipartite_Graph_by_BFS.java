package Graphs;

/*
Given a Graph with V vertices (Numbered from 0 to V - 1) and E edges.
Check whether the graph is bipartite or not.

A bipartite graph can be colored with two colors such that no two adjacent
vertices share the same color.

Examples:

Input:
V = 3
edges[][] = [[0, 1], [1, 2]]

Output:
true

Explanation:
The given graph can be colored in two colors, so it is a bipartite graph.

Input:
V = 4
edges[][] = [[0, 3], [1, 2], [3, 2], [0, 2]]

Output:
false

Explanation:
The given graph cannot be colored in two colors such that the colors of
adjacent vertices are different.

Constraints:
1 ≤ V ≤ 2 * 10^5
1 ≤ E ≤ 10^5
edges.size() = E
2 ≤ edges[i].size() ≤ 2
0 ≤ edges[i][0] ≤ 10^5
*/

/* Using BFS */

import java.util.*;

public class Bipartite_Graph_by_BFS {
    public static void main(String[] args) {
        int V = 3;

        int[][] edges = {
                {0, 1},
                {1, 2}
        };

        boolean result = isBipartite(V, edges);
        System.out.println(result);
    }

    static Queue<Integer> queue = new LinkedList<>();
    static int[] color; // -1 -> no Color/Visited yet, 0 -> Color A, 1 -> Color B;

    public static boolean isBipartite(int V, int[][] edges) {
        // Code here

        color = new int[V];
        Arrays.fill(color, -1);

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0;i<V;i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] row:edges){
            int u = row[0];
            int v = row[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=0;i<V;i++){
            if(color[i]==-1){
                color[i] = 0;

                if(!solve(graph, i)) return false;
            }
        }

        return true;
    }

    public static boolean solve(Map<Integer, List<Integer>> graph, int k) {
        queue.offer(k);

        while(!queue.isEmpty()){
            int u = queue.remove();

            for(int v:graph.get(u)){
                if(color[v]==-1){
                    queue.offer(v);
                    color[v] = 1-color[u];
                }
                else if(color[v]==color[u]){
                    return false;
                }
            }
        }

        return true;
    }
}