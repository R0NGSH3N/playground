package com.justynsoft.da.tree;

/**
 * Created by rongshen on 10/17/16.
 */
public class InOrderTraverser {

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
        InOrderTraverse(root);
        System.out.println("]");


    }

    public static void InOrderTraverse(SimpleBinaryTreeIIIX<Integer> node){
        if(node.getLeftNode() != null) {
            InOrderTraverse(node.getLeftNode());
        }
        System.out.print(node.getValue() + ",");
        if(node.getRightNode() != null){
            InOrderTraverse(node.getRightNode());
        }
    }
}
