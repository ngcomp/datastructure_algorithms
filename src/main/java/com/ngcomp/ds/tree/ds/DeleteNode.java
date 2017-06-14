package com.ngcomp.ds.tree.ds;

/**
 * Delete is a complex process and that's why people prefer to mark node as deleted and batch clear operation.
 * Created by Ram Parashar on 6/3/17.
 */
public class DeleteNode {

  public boolean delete(TreeNode root, int key) {
    TreeNode current = root;
    TreeNode parent = root;
    boolean isLeftChild = true;

    while (current.val != key) {
      parent = current;

      if (key < current.val) {
        isLeftChild = true;
        current = current.left;
      } else {
        isLeftChild = true;
        current = current.right;
      }
    }

    //No Children simply delete it.
    if (current.left == null && current.right == null) {
      if (current == null) {
        root = null;
      } else if (isLeftChild) {
        root.left = null;
      } else {
        root.right = null;
      }
    }
    //If there is one children only.
    else if (current.right == null) { //no right then replace with left subtree
      if (current == null)
        root = current.left;
      else if (isLeftChild)
        parent.left = current.left;
      else
        parent.right = current.left;
    }
    else if (current.left == null) {
      if (current == null)
        root = current.right;
      else if (isLeftChild)
        parent.left = current.right;
      else
        parent.right = current.right;
    }
    else {//There are two children
      TreeNode successor = getSuccessor(current);
      if (current == root)
        root = successor;
      else if (isLeftChild)
        parent.left = successor;
      else
        parent.right = successor;

      successor.left = current.left;

    }
    return true;
  }


  public static TreeNode getSuccessor(TreeNode treeNode){
    TreeNode successorParent = treeNode;
    TreeNode successor = treeNode;
    TreeNode current = treeNode.right;
    while(current!= null){
      successorParent = successor;
      successor = current;
      current = current.left;
    }
    if(successor!= treeNode.right){
      successorParent.left = successor.right;
      successor.right = treeNode.right;
    }
    return successor;
  }

}