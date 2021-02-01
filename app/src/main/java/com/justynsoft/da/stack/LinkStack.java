package com.justynsoft.da.stack;

/**
 * Created by rongshen on 2/2/15.
 */
public class LinkStack {
    private Node tail;
    private Integer size  = 0;

    public static void main(String[] args){
        LinkStack ls = new LinkStack();
        for(int i = 0; i <= 10; i++){
            ls.push( i + "");
        }

        for(int i = 0; i <= 10; i++){
            System.out.printf("%n *** item: %d ***: %s ", i, ls.pop());
        }
    }

    public void push(String data){
        Node<String> element = new Node<String>(data, null);
        if(tail == null){
            tail = element;
        }else{
            element.setPrevNode(tail);
            tail = element;
        }

        size++;
    }

    public String pop(){
        String returnData = (String)tail.getData();
        tail = tail.getPrevNode();
        size--;
        return returnData;
    }

    private static class Node<E>{
        private E data;
        private Node<E> prevNode;

        public Node(E data, Node nextNode){
            this.data = data;
            this.prevNode = nextNode;
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
    }
}
