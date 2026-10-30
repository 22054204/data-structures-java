package Graphs;

import java.util.*;
public class DisJoint_Union_Set_With_Union_By_Size {
    static int[] parent;
    static int[] size;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);  // path compression
    }

    static void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent != y_parent) {
            if (size[x_parent] < size[y_parent]) {
                parent[x_parent] = y_parent;
                size[y_parent] += size[x_parent];
            } else if (size[x_parent] > size[y_parent]) {
                parent[y_parent] = x_parent;
                size[x_parent] += size[y_parent];
            } else { // size[x_parent] == size[y_parent
                parent[y_parent] = x_parent;
                size[x_parent] += size[y_parent];
            }
        }
    }

    public static void main(String[] args) {

        parent = new int[6];
        size = new int[6];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        union(0, 1);
        union(2, 3);
        union(0, 2);
        union(4, 5);
        union(0, 4);

        System.out.println("Parent Array: " + Arrays.toString(parent));
        System.out.println("Size Array: " + Arrays.toString(size));

        System.out.println(find(3));
        System.out.println(find(5));
    }
}
