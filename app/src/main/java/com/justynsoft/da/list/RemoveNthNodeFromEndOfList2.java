package com.justynsoft.da.list;

public class RemoveNthNodeFromEndOfList2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode result = removeNthFromEnd(l1, 10);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstPointer = dummy;
        ListNode secondPointer = dummy;

        for(int i = 1; i <= n + 1; i++){
            firstPointer = firstPointer.next;
        }

        while(firstPointer != null){
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        secondPointer.next = secondPointer.next.next;

        return dummy.next;

    }

    public static ListNode removeNthFromEndOLD(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstPoint = dummy ;
        ListNode secondPoint = dummy;
        ListNode preNode = null;
        int indicator = 0;

        while(firstPoint != null){
            if(indicator >= n  ){
                preNode = secondPoint;
                secondPoint = secondPoint.next;
            }

            firstPoint = firstPoint.next;
            indicator = indicator + 1;
        }

        if(secondPoint != null && preNode != null){
            preNode.next = secondPoint.next;
            return head;
        }else{
            return null;
        }

    }
}
