
package Graphs;

public class DisJoint_Union_Set_With_Path_Compression {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]); // Path Compression
    }

    static void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent != y_parent) {
            parent[y_parent] = x_parent;
        }
    }

    public static void main(String[] args) {

        parent = new int[6];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        union(1, 0);
        union(2, 1);
        union(3, 2);
        union(4, 3);
        union(5, 4);

        System.out.println(find(0));
        System.out.println(find(1));
        System.out.println(find(2));
    }
}
