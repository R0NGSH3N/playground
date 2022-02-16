package com.justynsoft.da.tree;

/**
 * Created by rongshen on 10/10/16.
 */
public interface SimpleBinaryTreeII<E extends Comparable> {
    public boolean search(E toFind);
    public void insert(E toInsert);
}

class SimpleNode<T extends Comparable> implements SimpleBinaryTreeII<T>{
    public T value;
    public SimpleNode<T> left;
    public SimpleNode<T> right;

    @Override
    public boolean search(T toFind){
        if(toFind.compareTo(value) < 0){
            return left.search(toFind);
        }else if (toFind.compareTo(value) > 0){
           return right.search(toFind) ;
        }else{
            return true;
        }
    }

    @Override
    public void insert(T toInsert){

    }
}
