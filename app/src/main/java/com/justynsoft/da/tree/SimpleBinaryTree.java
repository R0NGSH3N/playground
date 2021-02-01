package com.justynsoft.da.tree;

/**
 * Created by rongshen on 10/10/16.
 */
public class SimpleBinaryTree<E extends Comparable> {
    private E value;
    private SimpleBinaryTree<E> left;
    private SimpleBinaryTree<E> right;

    public SimpleBinaryTree(E value, SimpleBinaryTree leftNode, SimpleBinaryTree rightNode){
       this.value = value;
        this.left = leftNode;
        this.right = rightNode;
    }

    //I don't think return true/false for search is correct, it should return level + degree
    public boolean search(E toFind){
       if(toFind.equals(this.value)){
           return true;
       }

        if(left != null && toFind.equals(left.value)){
            return true;
        }

        if(right != null && toFind.equals(right.left)){
            return true;
        }

        return false;
    }

    public void insert(E toInsert){
        if(toInsert.compareTo(value) <= 0){
            if(this.left != null){
               left.insert(toInsert);
            }else{
                this.left = new SimpleBinaryTree<E>(toInsert, null, null);
            }
        }else{
            if(this.right != null){
                right.insert(toInsert);
            }else{
                this.right = new SimpleBinaryTree<E>(toInsert, null, null);
            }
        }
    }
}
