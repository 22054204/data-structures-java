package Graphs;

/*
You are given a directed graph in the form of an adjacency list, where each element adj[i] contains a list of all vertices adjacent to vertex i.
Your task is to convert this adjacency list into an adjacency matrix representation.

Examples:

Input:
adj[][] = [[1, 3], [2], [], [2]]

Output:
[[0, 1, 0, 1],
 [0, 0, 1, 0],
 [0, 0, 0, 0],
 [0, 0, 1, 0]]

Explanation:
The edges in the graph are (0, 1), (0, 3), (1, 2), and (3, 2).
Hence, in the adjacency matrix, the cells (0,1), (0,3), (1,2), and (3,2) are marked 1.

Input:
adj[][] = [[1, 2], [2], [3, 4], [0], []]

Output:
[[0, 1, 1, 0, 0],
 [0, 0, 1, 0, 0],
 [0, 0, 0, 1, 1],
 [1, 0, 0, 0, 0],
 [0, 0, 0, 0, 0]]

Explanation:
The edges in the graph are (0,1), (0,2), (1,2), (2,3), (2,4), and (3,0).
Hence, in the adjacency matrix, the cells (0,1), (0,2), (1,2), (2,3), (2,4), and (3,0) are marked 1.

Constraints:
1 ≤ V = adj.size() ≤ 10^4
0 ≤ adj[i][j] < V
*/

import java.util.*;

public class Convert_Adjacency_List_to_Adjacency_Matrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 3)),
                new ArrayList<>(Arrays.asList(2)),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(2))
        ));

        int[][] result = adjToMat(adj);

        for(int[] row : result){
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] adjToMat(ArrayList<ArrayList<Integer>> adj) {
        // code here

        int[][] mat = new int[adj.size()][adj.size()];

        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                mat[i][adj.get(i).get(j)] = 1;
            }
        }

        return mat;
    }
}