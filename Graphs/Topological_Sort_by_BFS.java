package Graphs;

/*
Given a Directed Acyclic Graph (DAG) with V vertices numbered from 0 to V - 1 and E directed edges represented by a 2D array edges[][], where edges[i] = [u, v] denotes a directed edge from vertex u to vertex v, return a topological ordering of all the vertices.

A topological ordering is a linear ordering of the vertices such that for every directed edge u -> v, vertex u appears before vertex v in the ordering.

Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.

Examples:

Input:
V = 4, E = 3
edges[][] = [[3, 0], [1, 0], [2, 0]]

Output:
true

Explanation:
The output true denotes that the order is valid.
Few valid Topological orders for the given graph are:
[3, 2, 1, 0]
[1, 2, 3, 0]
[2, 3, 1, 0]

Input:
V = 6, E = 6
edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5, 2]]

Output:
true

Explanation:
The output true denotes that the order is valid.
Few valid Topological orders for the graph are:
[4, 5, 0, 1, 2, 3]
[5, 2, 4, 0, 1, 3]

Constraints:
2 ≤ V ≤ 5 × 10^3
1 ≤ E = edges.size() ≤ min(10^5, (V * (V - 1)) / 2)
0 ≤ edges[i][0], edges[i][1] < V
*/

/* Topological Sorting By BFS - Kahn's Algorithm */

import java.util.*;

public class Topological_Sort_by_BFS {
    public static void main(String[] args) {
        int V = 4;

        int[][] edges = {
                {3, 0},
                {1, 0},
                {2, 0}
        };

        ArrayList<Integer> result = topoSort(V, edges);
        System.out.println(result);
    }

    static int[] indegree;
    static ArrayList<Integer> result = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
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

        return result;
    }

    public static void solve(HashMap<Integer, List<Integer>> graph) {
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