package com.justynsoft.da.list;

/**
 * Created by rongshen on 1/29/15.
 */
public class CircleLinkedList<E> {
    private Node header;
    private Node tail;
    private int size = 0;

    public void addAfterHeader(E data){
        Node newNode = new Node(data, null);
        if(header == null){
            header = tail = newNode;
            tail.setNextNode(header);
        }else{
            newNode.setNextNode(header.getNextNode());
            header.setNextNode(newNode);
        }
        size++;
    }

    /**
     * trick for circle linked list
     * @param data
     */
    public void addAfterTail(E data){
        Node newNode = new Node(data, null);
        if(header ==  null){
           header = tail = newNode;
            tail.setNextNode(header);
        }else{
            tail.setNextNode(newNode);
            newNode.setNextNode(header);
            tail = newNode;
        }

    }

    public void insert(E data, int position){

    }

    public void delete(int position){

    }

    public Node get(int position){
       return null;
    }

    private static class Node<E>{
        private E data;
        private Node<E> nextNode;

        public Node(E data, Node nextNode){
            this.data = data;
            this.nextNode = nextNode;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }
    }
}
