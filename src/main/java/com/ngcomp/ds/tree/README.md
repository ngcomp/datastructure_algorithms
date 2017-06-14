## Trees

* Each tree has a root that has no parent. 
* Each root treeNode has one or more child. 
* Each child treeNode has one or more child nodes, and so on.

**Edge** pair of nodes (u,v) such that u is the parent of v, or vice versa. 

**Path** Sequence of nodes such that two consecutive nodes in the sequence form an edge.


#### Class Representation

```
class Node {
  public int val; 
  public Node[] children;
}
```

#### Tree Types 

**Binary Tree** = Each treeNode has upto two childrens.

**Binary Search Tree** = Binary tree with all left decendents <= n < right descendents.

**Balanced Trees** = AVL and red-black 

**Complete Binary Trees** = Every level of tree is fully filled, except for perhaps for the last level. Last level is always filled from left to right. 

**Fully Binary Tree** = Binary tree where each treeNode has zero or two child nodes. 

**Perfect Binary Tree** = Tree which is both full and complete. All leaf nodes will be at the same level.

#### Tree Traversal

** Preorder **

```
public void preOrderTraversal(Node treeNode){
  if(treeNode != null){
    System.out.println(treeNode.val);
    preOrderTraversal(treeNode.left);
    preOrderTraversal(treeNode.right);
  }
}
```

** Inorder **

```
public void preOrderTraversal(Node treeNode){
  if(treeNode != null){
    preOrderTraversal(treeNode.left);
    System.out.println(treeNode.val);
    preOrderTraversal(treeNode.right);
  }
}
```

** Postorder **

```
public void preOrderTraversal(Node treeNode){
  if(treeNode != null){
    preOrderTraversal(treeNode.left);
    preOrderTraversal(treeNode.right);
    System.out.println(treeNode.val);    
  }
}
```

#### Representation

* Using Connected Nodes
* Using Array ( 2n+1 = left, 2n+1 = right, (n - 1) / 2 = root)
