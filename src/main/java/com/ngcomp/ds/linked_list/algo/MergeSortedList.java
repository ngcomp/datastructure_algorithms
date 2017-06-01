package com.ngcomp.ds.linked_list.algo;

/**
 * Created by Ram Parashar on 5/25/17.
 */
public class MergeSortedList{
  
  private static class Node {
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
  
  
  public static Node mergeTwoLists(Node list1, Node list2) {
    
    if(list1 == null){
      return list2;
    }
    
    //Insert Integer.MIN_VALUE as the first node in L1.
    Node dummy = new Node(Integer.MIN_VALUE);
    dummy.next = list1;
    list1 = dummy; 
    
    
    
    
    Node p1 = list1;
    Node p2 = list2;
    
    while(p1!= null && p2!=null){
      
      if(p1.val < p2.val){
        dummy = p1;
        p1 = p1.next;
      }else if(p1.val >= p2.val){
        Node tmp = p2; 
        p2 = p2.next;
        tmp.next   = p1;
        dummy.next = tmp;
        dummy      = tmp;
      }
    }
    
    if(p2 != null){
      dummy.next = p2;
    }
    
    return list1.next;
  }
  
  
  
  public static void main(String[] args) {
    
    Node l1i1 = new Node(4);
    Node l1i2 = new Node(5); l1i1.next = l1i2;
    Node l1i3 = new Node(50);l1i2.next = l1i3;
    
    
    Node l2i1 = new Node(2);
    Node l2i2 = new Node(10);
    Node l2i3 = new Node(42);
    l2i1.next = l2i2;
    l2i2.next = l2i3;
    
    l1i1 = mergeTwoLists(l1i1, l2i1);
    
    printList(l1i1);
    
  }
  
  
}
