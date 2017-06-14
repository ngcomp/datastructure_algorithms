package com.ngcomp.ds.tree.ds;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TreeNode Insert Order = 52, 33, 25, 39, 12, 27, 34, 48, 65, 60, 78, 72, 90
 * https://www.dropbox.com/s/603oixqgl6jm9ik/Screenshot%202017-06-11%2020.57.01.png?dl=0
 * Created by Ram Parashar on 6/8/17.
 */
public class BST {

  public TreeNode root;

  public TreeNode insert(TreeNode treeNode, Integer data) {

    if (treeNode == null) {
      treeNode = new TreeNode(data);
      return treeNode;
    }

    if (data < treeNode.val) {
      treeNode.left = insert(treeNode.left, data);
    } else {
      treeNode.right = insert(treeNode.right, data);
    }
    return treeNode;
  }


  public TreeNode find(Integer data) {
    return find(this.root, data);
  }

  private TreeNode find(TreeNode treeNode, Integer data) {

    if (treeNode == null) {
      return null;
    }

    if (treeNode.val == data) {
      return root;
    } else if (data < treeNode.val) {
      find(treeNode.left, data);
    } else {
      find(treeNode.right, data);
    }
    return null;
  }


  public Integer smallest() {

    TreeNode treeNode = root;
    while (treeNode.left != null) {
      treeNode = treeNode.left;
    }
    return treeNode.val;
  }


  public Integer largest() {

    TreeNode treeNode = root;
    while (treeNode.right != null) {
      treeNode = treeNode.right;
    }
    return treeNode.val;
  }


  public Integer height() {
    return this.height(this.root);
  }

