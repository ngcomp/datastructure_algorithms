package com.ngcomp.ds.tree.algo;


import com.ngcomp.ds.tree.ds.BST;
import com.ngcomp.ds.tree.ds.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants.
 * Created by Ram Parashar on 6/1/17.
 */
public class FirstCommonAncestor {
  

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> pPath = path(root, p);
    List<TreeNode> qPath = path(root, q);

    int min = qPath.size() < pPath.size() ? qPath.size() : pPath.size();

    int counter = 0;
    TreeNode node = root;

    while(counter < min && qPath.get(counter).val == pPath.get(counter).val){
      node = qPath.get(counter);
      counter++;
    }
    return node;
  }

  private static List<TreeNode> path(TreeNode root, TreeNode p){
    List<TreeNode> path = new LinkedList();
    TreeNode node = root;
    while(node!= null){
      path.add(node);
      if(p.val < node.val){
        node = node.left;
      }else if(p.val > node.val){
        node = node.right;
      }else{
        break;
      }
    }
    return path;
  }

  public static void main(String...strings){
    BST tree = new BST();
    tree.insert(52);
    tree.insert(33);
    tree.insert(25);
    tree.insert(39);
    tree.insert(12);
    tree.insert(27);
    tree.insert(34);
    tree.insert(48);
    tree.insert(65);
    tree.insert(60);
    tree.insert(78);
    tree.insert(72);
    tree.insert(90);

    TreeNode p = new TreeNode(33);
    TreeNode q = new TreeNode(65);

    System.out.println(lowestCommonAncestor(tree.root, p , q).val);
  }
}

