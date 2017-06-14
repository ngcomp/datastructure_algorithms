package com.ngcomp.ds.tree.ds.java;

/**
 * Created by Ram Parashar on 6/1/17.
 */
public interface Tree<E>{
  
  Position<E> root();
  
  Position<E> parent(Position<E> p) throws IllegalArgumentException;
  
  Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
  
  int numChildren(Position<E> p) throws IllegalArgumentException;
  
  boolean isInternal(Position<E> p) throws IllegalArgumentException;
  
  boolean isExternal(Position<E> p) throws IllegalArgumentException;
  
  boolean isRoot(Position<E> p) throws IllegalArgumentException;
  
  int size();
  
  boolean isEmpty();
  
//  Iterator<E> iterator();
//
//  Iterable<Position<E>> positions();
  
  int depth(Position<E> p);
}