  private Integer height(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    }
    return 1 + Math.max(height(treeNode.left), height(treeNode.right));
  }


  /**
   * https://www.hackerrank.com/challenges/tree-top-view
   */
  void topView() {
    topView(this.root.left, "left");
    System.out.print(root.val + " ");
    topView(root.right, "right");
  }

  private void topView(TreeNode node, String side){
    if(node == null){
      return;
    }
    if(side.equals("left")) topView(node.left, "left");
    System.out.print(node.val + " ");
    if(side.equals("right")) topView(node.right, "right");
  }


  /**
   * Left => Root => Right
   * @param treeNode
   */
  public void displayInOrder(TreeNode treeNode) {
    if (treeNode == null) {
      return;
    }
    displayInOrder(treeNode.left);
    System.out.print(treeNode.val + " ");
    displayInOrder(treeNode.right);

  }


  //Display PreOrder
  public void displayPreOrder(TreeNode treeNode) {
    if (treeNode == null) {
      return;
    }
    System.out.print(treeNode.val + " ");
    displayPreOrder(treeNode.left);
    displayPreOrder(treeNode.right);
  }

  //Display PostOrder
  public void displayPostOrder(TreeNode treeNode) {
    if (treeNode == null) {
      return;
    }
    System.out.print(treeNode.val + " ");
    displayPostOrder(treeNode.left);
    displayPostOrder(treeNode.right);
  }



  public final int numOfLeafNodes(TreeNode treeNode) {

    if (treeNode.left == null && treeNode.right == null)
      return 1;

    int leftLeaves = 0;
    int rightLeaves = 0;
    if (treeNode.left != null)
      leftLeaves = numOfLeafNodes(treeNode.left);

    if (treeNode.right != null)
      rightLeaves = numOfLeafNodes(treeNode.right);

    return leftLeaves + rightLeaves;

  }


  public List<List<Integer>> binaryTreePaths(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    return binaryTreePaths(this.root, result, path);
  }

  private List<List<Integer>> binaryTreePaths(TreeNode node, List<List<Integer>> result, List<Integer> path) {

    if (node == null)  return result;

    //Leaf Node...
    if (node.left == null && node.right == null) {
      path.add(node.val);
      result.add(path);
    }

    if (node.left != null) {
      List<Integer> newPath = new ArrayList<>(path);
      newPath.add(node.val);
      binaryTreePaths(node.left, result, newPath);
    }

    if (node.right != null) {
      List<Integer> newPath = new ArrayList<>(path);
      newPath.add(node.val);
      binaryTreePaths(node.right, result, newPath);
    }

    return result;
  }


  /**
   * https://leetcode.com/submissions/detail/60394631/
   * @return
   */
  public LinkedList<Integer> serializePreOrder() {
    LinkedList<Integer> serialized = new LinkedList();
    this.serializePreOrder(root, serialized);
    return serialized;
  }

  private void serializePreOrder(TreeNode treeNode, LinkedList<Integer> serialized) {

    if (treeNode == null) {
      serialized.addLast(-1);
    }else{
      serialized.addLast(treeNode.val);
      serializePreOrder(treeNode.left, serialized);
      serializePreOrder(treeNode.right, serialized);
    }
  }



  public TreeNode deserializePreOrder(LinkedList<Integer> serialized) {
    AtomicInteger index = new AtomicInteger(0);
    return deserializePreOrder(serialized, index);

  }

  public TreeNode deserializePreOrder(LinkedList<Integer> serialized, AtomicInteger index) {
    if (index.intValue() >= serialized.size() || serialized.get(index.intValue()) == -1) {
      index.incrementAndGet();
      return null;
    }

    TreeNode root = new TreeNode(serialized.get(index.intValue()));
    index.incrementAndGet();
    root.left = deserializePreOrder(serialized, index);
    root.right = deserializePreOrder(serialized, index);
    return root;
  }


  //Customized to print in new line next level elements.
  public void levelOrderTraversal(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

    if (root == null) {
      return;
    }

    LinkedList<TreeNode> current = new LinkedList<TreeNode>();
    LinkedList<TreeNode> next = new LinkedList<TreeNode>();

    current.addLast(root);

    while (current.size() != 0) {
      TreeNode treeNode = current.poll();
      System.out.print(treeNode.val + " ");
      if (treeNode.left != null) {
        next.addLast(treeNode.left);
      }
      if (treeNode.right != null) {
        next.addLast(treeNode.right);
      }

      if (current.size() == 0) {
        current = next;
        next = new LinkedList();
        System.out.println(" "); //New line for next level
      }
    }
  }

  /**
   * https://www.dropbox.com/s/4qlf6vcxv3a6t62/Screenshot%202017-06-12%2018.48.57.png?dl=0
   * @param root
   */
  public void invert(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    invert(root.left);
    invert(root.right);
  }




  public void insert(Integer data) {
    if (root == null) {
      root = new TreeNode(data);
    } else {
      insert(root, data);
    }
  }


  public static void main(String[] args) {

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

    assert (tree.find(32).val == 32) : "Find function is not correct";

    assert (tree.smallest() == 12) : "Smallest function is not correct";

    assert (tree.largest() == 90) : "Largest function is not correct";

    assert (tree.height() == 3) : "Height function is not correct";

    System.out.println("Topview.....");
    tree.topView();
    System.out.println(System.getProperty("line.separator"));

    System.out.println("InOrder.....");
    tree.displayInOrder(tree.root);
    System.out.println(System.getProperty("line.separator"));

    System.out.println("PreOrder.....");
    tree.displayPreOrder(tree.root);
    System.out.println(System.getProperty("line.separator"));

    System.out.println("PostOrder.....");
    tree.displayPostOrder(tree.root);
    System.out.println(System.getProperty("line.separator"));

    assert (tree.numOfLeafNodes(tree.root) == 7) : "LeafCount function is not correct";

    System.out.println("DFS.....");
    tree.levelOrderTraversal(tree.root);
    System.out.println("");

    System.out.println("BinaryTreePaths.....");
    List<List<Integer>> paths = tree.binaryTreePaths(tree.root);
    for(List<Integer> path : paths){
      for(Integer node : path) {
        System.out.print(node + " ");
      }
      System.out.println(" ");
    }
    System.out.println(System.getProperty("line.separator"));


    LinkedList<Integer> serializedPreOrder = tree.serializePreOrder();
    for(Integer node : serializedPreOrder){
      System.out.print(node + " ");
    }
    System.out.println(System.getProperty("line.separator"));

    TreeNode root = tree.deserializePreOrder(serializedPreOrder);
    tree.displayInOrder(root);
    System.out.println(System.getProperty("line.separator"));

    System.out.println("Invert.....");
    tree.invert(tree.root);
    System.out.println(System.getProperty("line.separator"));

    System.out.println("Topview.....");
    tree.topView();
    System.out.println(System.getProperty("line.separator"));

  }

}

