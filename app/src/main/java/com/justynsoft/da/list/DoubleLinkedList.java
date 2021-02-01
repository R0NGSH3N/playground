package com.justynsoft.da.list;

/**
 * Created by rongshen on 2/1/15.
 */
public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private Integer size = 0;

    public void insert(String data, Integer position) {
        Node<String> element = new Node<String>(data, null, null);
        if(head == null){
            head = tail = element;
        }else{
            Node prevNode = get(position - 1);
            element.setPrevNode(prevNode);
            element.setNextNode(prevNode.getNextNode());
            prevNode.setNextNode(element);
            Node nextNode = element.getNextNode();
            nextNode.setPrevNode(element);
        }
        size ++;
    }

    public void delete(Integer position) {
        if(size > 0){
            Node targetElement = get(position);
            Node prevElement = targetElement.getPrevNode();
            Node nextElement = targetElement.getNextNode();
            prevElement.setNextNode(targetElement.getNextNode());
            nextElement.setPrevNode(targetElement.getPrevNode());
            size--;
        }
    }

    public Node get(Integer position) {
        Node currentElement = head;
        for(int i = 0;  i < position; i++){
            currentElement = head.getNextNode();
        }
        return currentElement;
    }


    private static class Node<E> {
        private E data;
        private Node<E> prevNode;
        private Node<E> nextNode;

        public Node(E data, Node prevNode, Node nextNode) {
            this.data = data;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node<E> prevNode) {
            this.prevNode = prevNode;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }
    }
}
