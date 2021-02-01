package com.justynsoft.da.tree;

/**
 * Created by rongshen on 10/17/16.
 */
public class SimpleBinaryTreeIIIX<T> {

    public SimpleBinaryTreeIIIX(){}

    public SimpleBinaryTreeIIIX(T value, SimpleBinaryTreeIIIX<T> leftNode, SimpleBinaryTreeIIIX<T> rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public String toString(){
       StringBuilder sb = new StringBuilder() ;
        sb.append("node value[" + value + "]\n");
        sb.append("left Node value :[" + (leftNode  == null ? "" : leftNode.getValue()) + "]\n");
        sb.append("left Node tag :[" + leftTag + "]\n");
        sb.append("Right Node value :[" + (rightNode == null ? "" : rightNode.getValue()) + "]\n");
        sb.append("Right Node tag :[" + rightTag + "]\n");

        return sb.toString();

    }

    private T value;
    private SimpleBinaryTreeIIIX<T> leftNode;
    private SimpleBinaryTreeIIIX<T> rightNode;
    private boolean leftTag = false;
    private boolean rightTag = false;

    public boolean isLeftTag() {
        return leftTag;
    }

    public void setLeftTag(boolean leftTag) {
        this.leftTag = leftTag;
    }

    public boolean isRightTag() {
        return rightTag;
    }

    public void setRightTag(boolean rightTag) {
        this.rightTag = rightTag;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SimpleBinaryTreeIIIX<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(SimpleBinaryTreeIIIX<T> leftNode) {
        this.leftNode = leftNode;
    }

    public SimpleBinaryTreeIIIX<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(SimpleBinaryTreeIIIX<T> rightNode) {
        this.rightNode = rightNode;
    }
}
