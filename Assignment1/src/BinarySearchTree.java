public class BinarySearchTree extends BinaryTree{

  private BinaryTreePrint print;
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


  public void rebalance(){

  }
  public boolean isBalanced(int maxDiff){
    return isBalanced(getRoot(),maxDiff);
  }
  public boolean isBalanced(BinaryTreeNode node, int maxDiff){
    if(node==null) return true;
    if(node.getRightChild()==null&&node.getLeftChild()==null) return true;
    else{
      int relativeDiff = height(node.getRightChild())-height(node.getLeftChild());
//      System.out.println("Relative diff at "+node.getElement() +" is " + relativeDiff);
      int currentDiff =Math.abs(relativeDiff);
//      System.out.println("Absolute diff is :" +currentDiff );
      boolean returned = (currentDiff<=maxDiff)&&isBalanced(node.getLeftChild(),maxDiff)&& isBalanced(node.getRightChild(),maxDiff);
//      if(!returned)
//        System.out.println(node.getElement()+" is unbalanced");
//      else
//        System.out.println(node.getElement()+" is balanced");

      return returned;
    }
  }

  public BinaryTreeNode getUnbalancedNode(int maxDiff){
    return getUnbalancedNode(getRoot(),maxDiff);
  }
  public BinaryTreeNode getUnbalancedNode(BinaryTreeNode node, int maxDiff){
    if(node==null) return null;
    if(node.getRightChild()==null&&node.getLeftChild()==null) return null;
    else{
      int relativeDiff = height(node.getRightChild())-height(node.getLeftChild());
      int currentDiff =Math.abs(relativeDiff);
      if(!isBalanced(node.getLeftChild(),maxDiff)){
        return node.getLeftChild();
      }
      if(!isBalanced(node.getRightChild(),maxDiff)){
        return node.getLeftChild();
      }
      if(!(currentDiff<=maxDiff)){
        return node;
      }
      return null;
    }
  }
}
