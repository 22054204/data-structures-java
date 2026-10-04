package Graphs;

/*
You are given an undirected graph represented by its adjacency matrix mat[][], where mat[i][j] = 1 indicates that there is an edge between vertex i and vertex j, and mat[i][j] = 0 indicates no edge.
Your task is to convert the given adjacency matrix into its corresponding adjacency list representation.
In the resulting adjacency list, each adj[i] should contain all vertices that are directly connected to vertex i.

Examples:

Input:
mat[][] = [[0, 1, 0, 1],
           [1, 0, 1, 0],
           [0, 1, 0, 1],
           [1, 0, 1, 0]]

Output:
[[1, 3], [0, 2], [1, 3], [0, 2]]

Explanation:
The adjacency matrix represents the graph and hence the adjacency list is [[1, 3], [0, 2], [1, 3], [0, 2]].

Input:
mat[][] = [[0, 1, 1, 0, 0],
           [1, 0, 1, 0, 0],
           [1, 1, 0, 1, 1],
           [0, 0, 1, 0, 0],
           [0, 0, 1, 0, 0]]

Output:
[[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]

Explanation:
The adjacency matrix represents the graph and hence the adjacency list is [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]].

Constraints:
1 ≤ V = mat.size() ≤ 100
1 ≤ mat[0].size() ≤ 100
*/

import java.util.*;

public class Convert_Adjacency_Matrix_to_Adjacency_List {
    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        ArrayList<ArrayList<Integer>> result = matToAdj(mat);
        System.out.println(result);
    }

    public static ArrayList<ArrayList<Integer>> matToAdj(int[][] mat) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i=0;i<mat.length;i++){
            result.add(new ArrayList<>());
        }

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=0){
                    result.get(i).add(j);
                }
            }
        }

        return result;
    }
}