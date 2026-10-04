package Graphs;

/*
Given an undirected graph containing V vertices numbered from 0 to V - 1, represented by a 2D adjacency list adj[][], where each adj[i] represents the list of vertices connected to vertex i. You are also given two vertices u and v. Your task is to determine whether there is a direct edge between u and v in the graph.
If an edge exists between u and v, return true; otherwise, return false.

Examples :

Input: adj[][] = [[1, 3, 4], [0, 2], [1, 4], [0], [0, 2]], u = 0, v = 3

Output: true
Explanation: The graph contains edges (0-1), (0-4), (0-3), (1-2) and (2-4). Since there is a direct edge between vertices 0 and 3, the output is true.

Input: adj[][] = [[2, 3, 4], [3], [0, 3], [0, 1, 2], [0]], u = 3, v = 4

Output: false
Explanation: The graph contains edges (0-2), (0-3), (0-4), (1-3) and (2-3). Since there is no direct edge between vertices 3 and 4, the output is false.

Constraints:
1 ≤ V = adj.size() ≤ 10^4
0 ≤ adj[i][j], u, v < V
*/

import java.util.*;

public class Direct_Edge_Between_Two_Vertices {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(2, 3, 4)),
                new ArrayList<>(Arrays.asList(3)),
                new ArrayList<>(Arrays.asList(0, 3)),
                new ArrayList<>(Arrays.asList(0, 1, 2)),
                new ArrayList<>(Arrays.asList(0))
        ));

        int u = 3;
        int v = 4;

        if (checkEdge(adj, u, v)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static boolean checkEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        //   code here
        return adj.get(u).contains(v);
    }
}