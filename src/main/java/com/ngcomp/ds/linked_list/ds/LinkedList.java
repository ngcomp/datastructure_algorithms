package com.ngcomp.ds.linked_list.ds;

/**
 * Duplicates are allowed.
 * Created by Ram Parashar on 5/25/17.
 */
public class LinkedList<Item>{
  
  private Node<Item> head;
  
  
  private static class Node<Item>{
    Item val;
    private Node next;
    public Node(Item val){
      this.val = val;
    }
  }
  
  
  public LinkedList(){
    this.head = null;
  }
  
  
  public void addFirst(Node<Item> node){
    if(head == null){
      head = node;
    }else{
      node.next = head;
      head = node;
    }
  }
  
  
  public void removeFirst(){
    if(head != null){
      head = head.next;
    }
  }

  
  public void addLast(Node<Item> node){
    
    if(head == null){
      head = node;
    }else{
      Node current = head;
      while(current.next!= null){
        current = current.next;
      }
      current.next = node;
    }
  }
  
  
  public void removeLast(){
    
    if(head == null){
      return;
    }
    
    Node prev = head;
    Node current = head.next;
    
    //Element is in the middle.
    while(current.next!= null){
      prev = current;
      current = current.next;
    }
    prev.next = null;
  }
  
  
  public void insertAfter(int index, Node<Item> node){
    
    if(head == null){
      throw new NullPointerException();
    }else {
      Node current = head; int pos = 0;
      while(pos++ < index){
        current = current.next;
        if(current == null){
          throw new IndexOutOfBoundsException();
        }
      }
      node.next = current.next;
      current.next = node;
    }
    
  }
  
  
  
  public void remove(Item val){
    
    if(head == null){
      return;
    }
    
    //Head contains the value
    if(head.val == val){
      head = head.next;
    }
    
    Node prev = head;
    Node current = head.next;
    
    //Element is in the middle.
    while(current!= null){
      if(current.val.equals(val)){
        prev.next = current.next;
      }
      prev = current;
      current = current.next;
    }
  }
  
  
  public void print(){
    System.out.println("----------------------");
    Node tmp = head;
    while(tmp != null){
      System.out.println(tmp.val);
      tmp = tmp.next;
    }
  }
  
  
  public static void main(String...strings){
    LinkedList<Integer> intList = new LinkedList<Integer>();
    intList.addLast(new Node(1));
    intList.addLast(new Node(2));
    intList.addLast(new Node(3));
  
    intList.print();
  
    LinkedList<String> stringList = new LinkedList<String>();
    stringList.addLast(new Node("Hello"));
    stringList.addLast(new Node("Welcome"));
    stringList.addLast(new Node("World"));
    stringList.remove("Welcome");
    stringList.print();
  }
  
}
