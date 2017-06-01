package com.ngcomp.ds.linked_list.algo;

/**
 * Created by Ram Parashar on 5/25/17.
 */
public class NumberAddition{
  
  private static class Node {
    int val;
    Node next;
    Node(int x) { val = x; }
  }
  
  
  public static void printList(Node head){
    while(head!=null){
      System.out.println(head.val + " ");
      head = head.next;
    }
  }
  
  
  public static Node addTwoNumbers(Node l1, Node l2) {
  
    Node p1 = l1;
    Node p2 = l2;
    Node start = null;
    Node result = null;
    
    int carry = 0;
    while(l1!= null || l2!=null){
      int sum = 0;
      if(l1!=null){
        sum += l1.val;
        l1 = l1.next;
      }
      if(l2!=null){
        sum+=l2.val;
        l2 = l2.next;
      }
      sum += carry;

      carry = sum / 10;
      sum   = sum%10;

      Node node = new Node(sum);
      
      if(result == null){
        result = node;
        start  = node;
      }else{
        result.next = node;
        result = node;
      }
      
    }
    
    if(carry!=0){
      result.next = new Node(carry);
    }
    
    return start;
  }
  
  
  
  public static void main(String[] args) {
    Node l1i1 = new Node(1);
    Node l1i2 = new Node(5);
    Node l1i3 = new Node(5);
    l1i1.next = l1i2;
    l1i2.next = l1i3;
    
    Node l2i1 = new Node(2);
    Node l2i2 = new Node(1);
    Node l2i3 = new Node(5);
    l2i1.next = l2i2;
    l2i2.next = l2i3;
    
    Node sum = addTwoNumbers(l1i1, l2i1);
    printList(sum);
    
  }
  
  
}
