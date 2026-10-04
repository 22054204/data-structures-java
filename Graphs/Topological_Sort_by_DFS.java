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

/* DFS */

import java.util.*;

public class Topological_Sort_by_DFS {
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

    static ArrayList<Integer> result = new ArrayList<>();
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0;i<V;i++){
            graph.put(i, new ArrayList<>());
        }

        visited = new boolean[graph.size()];

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
        }

        for(int i=0;i<V;i++){
            if(!visited[i]){
                solve(graph, i);
            }
        }

        while(!stack.isEmpty()){
            result.add(stack.pop());
        }

        return result;
    }

    public static void solve(Map<Integer, List<Integer>> graph, int u) {
        visited[u] = true;

        for(int v:graph.get(u)){
            if(!visited[v]){
                solve(graph, v);
            }
        }

        stack.push(u);
    }
}