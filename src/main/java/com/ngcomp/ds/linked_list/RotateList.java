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


    public static void printList(Node head){
        while(head!=null){
            System.out.println(head.val + " ");
            head = head.next;
        }
    }


    public static Node rotateRight(Node head, int k) {

        if(head == null || k == 0){
            return head;
        }

        Node slow = head;
        Node fast = head;

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


        Node newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;

    }


    public static void main(String[] args) {

        Node item1 = new Node(1);
        Node item2 =  new Node(2);
        Node item3 =  new Node(3);
        Node item4 =  new Node(4);
        Node item5 =  new Node(5);

        item1.next = item2;
        item2.next = item3;
        item3.next = item4;
        item4.next = item5;

        Node head = rotateRight(item1, 3);
        printList(head);

    }
}
