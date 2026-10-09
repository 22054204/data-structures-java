package Graphs;

import java.util.*;
public class DisJoint_Union_Set_With_Union_By_Rank {
    static int[] parent;
    static int[] rank;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

    static void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent != y_parent) {
            if (rank[x_parent] < rank[y_parent]) {
                parent[x_parent] = y_parent;
            } else if (rank[x_parent] > rank[y_parent]) {
                parent[y_parent] = x_parent;
            } else {
                parent[y_parent] = x_parent;
                rank[x_parent]++;
            }
        }
    }

    public static void main(String[] args) {

        parent = new int[6];
        rank = new int[6];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        union(0, 1);
        union(2, 3);
        union(0, 2);
        union(4, 5);
        union(0, 4);

        System.out.println("Parent Array: " + Arrays.toString(parent));
        System.out.println("Rank Array: " + Arrays.toString(rank));

        System.out.println(find(3));
        System.out.println(find(5));
    }
}
