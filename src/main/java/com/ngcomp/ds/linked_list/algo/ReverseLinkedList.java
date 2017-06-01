package com.ngcomp.ds.linked_list.algo;

/**
 * Created by Ram Parashar on 5/25/17.
 */
public class ReverseLinkedList{
  
  private static class Node{
    int val;
    public Node next;
    Node(int x) { val = x; }
  }
  
  
  public static void printList(Node head){
    while(head!=null){
      System.out.println(head.val + " ");
      head = head.next;
    }
  }
  
  
  public static Node reverseLinkedList(Node head){
    Node previous = null;
    Node next;
    while(head!=null){
      next = head.next;
      head.next = previous;
      previous = head;
      head = next;
    }
    return previous;
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
    
    Node head  = reverseLinkedList(item1);
    printList(head);
  }
  
}
