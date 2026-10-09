package Graphs;

public class DisJoint_Union_Set_Without_Optimization {
    static int[] parent;

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
            parent[y_parent] = x_parent;
        }
    }

    public static void main(String[] args) {

        parent = new int[6];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        union(0, 1);
        union(1, 2);
        union(2, 3);
        union(3, 4);
        union(4, 5);

        System.out.println(find(3));
        System.out.println(find(4));
        System.out.println(find(5));
    }
}

