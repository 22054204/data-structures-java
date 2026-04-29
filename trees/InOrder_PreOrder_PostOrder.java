package trees;

import java.util.*;

public class InOrder_PreOrder_PostOrder{

    // Tree Node Definition
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    // this is function to solve the problem.
    static class Solution {
        static List<List<Integer>> treeTraversal(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            result.add(InOrder(root));
            result.add(PreOrder(root));
            result.add(PostOrder(root));

            return result;
        }

        public static List<Integer> PreOrder(TreeNode root){
            List<Integer> list = new ArrayList<>();
            if(root == null) return list;

            list.add(root.data);
            list.addAll(PreOrder(root.left));
            list.addAll(PreOrder(root.right));
            return list;
        }

        public static List<Integer> InOrder(TreeNode root){
            List<Integer> list = new ArrayList<>();
            if(root == null) return list;

            list.addAll(InOrder(root.left));
            list.add(root.data);
            list.addAll(InOrder(root.right));
            return list;
        }

        public static List<Integer> PostOrder(TreeNode root){
            List<Integer> list = new ArrayList<>();
            if(root == null) return list;

            list.addAll(PostOrder(root.left));
            list.addAll(PostOrder(root.right));
            list.add(root.data);
            return list;
        }
    }
    // Another way to do
    static class sol{
        static List<List<Integer>> treeTraversal(TreeNode root) {

            List<Integer> in = new ArrayList<>();
            List<Integer> pre = new ArrayList<>();
            List<Integer> post = new ArrayList<>();

            InOrder(root, in);
            PreOrder(root, pre);
            PostOrder(root, post);

            List<List<Integer>> result = new ArrayList<>();
            result.add(in);
            result.add(pre);
            result.add(post);

            return result;
        }

        public static void PreOrder(TreeNode root, List<Integer> pre){
            if(root == null) return;

            pre.add(root.data);
            PreOrder(root.left, pre);
            PreOrder(root.right, pre);
        }

        public static void InOrder(TreeNode root, List<Integer> in){
            if(root == null) return;

            InOrder(root.left, in);
            in.add(root.data);
            InOrder(root.right, in);
        }

        public static void PostOrder(TreeNode root, List<Integer> post){
            if(root == null) return;

            PostOrder(root.left, post);
            PostOrder(root.right, post);
            post.add(root.data);
        }
        List<List<Integer>> treeTraversal_Better(TreeNode root) {

            List<Integer> in = new ArrayList<>();
            List<Integer> pre = new ArrayList<>();
            List<Integer> post = new ArrayList<>();

            inorder(root, in);
            preorder(root, pre);
            postorder(root, post);

            List<List<Integer>> result = new ArrayList<>();
            result.add(in);
            result.add(pre);
            result.add(post);

            return result;
        }

        private void preorder(TreeNode root, List<Integer> list){
            if(root == null) return;

            list.add(root.data);
            preorder(root.left, list);
            preorder(root.right, list);
        }

        private void inorder(TreeNode root, List<Integer> list){
            if(root == null) return;

            inorder(root.left, list);
            list.add(root.data);
            inorder(root.right, list);
        }

        private void postorder(TreeNode root, List<Integer> list){
            if(root == null) return;

            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root.data);
        }
    }
    static void main(String[] args) {

        /*
                Example Tree:
                        1
                       / \
                      2   3
                     / \
                    4   5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        sol a = new sol();
        List<List<Integer>> result = sol.treeTraversal(root);

        System.out.println("InOrder  : " + result.get(0));
        System.out.println("PreOrder : " + result.get(1));
        System.out.println("PostOrder: " + result.get(2));
    }
}