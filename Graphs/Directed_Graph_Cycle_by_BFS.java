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

/* Using BFS - Kahn's Algorithm */

import java.util.*;

public class Directed_Graph_Cycle_by_BFS {
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

    static int[] indegree;
    static ArrayList<Integer> result = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static boolean isCyclic(int V, int[][] edges) {
        // code here

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<V;i++){
            map.put(i, new ArrayList<>());
        }

        indegree = new int[V];

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            map.get(u).add(v);
            indegree[v]++;
        }

        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            solve(map);
        }

        return result.size()!=V;
    }

    public static void solve(HashMap<Integer, List<Integer>> graph){
        int u = queue.poll();
        result.add(u);

        for(int v:graph.get(u)){
            indegree[v]--;

            if(indegree[v]==0){
                queue.offer(v);
            }
        }
    }
}