package com.justynsoft.da.list;

public class RotateList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 快慢指针做法
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(k <= 0){
            return head;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        ListNode newHeader = null;
        int counter = 1;

        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            counter += 1;
        }


        if (counter < k) {
            k = k % counter;
        }else if( counter == k){
            return head;
        }

        for (int i = 1; i < (counter - k); i++) {
            slowPointer = slowPointer.next;
        }
        newHeader = slowPointer.next;
        if(newHeader == null){
            return head;
        }
        slowPointer.next = null;
        fastPointer.next = head;
        return newHeader;

    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l1 = new ListNode(0);
        l1.next = l2;
        //l2.next = l3;
        //l3.next = l4;
        //l4.next = l5;
        RotateList rl = new RotateList();
        ListNode result = rl.rotateRight(l1, 2);
        System.out.println(result.val);
    }

    public ListNode rotateRightOLD(ListNode head, int k) {
        int count = 1;
        ListNode curr = head;
        ListNode temp = null;
        ListNode prev = null;
        ListNode newHeader = null;

        while (curr != null) {
            prev = curr;
            //if we found new tail, we just set that next as null
            if (count == k) {
                temp = curr.next;
                curr.next = null;
                newHeader = temp;

                curr = temp;
                temp = null;
                count += 1;
                continue;
            } else if (curr.next == null) { //if reach to the end and count still less than k, reset and go
                if (count < k) {
                    k = k % count;
                    curr = head;
                    count = 1;
                    continue;
                }
            }

            //if we found the new tail in current loop. we need loop start temp -- since curr.next has been reset
            curr = curr.next;
            count += 1;
        }

        prev.next = head;
        return newHeader;
    }

    public ListNode rotateRightOld(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = null;
        ListNode returnHead = null;
        int count = 0;

        while (curr != null) {
            if (count == k) {
                temp = curr.next;
                curr.next = null;
            }
            prev = curr;
            if (temp != null) {
                curr = temp;
                returnHead = temp;
                temp = null;
            } else {
                curr = curr.next;
            }
            //when we reach the end still not found the cut point -- when k is greater count - reset
            if (curr.next == null && temp == null) {
                k = k % count;
                count = 0;
                curr = head;
            } else {
                count += 1;
            }
        }

        if (prev != null) {
            prev.next = head;
        }

        return returnHead;
    }
}
