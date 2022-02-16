package com.justynsoft.da.list;

public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        while(curr1 != null || curr2 != null){
            if(curr1 == null){
                dummy.next = curr2;
                curr2 = curr2.next;
                dummy = dummy.next;
                continue;
            }

            if(curr2 == null){
                dummy.next = curr1;
                curr1 = curr1.next;
                dummy = dummy.next;
                continue;
            }

            if(curr1.val <= curr2.val){
                dummy.next = curr1;
                curr1 = curr1.next;
            }else{
                dummy.next = curr2;
                curr2 = curr2.next;
            }
            dummy = dummy.next;

        }

        return result.next;
    }
}
