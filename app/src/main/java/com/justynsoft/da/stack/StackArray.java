package com.justynsoft.da.stack;

import java.util.Arrays;

/**
 * Created by rongshen on 2/1/15.
 */
public class StackArray {
    private String[] stack;
    private Integer depth;

    public void init(Integer depth) {
        this.stack = new String[depth];
        this.depth = 0;
    }

    public int getTop(){
        return depth;
    }

    public String pop() {
        int curr = --depth;
        String topValue = stack[curr];
        stack[curr] = null;
        return topValue;
    }

    public void push(String data) {
        stack[depth++] = data;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }

    public static void main(String[] args) {
        StackArray sar = new StackArray();
        sar.init(10);
        for (int i = 0; i < 7; i++) {
            sar.push(i + " yuan");
        }

        System.out.println(" *** After push *** " + sar.toString());
        System.out.printf("%n *** the depth is: %d%n", sar.depth);
        int currDepth = sar.getTop();

        for (int i = 0; i < currDepth;i++) {
            System.out.printf(" ***Element: %s , Depth After Pop: %d, *** %n", sar.pop(), sar.getTop());
        }

        System.out.println(" *** After pop*** " + sar.toString());

    }


}
