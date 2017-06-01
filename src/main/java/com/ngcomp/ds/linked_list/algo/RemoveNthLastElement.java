package com.ngcomp.ds.linked_list.algo;

/**
 * Solved using slow and fast pointer approach.
 * Created by Ram Parashar on 5/25/17.
 */
public class RemoveNthLastElement{
  
  private static class Node{
    int val;
    public Node next;
    Node(int x) { val = x; }
  }
  
  
  public static void printList(Node head){
    System.out.println("--------------------------------");
    while(head!=null){
      System.out.println(head.val + " ");
      head = head.next;
    }
  }
  
  
  /**
   * Steps:
   * 1) Jump fast pointer by n nodes.
   * 2) Move both fast and slow pointers at same time till fast != null
   * 3) Delete node slow.next by setting slow.next = slow.next.next pointer there.
   * @param head
   * @param n
   * @return
   */
  public static Node removeNthFromEnd(Node head, int n) {
    
    if(head == null){
      return null;
    }
    Node slow = head;
    Node fast = head;
    
    int count = 0;
    
    while(count++ < n){
      fast = fast.next;
    }
    
    
    if(fast == null){
      head = head.next;
      return head;
    }
    
    while(fast.next !=null){
      fast = fast.next;
      slow = slow.next;
    }
    
    slow.next = slow.next.next;
    
    return head;
  }
  
  
  public static void main(String[] args) {
    
    Node l1i1 = new Node(1);
    Node l1i2 = new Node(2);
    Node l1i3 = new Node(8);
    Node l1i4 = new Node(10);
    
    l1i1.next = l1i2;
    l1i2.next = l1i3;
    l1i3.next = l1i4;
    
    printList(l1i1);
    Node sum = removeNthFromEnd(l1i1, 3);
    printList(sum);
    
  }
  
}
