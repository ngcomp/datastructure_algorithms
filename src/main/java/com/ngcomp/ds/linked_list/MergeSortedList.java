package com.ngcomp.ds.linked_list;

/**
 * Created by Ram Parashar on 5/25/17.
 */
public class MergeSortedList implements Base{
  
  public static void main(String[] args) {
    
    Node l1i1 = new Node(1);
    Node l1i2 = new Node(5);
    Node l1i3 = new Node(50);
		l1i1.next = l1i2;
		l1i2.next = l1i3;
    
    Node l2i1 = new Node(2);
    Node l2i2 = new Node(10);
    Node l2i3 = new Node(42);
		l2i1.next = l2i2;
		l2i2.next = l2i3;
    
    l1i1 = mergeTwoLists(l1i1, l2i1);
    
    printList(l1i1);
    
  }
  
  
  public static void printList(Node head){
    while(head!=null){
      System.out.println(head.val + " ");
      head = head.next;
    }
  }
  
  
  public static Node mergeTwoLists(Node l1, Node l2) {
    
    if(l1 == null){
      return l2;
    }
    
    
    //Insert Integer.MIN_VALUE as the first node in L1.
    Node dummy = new Node(Integer.MIN_VALUE);
    dummy.next = l1;
    l1 = dummy;
    
    
    Node p1 = l1;
    Node p2 = l2;
    
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
    
    return l1.next;
  }
  
}
