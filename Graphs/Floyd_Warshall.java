
package Graphs;

import java.util.*;

/*
Problem: Floyd Warshall Algorithm

Given a weighted directed graph represented by an adjacency matrix dist[][],
where dist[i][j] represents the weight of the edge from node i to node j.
If there is no direct edge, dist[i][j] is set to 100000000 (infinity).

The graph may contain negative edge weights but does not contain
any negative-weight cycles.

Find the shortest distance between every pair of nodes i and j.
Modify the distances in place.

Example 1:
Input:
dist[][] = [
    [0, 4, 100000000, 5, 100000000],
    [100000000, 0, 1, 100000000, 6],
    [2, 100000000, 0, 3, 100000000],
    [100000000, 100000000, 1, 0, 2],
    [1, 100000000, 100000000, 4, 0]
]

Output:
[
    [0, 4, 5, 5, 7],
    [3, 0, 1, 4, 6],
    [2, 6, 0, 3, 5],
    [3, 7, 1, 0, 2],
    [1, 5, 5, 4, 0]
]

Explanation:
Each cell dist[i][j] contains the shortest distance from node i to node j,
considering all possible intermediate nodes.

Example 2:
Input:
dist[][] = [
    [0, -1, 2],
    [1, 0, 100000000],
    [3, 1, 0]
]

Output:
[
    [0, -1, 2],
    [1, 0, 3],
    [2, 1, 0]
]

Explanation:
The shortest distance from node 2 to node 0 is 2 via 2 -> 1 -> 0.
The shortest distance from node 1 to node 2 is 3 via 1 -> 0 -> 2.

Constraints:
1 <= dist.length <= 100
-1000 <= dist[i][j] <= 100000000
dist[i].length = dist.length
*/

public class Floyd_Warshall {
    public static void main(String[] args) {
        int INF = (int) 1e8;

        int[][] dist = {
                {0, 4, INF, 5, INF},
                {INF, 0, 1, INF, 6},
                {2, INF, 0, 3, INF},
                {INF, INF, 1, 0, 2},
                {1, INF, INF, 4, 0}
        };

        floydWarshall(dist);

        for(int[] row : dist){
            System.out.println(Arrays.toString(row));
        }
    }

    public static void floydWarshall(int[][] dist) {
        // Code here

        int n = dist.length;
        int INF = (int) 1e8;

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<dist[0].length;j++){
                    if(dist[i][k] != INF && dist[k][j] != INF){
                        dist[i][j] = Math.min(
                                dist[i][j],
                                dist[i][k] + dist[k][j]
                        );
                    }
                }
            }
        }
    }
}

/*
Expected output:
                [0, 4, 5, 5, 7]
                [3, 0, 1, 4, 6]
                [2, 6, 0, 3, 5]
                [3, 7, 1, 0, 2]
                [1, 5, 5, 4, 0]

Complexity :
            - Time: \(O(V^3)\)
            - Auxiliary space: \(O(1)\), since the distance matrix is modified in place.
 */