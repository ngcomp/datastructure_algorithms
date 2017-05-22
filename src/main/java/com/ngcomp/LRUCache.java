package com.ngcomp;

import java.util.HashMap;

/**
 * Created by Ram Parashar on 5/21/17.
 */

public class LRUCache {

    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }


    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.val;
        }

        return -1;
    }


    public void remove(Node n){
        if(n.pre!=null){ //Not an head element
            n.pre.next = n.next;
        }else{
            head = n.next;
        }

        if(n.next!=null){ //Not a tail element
            n.next.pre = n.pre;
        }else{
            tail = n.pre;
        }

    }


    public void setHead(Node n){
        n.next = head;
        n.pre = null;

        if(head!=null)
            head.pre = n;

        head = n;

        if(tail ==null)
            tail = head;
    }


    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.val = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(tail.key);
                remove(tail);
                setHead(created);

            }else{
                setHead(created);
            }

            map.put(key, created);
        }
    }


    private void print(){
        Node node = head;
        while(node!=null){
            System.out.println(node.key + " " + node.val);
            node = node.next;
        }
        System.out.println("================");
    }


    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.set(2,1);
        lru.set(1,1);
        System.out.println(lru.get(2));
        lru.set(4,1);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));

    }
}

class Node{
    int key;
    int val;
    Node pre;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}