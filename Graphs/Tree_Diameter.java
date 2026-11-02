package Graphs;

/*
        LeetCode 1245 (Premium) - Tree Diameter

        Problem Link :-
        -> https://leetcode.com/problems/tree-diameter/description/
        -> https://leetcode.ca/all/1245.html


        Difficulty: Medium
        Topics: Graph, BFS, DFS, Tree

        Problem Statement:

        Given an undirected tree, return its diameter.

        The diameter of a tree is the number of edges in the longest path
        between any two nodes in the tree.

        The tree is represented as an array of edges, where edges[i] = [u, v]
        indicates that there is an undirected edge between nodes u and v.

        The number of nodes in the tree is n, and the nodes are labelled
        from 0 to n - 1.

        Return the diameter of the tree.

        Examples:

        Example 1:

        Input:
        n = 4
        edges = [[0,1],[1,2],[2,3]]

        Output:
        3

        Explanation:
        The longest path is:
        0 -> 1 -> 2 -> 3

        The path contains 3 edges.
        Therefore, the diameter is 3.


        Example 2:

        Input:
        n = 5
        edges = [[0,1],[0,2],[0,3],[0,4]]

        Output:
        2

        Explanation:
        The longest path is between any two leaf nodes.

        For example:
        1 -> 0 -> 2

        The path contains 2 edges.
        Therefore, the diameter is 2.


        Constraints:

        1 <= n <= 10^4
        edges.length == n - 1
        edges[i].length == 2
        0 <= u, v < n
        u != v
*/
import java.util.*;
public class Tree_Diameter {

    public static void main(String[] args) {

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {1, 4},
                {4, 5}
        };
        /*
        Output: 4
        Explanation: A longest path of the tree is the path 3 - 2 - 1 - 4 - 5.
        */
        System.out.print(solve(edges));
    }
    /* Approach to solve this -
            Pick any random node and find the farthest node from it.
            This farthest node is guaranteed to be one endpoint of the tree diameter.
            Now, pick that endpoint and find the farthest node from it.
            This farthest node is the other endpoint of the tree diameter.
            The distance between these two endpoints is the Tree Diameter.
     */
    static int V = 0;
    static int farthestNode = 0;
    static int maxDist = -1;
    static boolean[] visited;

    public static int solve(int[][] edges){
        V = edges.length+1;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<V;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[V];
        DFS(graph, 0, 0);

        int start = farthestNode;
        visited = new boolean[V];
        maxDist = -1;
        DFS(graph, start, 0);

        return maxDist;
    }
    public static void DFS(HashMap<Integer, List<Integer>> graph, int u, int count){
        visited[u] = true;

        if(count>maxDist){
            maxDist = count;
            farthestNode = u;
        }

        for(int v:graph.get(u)){
            if(!visited[v]){
                DFS(graph, v, count+1);
            }
        }
    }
}