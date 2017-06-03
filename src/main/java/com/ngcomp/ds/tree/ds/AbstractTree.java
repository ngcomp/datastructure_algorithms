package com.ngcomp.ds.tree.ds;

/**
 * Created by Ram Parashar on 6/1/17.
 */
public abstract class AbstractTree<E> implements Tree<E> {
  
  @Override
  public boolean isInternal(Position<E> p) {
    return numChildren(p) > 0;
  }
  
  
  @Override
  public boolean isExternal(Position<E> p) {
    return numChildren(p) == 0;
  }
  
  
  @Override
  public boolean isRoot(Position<E> p) {
    return p == root( );
  }
  
  
  @Override
  public boolean isEmpty( ) {
    return size( ) == 0;
  }
  
  /**
   * The depth of p is the number of ancestors of the p, other than p itself.
   * @param p
   * @return
   */
  @Override
  public int depth(Position<E> p) {
    if(isRoot(p)){
      return 0;
    }else{
      return 1 + depth(parent(p));
    }
  }
  
  
  public int height(Position<E> p){
    int h = 0;
    for(Position<E> c : children(p)){
      h = Math.max(1, 1 + height(c));
    }
    return h;
  
  }
  
}