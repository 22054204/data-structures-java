package trees;

import java.util.*;

public class Boundary_Traversal_in_Tree_Anti_Clock_wise {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> traverseBoundary(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;

        result.add(root.data);

        if(root.left!=null) left(root.left, result);
        leaves(root, result);
        if(root.right!=null) right(root.right, result);

        return result;
    }

    public static void left(TreeNode root, List<Integer> result){
        if(root==null || isLeaf(root)) return;

        result.add(root.data);

        if(root.left==null){
            left(root.right, result);
        }else{
            left(root.left, result);
        }
    }

    public static void right(TreeNode root, List<Integer> result){
        if(root==null || isLeaf(root)) return;

        List<Integer> temp = new ArrayList<>();
        solveRight(root, temp);

        for(int i=temp.size()-1;i>=0;i--){
            result.add(temp.get(i));
        }
    }

    public static void solveRight(TreeNode root, List<Integer> temp){
        if(root==null || isLeaf(root)) return;

        temp.add(root.data);

        if(root.right==null){
            solveRight(root.left, temp);
        }else{
            solveRight(root.right, temp);
        }
    }

    public static void leaves(TreeNode root, List<Integer> result){
        if(root==null) return;

        if(isLeaf(root)){
            result.add(root.data);
            return;
        }

        if(root.left!=null) leaves(root.left, result);
        if(root.right!=null) leaves(root.right, result);
    }

    public static boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);

        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(25);

        root.left.right.left = new TreeNode(7);

        List<Integer> result = traverseBoundary(root);

        System.out.println(result);
    }
}
