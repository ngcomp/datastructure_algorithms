package com.ngcomp.ds.linked_list;

/**
 * Created by Ram Parashar on 5/25/17.
 */
public class RemoveNthLastElement implements Base {
  
  
  public static void main(String[] args) {
    
    ListNode l1i1 = new ListNode(1);
    ListNode l1i2 = new ListNode(2);
    ListNode l1i3 = new ListNode(8);
    ListNode l1i4 = new ListNode(10);
    
    l1i1.next = l1i2;
    l1i2.next = l1i3;
    l1i3.next = l1i4;
    
    printList(l1i1);
    ListNode sum = removeNthFromEnd(l1i1, 3);
    printList(sum);
    
  }
  
  
  public static void printList(ListNode head){
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
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    
    if(head == null){
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    
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
  
}
