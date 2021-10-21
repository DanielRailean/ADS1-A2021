public class BinarySearchTree extends BinaryTree{

  private BinaryTreePrint print = new BinaryTreePrint();
  public BinarySearchTree()
  {
    super();
  }

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

  public int findMax(){
    if(findMaxElement(getRoot())!=null)
    return findMaxElement(getRoot()).getElement();
    else return Integer.MIN_VALUE;
  }
  public BinaryTreeNode findMaxElement(BinaryTreeNode root){
    int max = Integer.MIN_VALUE;
    return findMax(root,max);
  };
  private BinaryTreeNode findMax(BinaryTreeNode node,int currentMax){
    if(node==null){
        return null;
    }
    if(node.getElement()>currentMax&&node.getRightChild()!=null){
      node = findMax(node.getRightChild(),node.getElement());
    }
    return node;
  }

  public int findMin(){
    if(findMinElement(getRoot())!=null)
      return findMinElement(getRoot()).getElement();
    else return Integer.MAX_VALUE;
  };

  public BinaryTreeNode findMinElement(BinaryTreeNode root){
    int max = Integer.MAX_VALUE;
    return findMin(root,max);
  }
  public BinaryTreeNode findMin(BinaryTreeNode node, int currentMin){
    if(node==null){
      return null;
    }
    if(node.getElement()<currentMin&&node.getLeftChild()!=null){
      node = findMin(node.getLeftChild(),node.getElement());
    }
    return node;
  }

  public boolean isSubtreeLesser(BinaryTreeNode node, int value){
    if(node==null) return true;
    return isSubtreeLesser(node.getLeftChild(),value)&&
            isSubtreeLesser(node.getRightChild(),value);
  };
  public boolean isSubtreeGreater(BinaryTreeNode node, int value){
    if(node==null) return true;
    return isSubtreeGreater(node.getLeftChild(),value)&&
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


  public void rebalance(){
//    while(!isBalanced(1)){
//      for(int i=0;i<height();i++){
//        if(!isBalanced(1))
          setRoot(rebalance(1,getRoot()));
//        System.out.println(i);
//      }
//    }
  }
  public BinaryTreeNode rebalance(int maxDiff, BinaryTreeNode node){
    if (node==null) return node;
    if(node.getLeftChild()==null&&node.getRightChild()==null) return node;
    else{
      int leftH = height(node.getLeftChild());
      int rightH = height(node.getRightChild());
      int relativeDiff = leftH-rightH;
      int currentDiff =Math.abs(relativeDiff);
      if(currentDiff>maxDiff){
        if(node.getRightChild()==null){
          node= rotateLeft(rotateRight(node));
        }else if(node.getLeftChild()==null){
          node = rotateRight(rotateLeft(node));
        }else{
          // tree is left heavy
          if(relativeDiff>0){
            node = rotateRight(node);
          }
          //tree is right heavy
          else{
            node = rotateLeft(node);
          }
        }

      }
      node.addLeftChild(rebalance(maxDiff,node.getLeftChild()));
      node.addRightChild(rebalance(maxDiff,node.getRightChild()));
      return node;
    }
}

//  public boolean isBalanced(BinaryTreeNode node, int maxDiff){
//    if(node==null) return true;
//    if(node.getRightChild()==null&&node.getLeftChild()==null) return true;
//    else{
//      int relativeDiff = height(node.getRightChild())-height(node.getLeftChild());
////      System.out.println("Relative diff at "+node.getElement() +" is " + relativeDiff);
//      int currentDiff =Math.abs(relativeDiff);
////      System.out.println("Absolute diff is :" +currentDiff );
//      boolean returned = (currentDiff<=maxDiff)&&isBalanced(node.getLeftChild(),maxDiff)&& isBalanced(node.getRightChild(),maxDiff);
////      if(!returned)
////        System.out.println(node.getElement()+" is unbalanced");
////      else
////        System.out.println(node.getElement()+" is balanced");
//
//      return returned;
//    }
//  }
//
  public int isBalanced(BinaryTreeNode node, int maxDiff){
    if(node==null) return -1;
    if(node.getLeftChild()==null&&node.getRightChild()==null) return -1;
    else{
      int leftH = height(node.getLeftChild());
      int rightH = height(node.getRightChild());
      int relativeDiffL = leftH-rightH;
      int relativeDiffR = rightH-leftH;
      int relativeDiff = Math.min(relativeDiffL,relativeDiffR);
      int currentDiff =Math.abs(relativeDiff);
      //System.out.println("Relative diff at "+node.getElement() +" is " + relativeDiff);
//      System.out.println("Absolute diff is :" +currentDiff );
      if(currentDiff>maxDiff){
        // tree is left heavy
        return relativeDiff;
      }
      int leftB = isBalanced(node.getLeftChild(),maxDiff);
      int rightB = isBalanced(node.getRightChild(),maxDiff);
      return Math.min(leftB,rightB);
    }
  }
  public BinaryTreeNode rotateRight(BinaryTreeNode node){
    if (node == null) return null;
    if(node.getLeftChild()==null) return node;
    BinaryTreeNode left = node.getLeftChild();
    BinaryTreeNode temp = left.getRightChild();
    node.addLeftChild(temp);
    left.addRightChild(node);
    return left;
  }

  public BinaryTreeNode rotateLeft(BinaryTreeNode node){
    if (node == null) return null;
    if(node.getRightChild()==null) return node;
    BinaryTreeNode right = node.getRightChild();
    BinaryTreeNode temp = right.getLeftChild();
    node.addRightChild(temp);
    right.addLeftChild(node);
    return right;
  }


  public boolean isBalanced(int maxDiff){
    int balance = isBalanced(getRoot(),maxDiff);
    return Math.abs(balance)<=maxDiff;
//    return isBalanced(getRoot(),maxDiff);
  }


}
