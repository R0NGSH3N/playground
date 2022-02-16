package com.justynsoft.da.list;

public class ReverseLinkList {

    public class ListNode{
       int val;
       ListNode next;
       ListNode(int val){this.val = val;}

       public String toString(){
           return "val -> " + val + (next != null ? " next -> " + next.val: " next -> null");
       }
    }

    public ListNode contructLinkedList(){
        ListNode n4 = new ListNode(4);
        n4.next = null;

        ListNode n3 = new ListNode(3);
        n3.next = n4;

        ListNode n2 = new ListNode(2);
        n2.next = n3;

        ListNode n1 = new ListNode(1);
        n1.next = n2;

        return n1;
    }

    public static void reverseLinkedList(ListNode f1){
        ListNode pre = null;

        while(f1 != null){
            ListNode nextTemp = f1.next;
            f1.next = pre;
            pre = f1;
            nextTemp = f1.next;
        }
    }

    public static void main(String[] args){
        ReverseLinkList rl = new ReverseLinkList();
        ListNode fn = rl.contructLinkedList();
        reverseLinkedList(fn);

        while(fn != null){
            System.out.println(fn);
            fn = fn.next;
        }
    }
}
