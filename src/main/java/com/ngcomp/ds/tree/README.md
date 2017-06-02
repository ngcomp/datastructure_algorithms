## Trees

* Each tree has a root. 
* Each root node has one or more child. 
* Each child node has one or more child nodes, and so on.

#### Class Representation

```
class Node {
  public String name; 
  public Node[] children;
}
```

#### Types 
*Binary Trees* = Each node has upto two childrens.

*Binary Search Tree* = Binary tree with all left decendents <= n < right descendents.

*Balanced Trees* = AVL and red-black 

*Complete Binary Trees* = Every level of tree is fully filled, except for perhaps for the last level. Last level is always filled from left to right. 

