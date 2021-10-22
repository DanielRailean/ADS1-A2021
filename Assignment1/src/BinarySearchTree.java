public class BinarySearchTree extends BinaryTree{

  private BinaryTreePrint print = new BinaryTreePrint();
  public BinarySearchTree()
  {
    super();
  }

  // calling the recursive brother passing the root
  public void insert(int element){
    setRoot(insert(element,getRoot()));;
  };
  private BinaryTreeNode insert(int element, BinaryTreeNode node){
    if(node==null){
      return new BinaryTreeNode(element);
    }
    if(node.getElement()>element){
       node.addLeftChild(insert(element,node.getLeftChild()));
    }else if(node.getElement()<element){
      node.addRightChild(insert(element,node.getRightChild()));
    }
    return node;
  }

  // calling the recursive brother passing the root
  public void removeElement(int element){
      setRoot(delete(element,getRoot()));
  };
  private BinaryTreeNode delete(int element, BinaryTreeNode node){
      if(node==null){
        return null;
      }
      if(node.getElement()>element){
        node.addLeftChild(delete(element,node.getLeftChild()));
      }else if(node.getElement()<element){
        node.addRightChild(delete(element,node.getRightChild()));
      }
      else{
        if(node.getRightChild()==null &&node.getLeftChild()==null)
          return null;

        else if(node.getLeftChild()==null){
          return node.getRightChild();
        }
        else if(node.getRightChild()==null){
          return node.getLeftChild();
        }
        else{
          int min = findMinElement(node.getRightChild()).getElement();
          node.setElement(min);
          node.addRightChild(delete(min,node.getRightChild()));
        }
      }
    return node;
  }
  // calling the recursive brother passing the root and returning its node value.
  public int findMax(){
    if(findMaxElement(getRoot())!=null)
    return findMaxElement(getRoot()).getElement();
    else return Integer.MIN_VALUE;
  }
  // calling the recursive brother passing the root and min possible value for integer
  public BinaryTreeNode findMaxElement(BinaryTreeNode root){
    int max = Integer.MIN_VALUE;
    return findMax(root,max);
  };
  private BinaryTreeNode findMax(BinaryTreeNode node,int currentMax){
    // if called for a leaf child
    if(node==null){
        return null;
    }
    // else if searched is smaller than the current and there is a right node, try to find bigger number in the right than the current node value
    // other implementation might be going to the right until the right is null , then returning the value.
    if(node.getElement()>currentMax&&node.getRightChild()!=null){
      node = findMax(node.getRightChild(),node.getElement());
    }
    // if we are here than we are at the biggest node in the tree.
    return node;
  }

  // calling the recursive brother passing the root and returning its node value.
  public int findMin(){
    if(findMinElement(getRoot())!=null)
      return findMinElement(getRoot()).getElement();
    else return Integer.MAX_VALUE;
  };

  // calling the recursive brother passing the root and min possible value for integer
  public BinaryTreeNode findMinElement(BinaryTreeNode root){
    int max = Integer.MAX_VALUE;
    return findMin(root,max);
  }
  public BinaryTreeNode findMin(BinaryTreeNode node, int currentMin){
    // if called for a leaf child
    if(node==null){
      return null;
    }
    // else if searched is bigger than the current and there is a left node, try to find a smaller than this number in the left.
    if(node.getElement()<currentMin&&node.getLeftChild()!=null){
      node = findMin(node.getLeftChild(),node.getElement());
    }
    // if we are here than we are at the smallest node in the tree.
    return node;
  }

  // method used to check if all the values in a tree are smaller than a given value.
  public boolean isSubtreeLesser(BinaryTreeNode node, int value){
    if(node==null) return true;
    return  node.getElement()<value&&
            isSubtreeLesser(node.getLeftChild(),value)&&
            isSubtreeLesser(node.getRightChild(),value);
  };
  public boolean isSubtreeGreater(BinaryTreeNode node, int value){
    if(node==null) return true;
    return  node.getElement()>value&&
            isSubtreeGreater(node.getLeftChild(),value)&&
            isSubtreeGreater(node.getRightChild(),value);
  };
  public boolean isBinarySearch(){
    return isBinarySearch(getRoot());
  }
  public boolean isBinarySearch(BinaryTreeNode node){
    if(node==null) return true;
    return isSubtreeLesser(node.getLeftChild(),node.getElement())&&
            isSubtreeGreater(node.getRightChild(),node.getElement())&&
            isBinarySearch(node.getLeftChild())&&
            isBinarySearch(node.getRightChild());
  }

// if not ballanced call the recursive brother.
  public void rebalance(){

        if(!isBalanced(1))
          setRoot(rebalance(1,getRoot()));

  }
  // accepts a root and a max difference between heights
  public BinaryTreeNode rebalance(int maxDiff, BinaryTreeNode node){
    // nothing to balance
    if (node==null) return node;
    // is a leaf
    if(node.getLeftChild()==null&&node.getRightChild()==null) return node;
      // not a leaf
    else{
      node.addLeftChild(rebalance(maxDiff,node.getLeftChild()));
      node.addRightChild(rebalance(maxDiff,node.getRightChild()));
      //calculate height relative and total diff.
      // call self for children;
      int leftH = height(node.getLeftChild());
      int rightH = height(node.getRightChild());
      int relativeDiff = leftH-rightH;
      int currentDiff =Math.abs(relativeDiff);

      // broke the limit
      if(currentDiff>maxDiff){
        // one of the children is null =>
        // if right is null rotate left the child then rotate right self
        if(node.getRightChild()==null||(leftH==2&&rightH==0)){
          node.addLeftChild(rotateLeft(node.getLeftChild()));
          node = rotateRight(node);
        }
        // if left is null rotate left the child then rotate left self
        else if(node.getLeftChild()==null||(rightH==2&&leftH==0)){
          node.addRightChild(rotateRight(node.getRightChild()));
          node = rotateLeft(node);

        }else{
          // tree is left heavy, rotate right
          if(relativeDiff>0){
            node = rotateRight(node);
          }
          //tree is right heavy, rotate left
          else{
            node = rotateLeft(node);
          }
        }
      }
      // return already balanced node.
      return node;
    }
}

  public boolean isBalanced(int maxDiff){
//    int balance = isBalanced(getRoot(),maxDiff);
//    return Math.abs(balance)<=maxDiff;
    return isBalanced(getRoot(),maxDiff);
  }
// an implementation of is balanced that returns boolean and not the balance value.
  public boolean isBalanced(BinaryTreeNode node, int maxDiff){
    if(node==null) return true;
    if(node.getRightChild()==null&&node.getLeftChild()==null) return true;
    else{
      int relativeDiff = height(node.getRightChild())-height(node.getLeftChild());

      int currentDiff =Math.abs(relativeDiff);

      boolean returned = (currentDiff<=maxDiff)&&isBalanced(node.getLeftChild(),maxDiff)&& isBalanced(node.getRightChild(),maxDiff);


      return returned;
    }
  }

  // right rotation.
  public BinaryTreeNode rotateRight(BinaryTreeNode node){
    if (node == null) return null;
    if(node.getLeftChild()==null) return node;
    BinaryTreeNode left = node.getLeftChild();
    BinaryTreeNode temp = left.getRightChild();
    node.addLeftChild(temp);
    left.addRightChild(node);
    return left;
  }

  // left rotation
  public BinaryTreeNode rotateLeft(BinaryTreeNode node){
    if (node == null) return null;
    if(node.getRightChild()==null) return node;
    BinaryTreeNode right = node.getRightChild();
    BinaryTreeNode temp = right.getLeftChild();
    node.addRightChild(temp);
    right.addLeftChild(node);
    return right;
  }




}
