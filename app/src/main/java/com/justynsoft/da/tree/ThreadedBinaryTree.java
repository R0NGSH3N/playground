package com.justynsoft.da.tree;

/**
 * Created by rongshen on 10/18/16.
 */
public class ThreadedBinaryTree<T> {
    private ThreadedBinaryTree() {
    }

    ;

    public static void main(String[] args) {
        //create binary tree
        SimpleBinaryTreeIIIX<Integer> node7 = new SimpleBinaryTreeIIIX<Integer>(7, null, null);
        SimpleBinaryTreeIIIX<Integer> node5 = new SimpleBinaryTreeIIIX<Integer>(5, null, node7);
        SimpleBinaryTreeIIIX<Integer> node4 = new SimpleBinaryTreeIIIX<Integer>(4, null, null);
        SimpleBinaryTreeIIIX<Integer> node3 = new SimpleBinaryTreeIIIX<Integer>(3, node4, node5);
        SimpleBinaryTreeIIIX<Integer> node9 = new SimpleBinaryTreeIIIX<Integer>(9, null, null);
        SimpleBinaryTreeIIIX<Integer> node10 = new SimpleBinaryTreeIIIX<Integer>(10, null, null);
        SimpleBinaryTreeIIIX<Integer> nodeR4 = new SimpleBinaryTreeIIIX<Integer>(4, node9, node10);
        SimpleBinaryTreeIIIX<Integer> node2 = new SimpleBinaryTreeIIIX<Integer>(2, null, null);
        SimpleBinaryTreeIIIX<Integer> node1 = new SimpleBinaryTreeIIIX<Integer>(1, node2, nodeR4);
        SimpleBinaryTreeIIIX<Integer> root = new SimpleBinaryTreeIIIX<Integer>(6, node3, node1);

        System.out.println("before convert");
        printPreOrder(root);
        convert(root);
        System.out.println("\n\n\nafter convert");
        printPreOrder(root);

    }

    public static void printPreOrder(SimpleBinaryTreeIIIX<Integer> node) {
        System.out.println(node.toString());
        if(node.getLeftNode() != null && !node.isLeftTag()){
            printPreOrder(node.getLeftNode());
        }
        if(node.getRightNode() != null && !node.isRightTag()){
            printPreOrder(node.getRightNode());
        }

    }

    /**
     * @param simpleBinaryTree
     * @return convert normal binary tree to threaded binary tree by pre-order traversal
     */
    public static SimpleBinaryTreeIIIX<Integer> preNode = null;

    public static void convert(SimpleBinaryTreeIIIX<Integer> node) {

        if (node.getLeftNode() == null) {
            node.setLeftNode(preNode);
            node.setLeftTag(true);
        }

        preNode = node;
        if (node.getLeftNode() != null && !node.isLeftTag()) {
            convert(node.getLeftNode());
        }

        if(node.getRightNode() == null){
            preNode.setRightNode(node);
            preNode.setRightTag(true);
        }
        if(node.getRightNode() != null && !node.isRightTag()){
            convert(node.getRightNode());
        }
    }
}
