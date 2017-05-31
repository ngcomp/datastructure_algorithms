package com.ngcomp.ds.linked_list.ds;

import java.util.NoSuchElementException;

/**
 * Created by Ram Parashar on 5/25/17.
 */
public class DoublyLinkedList<Item> {
  
  private int size;
  
  class Node {
    Item item;
    Node previous;
    Node next;
    public Node(Item item, Node next, Node previous) {
      this.next = next;
      
      this.item = item;
      this.previous = previous;
    }
  }
  
  private Node head;
  private Node tail;
  
  public DoublyLinkedList(){
    this.head = null;
    this.tail = null;
  }
  
  public int size(){
    return size;
  }
  
  public boolean isEmpty(){
    return size == 0;
  }
  
  public void addFirst(Item item){
  
    Node node = new Node(item, head, null);
    
    if(head != null) {
      head.previous = node;
    }
    head = node;
    if(tail == null) {
      tail = node;
    }
    size++;
  }
  
  
  public Item removeFirst(){
    if(size == 0){
      throw new NoSuchElementException();
    }
    Node node = head;
    head = head.next;
    head.previous = null;
    size--;
    
    return node.item;
  }
  
  
  public void addLast(Item item){
    Node node = new Node(item, null, tail);
    if(tail!= null){
      tail.next = node;
    }
    tail = node;
    
    if(head == null){
      head = node;
    }
    size++;
  }
  
  
  public Item removeLast(){
    if(size == 0){
      throw new NoSuchElementException();
    }
    Node node = tail;
    tail = tail.previous;
    tail.next = null;
    size--;
    
    //Making easy for JVM
    node.previous = null;
    return node.item;
  }
  
  
  public void print(){
    Node current = head;
    System.out.println("-------------------------");
    while(current!= null){
      System.out.format("%s  ", current.item);
      current = current.next;
    }
  }
  
  
  public static void main(String...strings){
    DoublyLinkedList<Integer> list = new DoublyLinkedList();
    list.addFirst(1);
    list.addFirst(2);
    list.addFirst(3);
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    
    list.print();
    
  }
  
}
