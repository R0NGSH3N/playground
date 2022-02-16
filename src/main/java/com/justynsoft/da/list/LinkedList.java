package com.justynsoft.da.list;

/**
 * Created by rongshen on 1/28/15.
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private Integer size = 0;

    public Integer getSize(){
        return size;
    }


    public static void main(String[] args){
        LinkedList list = new LinkedList();
        //create list
        for(int i= 0; i<= 10; i++){
//            list.addAfterHead(i +"");
            list.addBeforeTail(i + "");
        }

        //iterate
        for(int i = 0; i< list.getSize(); i++ ){
            System.out.println(" item " +  i + " is: " + list.get(i).getValue() );
        }

        //insert
        list.insert("inserter", 5);
        System.out.println("****AFTER Insert 5 ******");
        for(int i = 0; i< list.getSize(); i++ ){
            System.out.println(" item " +  i + " is: " + list.get(i).getValue() );
        }

        //delete
        list.delete("inserter");
        System.out.println("****AFTER DELETE 5 ******");
        for(int i = 0; i< list.getSize(); i++ ){
            System.out.println(" item " +  i + " is: " + list.get(i).getValue() );
        }


    }

    public void addAfterHead(String data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNextNode(head.nextNode);
            head.setNextNode(newNode);
        }
        size++;
    }

    public void addBeforeTail(String data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
        size++;
    }

    public void insert(String data, int position) {
        Node newNode = new Node(data, null);
        Node previousNode = get(position - 1);
        newNode.setNextNode(previousNode.getNextNode());
        previousNode.setNextNode(newNode);
        size++;
    }

    public void delete(String data) {
        Node currentNode = head;
        //if need to remove head, thing is easy
        if (head.getValue().equals(data)) {
            head = head.getNextNode();
            size--;
            return;
        }

        for (int i = 0; i <= size; i++) {
            Node targetNode = currentNode.getNextNode();
            if (targetNode.getValue().equals(data)) {
                currentNode.setNextNode(targetNode.getNextNode());
                size--;
                return;
            } else {
                currentNode = currentNode.getNextNode();
            }
        }

    }

    public Node get(int position) {
        Node currentNode = head;
        for (int i = 0; i < position; i++) {
            currentNode = currentNode.getNextNode();
        }

        return currentNode;
    }

    private static class Node<E> {
        private E value;
        private Node<E> nextNode;

        public Node(E value, Node<E> nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }

        public E getValue() {
            return value;
        }

        public Node getNextNode() {
            return nextNode;
        }

    }
}
