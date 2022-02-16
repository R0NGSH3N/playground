package com.justynsoft.da.list;

public class SwapNodesinPairs {
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
        ListNode result = swapPairs(l1);

    }

    public static ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        head = dummy;

        while (head.next != null && head.next.next != null) {
            ListNode n1 = head.next; ListNode n2 = head.next.next;

            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;

            head = n1;

        }

        return dummy.next;
    }

    public static ListNode swapPairsOLd(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode next = head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode lastRoundNode = null;
        ListNode result = head.next;
        while(curr != null){
            //if odd number of list
            if(curr.next == null ){
                //if only 1 item
                if(lastRoundNode != null){
                    lastRoundNode.next = curr;
                }else{
                    result = head;
                }
                break;
            }else if(curr.next.next != null){
                next = curr.next.next;
            }else{
                next = null;
            }
            prev = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            if(lastRoundNode != null){
                lastRoundNode.next = prev;
            }
            lastRoundNode = curr;
            curr = next;
        }

        return result;
    }
}
