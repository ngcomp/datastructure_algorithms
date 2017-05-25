package com.ngcomp.ds.linked_list;

/**
 * Created by Ram Parashar on 5/21/17.
 */
public class RotateList implements Base{


//    static class ListNode{
//        int val;
//        ListNode next;
//        ListNode(int x) { val = x; }
//    }


    public static void printList(ListNode head){
        while(head!=null){
            System.out.println(head.val + " ");
            head = head.next;
        }
    }


    public static ListNode rotateRight(ListNode head, int k) {

        if(head == null || k == 0){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        int len = 0;

        while(k-- > 0){
            fast = fast.next;
            len ++;
            if(fast == null){
                k = k % len;
                fast = head;
            }
        }

        if (fast == null || slow == fast) return head;

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }


        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;

    }


    public static void main(String[] args) {

        ListNode item1 = new ListNode(1);
        ListNode item2 =  new ListNode(2);
        ListNode item3 =  new ListNode(3);
        ListNode item4 =  new ListNode(4);
        ListNode item5 =  new ListNode(5);

        item1.next = item2;
        item2.next = item3;
        item3.next = item4;
        item4.next = item5;

        ListNode head = rotateRight(item1, 3);
        printList(head);

    }
}
