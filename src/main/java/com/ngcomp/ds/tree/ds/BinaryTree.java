package com.ngcomp.ds.tree.ds;

/**
 * Created by Ram Parashar on 6/2/17.
 */
public interface BinaryTree<E> extends Tree<E>{
  
  Position<E> left(Position<E> p) throws IllegalArgumentException;
  
  Position<E> right(Position<E> p) throws IllegalArgumentException;
  
  Position<E> sibling(Position<E> p) throws IllegalArgumentException;

}
