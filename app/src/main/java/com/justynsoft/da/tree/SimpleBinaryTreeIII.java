package com.justynsoft.da.tree;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by rongshen on 10/13/16.
 *
 * each node store the parent -- very stupid, can't search
 */
public class SimpleBinaryTreeIII<T>{
    private List<Node> tree;

    public SimpleBinaryTreeIII(List<Node> tree){
        this.tree = tree;
    }

    public List<Node> getTree() {
        return tree;
    }

    public void setTree(List<Node> tree) {
        this.tree = tree;
    }

    public boolean search(T value){

        return false;
    }

    public void insert(T value){

    }

    public static void main(String args[]){
        List<Node> simpleTree = new ArrayList<Node>();
        //construct a string trees:
        //root node, value: A, my position: 0, parent Position: -1
        Node<String> root = new Node<String>("A", 0, -1);
        simpleTree.add(root);
        //first level left node: value: B, myposition 1, parent Position: 0 --> A
        Node<String> nodeB = new Node<String>("B", 1, 0);
        simpleTree.add(nodeB);
        //first level right node: value: C, myposition 2, parent Position: 0 --> A
        Node<String> nodeC = new Node<String>("B", 2, 0);
        simpleTree.add(nodeC);
        //second level left node: value: D, myposition 3, parent Position: 1 --> B
        Node<String> nodeD = new Node<String>("D", 3, 1);
        simpleTree.add(nodeD);
        //second level right node: value: E, myposition 4, parent Position: 1 --> B
        Node<String> nodeE = new Node<String>("E", 4, 1);
        simpleTree.add(nodeE);
        //second level(C) left node: value: F, myposition 5, parent Position: 2 --> C
        Node<String> nodeF = new Node<String>("F", 5, 2);
        simpleTree.add(nodeF);
        //third level(E) left node: value: G, myposition 6, parent Position: 4 --> E
        Node<String> nodeG = new Node<String>("G", 6, 4);
        simpleTree.add(nodeG);
        //third level(E) right node: value: H, myposition 7, parent Position: 4 --> E
        Node<String> nodeH = new Node<String>("G", 7, 4);
        simpleTree.add(nodeH);

        SimpleBinaryTreeIII<String> simpleBinaryTreeIII = new SimpleBinaryTreeIII(simpleTree);
        simpleBinaryTreeIII.search("G");

    }



}

class Node<T>{

    private T value;
    private Integer parentPosition;
    private Integer myPosition;

    public Node(T value, Integer myPosition, Integer parentPosition ){
        this.value = value;
        this.parentPosition = parentPosition;
        this.myPosition = myPosition;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Integer getParentPosition() {
        return parentPosition;
    }

    public void setParentPosition(Integer parentPosition) {
        this.parentPosition = parentPosition;
    }

    public Integer getMyPosition() {
        return myPosition;
    }

    public void setMyPosition(Integer myPosition) {
        this.myPosition = myPosition;
    }
}
