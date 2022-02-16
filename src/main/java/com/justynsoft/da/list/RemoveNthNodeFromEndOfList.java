package com.justynsoft.da.list;

public class RemoveNthNodeFromEndOfList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode result = removeNthFromEnd(l1, 2);


    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = reverseList(dummy);
        ListNode temp = tail;
        ListNode pre = null;
        int i = 0;
        while(temp != null){
            if(i == n -1){
                pre.next = temp.next;
                break;
            }
            i = i + 1;
            pre = temp;
            temp = temp.next;
        }

        reverseList(tail);
        return dummy.next;
    }

    private static ListNode reverseList(ListNode head){
       ListNode prev = null;
       ListNode temp = head;
       ListNode next = null;

       while(temp != null){
           next = temp.next;
           temp.next = prev;
           prev = temp;
           temp = next;
       }

       head = prev;
       return head;



    }
}
