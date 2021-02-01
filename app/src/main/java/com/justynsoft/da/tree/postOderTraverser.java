package com.justynsoft.da.tree;

/**
 * Created by rongshen on 10/18/16.
 */
public class postOderTraverser {
    public static void main(String args[]){
        //create binary tree
        SimpleBinaryTreeIIIX<Integer> node7 = new SimpleBinaryTreeIIIX<Integer>(7,null, null);
        SimpleBinaryTreeIIIX<Integer> node5 = new SimpleBinaryTreeIIIX<Integer>(5,null, node7);
        SimpleBinaryTreeIIIX<Integer> node4 = new SimpleBinaryTreeIIIX<Integer>(4,null, null);
        SimpleBinaryTreeIIIX<Integer> node3 = new SimpleBinaryTreeIIIX<Integer>(3,node4, node5);
        SimpleBinaryTreeIIIX<Integer> node9 = new SimpleBinaryTreeIIIX<Integer>(9,null, null);
        SimpleBinaryTreeIIIX<Integer> node10 = new SimpleBinaryTreeIIIX<Integer>(10,null, null);
        SimpleBinaryTreeIIIX<Integer> nodeR4 = new SimpleBinaryTreeIIIX<Integer>(4,node9, node10);
        SimpleBinaryTreeIIIX<Integer> node2 = new SimpleBinaryTreeIIIX<Integer>(2,null,null);
        SimpleBinaryTreeIIIX<Integer> node1 = new SimpleBinaryTreeIIIX<Integer>(1,node2,nodeR4);
        SimpleBinaryTreeIIIX<Integer> root = new SimpleBinaryTreeIIIX<Integer>(6,node3,node1);

        System.out.println("[");
        PostOrderTraverse(root);
        System.out.println("]");


    }

    public static void PostOrderTraverse(SimpleBinaryTreeIIIX<Integer> node){
        if(node.getLeftNode() != null) {
            PostOrderTraverse(node.getLeftNode());
        }
        if(node.getRightNode() != null){
            PostOrderTraverse(node.getRightNode());
        }
        System.out.print(node.getValue() + ",");
    }

}
