package com.justynsoft.da.list;

import java.util.Arrays;

/**
 * Created by rongshen on 1/28/15.
 */
public class StaticLinkedList {
    //need big enough array to hold all the elements
    private Element[] array = new Element[15];
    private Element header;
    private Element tail;
    int size = 0;

    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        StaticLinkedList list = new StaticLinkedList();
        for (int i = 1; i <= 11; i++) {
            list.add(i + "");
        }

        System.out.println("**** AFTER CREATE****");
        System.out.println(list.toString());


        list.insert("INSERTER", 6);
        System.out.println("**** AFTER INSERTION ****");
        System.out.println(list.toString());

        list.delete(6);
        System.out.println("**** AFTER DELETION ****");
        System.out.println(list.toString());

    }

    public void add(String data) {
        Element<String> element = new Element(data, null);
        if (header == null) {
            header = tail = element;
            array[0] = header;
        } else {
            int currLength = size;
            array[size] = element;
            tail.setCur(currLength);
            tail = element;
        }
        size++;
    }

    public void insert(String data, int position) {
        Element<String> element = new Element(data, null);
        array[size] = element;

        Element preElement = get(position - 1);
        element.setCur(preElement.getCur());
        preElement.setCur(size);
        size++;

    }

    public void delete(Integer position) {
        Element currElement = header;
        for (int i = 0; i <= position - 1; i++) {
            currElement = array[currElement.getCur()];
        }

        currElement.setCur(array[currElement.getCur()].getCur());
    }


    public Element get(Integer position) {
        Element currElement = header;
        for (int i = 0; i <= position; i++) {
            currElement = array[currElement.getCur()];
        }
        return currElement;
    }

    private static class Element<E> {
        private E data;
        private Integer cursor;

        public Element(E data, Integer cursor) {
            this.data = data;
            this.cursor = cursor;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public int getCur() {
            return cursor;
        }

        public void setCur(Integer cursor) {
            this.cursor = cursor;
        }

        public String toString() {
            return "[data: " + data + " Next Cursor: " + cursor + "]";
        }
    }
}
