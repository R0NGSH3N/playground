package com.justynsoft.da.tree;

import java.util.List;

/**
 * Created by rongshen on 10/13/16.
 *
 * Children storage approach -- THIS IS NOT NECESSARY BE BINARY...ACTUALLY BINARY USE THIS NOT WORTH
 */
public class SimpleTree<T>{
    private List<NodeII> tree;

    public List<NodeII> getTree() {
        return tree;
    }

    public void setTree(List<NodeII> tree) {
        this.tree = tree;
    }

    public boolean search (T value){
        return false;
    }

    public void insert(T value){

    }
}

class NodeII<T>{
    private T value;
    //how many children
    private Integer degree;
    private List<Node> children;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
