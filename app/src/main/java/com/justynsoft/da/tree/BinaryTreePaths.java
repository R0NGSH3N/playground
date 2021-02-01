package com.justynsoft.da.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        TreeNode node5= new TreeNode(5);
        TreeNode node2= new TreeNode(2);
        TreeNode node3= new TreeNode(3);
        node2.right = node5;
        root.left = node2;
        root.right = node3;

        List<String> result = binaryTreePaths(root);
        System.out.println(result);

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root == null){
            return result;
        }
        String path = root.val + "";
        dfs(root, path, result);
        return result;
    }

    public static void dfs(TreeNode node, String path, List<String> result) {
        //exit condition, reach to leaf
        if (node.left == null && node.right == null) {
            //path = path + "->" + node.val;
            result.add(path);
            return;
        }

        if (node.left != null) {
            String newpath = path + "->" + node.left.val;
            dfs(node.left, newpath, result);
        }
        if (node.right != null) {
            String newpath = path + "->" + node.right.val;
            dfs(node.right, newpath, result);
        }

    }
}
