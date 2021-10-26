import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E>{

  public BinarySearchTree()
  {
    super();
  }

  // calling the recursive brother passing the root
  public void insert(E element){
    setRoot(insert(element,getRoot()));
  };
  private BinaryTreeNode<E> insert(E element, BinaryTreeNode<E> node){
    if(node==null){
      return new BinaryTreeNode<E>(element);
    }
    if(node.getElement().compareTo(element)==1){
       node.addLeftChild(insert(element,node.getLeftChild()));
    }else if(node.getElement().compareTo(element)==-1){
      node.addRightChild(insert(element,node.getRightChild()));
    }
    return node;
  }

  // calling the recursive brother passing the root
  public void removeElement(E element){
      setRoot(delete(element,getRoot()));
  };
  private BinaryTreeNode<E> delete(E element, BinaryTreeNode<E> node){
      if(node==null){
        return null;
      }
      if(node.getElement().compareTo(element)==1){
        node.addLeftChild(delete(element,node.getLeftChild()));
      }else if(node.getElement().compareTo(element)==-1){
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
          E min = (E) findMinElement(node.getRightChild()).getElement();
          node.setElement(min);
          node.addRightChild(delete(min,node.getRightChild()));
        }
      }
    return node;
  }
  // calling the recursive brother passing the root and returning its node value.
  public E findMax(){
    return findMaxElement(getRoot()).getElement();
  }
  // calling the recursive brother passing the root and min possible value for Eeger
  public BinaryTreeNode<E> findMaxElement(BinaryTreeNode<E> root){
    return findMax(root,root.getElement());
  };
  private BinaryTreeNode<E> findMax(BinaryTreeNode<E> node,E currentMax){
    // if called for a leaf child
    if(node==null){
        return null;
    }
    // else if searched is smaller than the current and there is a right node, try to find bigger number in the right than the current node value
    // other implementation might be going to the right until the right is null , then returning the value.
    if(node.getElement().compareTo(currentMax) >= 0 &&node.getRightChild()!=null){
      node = findMax(node.getRightChild(), (E) node.getElement());
    }
    // if we are here than we are at the biggest node in the tree.
    return node;
  }

  // calling the recursive brother passing the root and returning its node value.
  public E findMin(){
      return findMinElement(getRoot()).getElement();
  };

  // calling the recursive brother passing the root and min possible value for Eeger
  public BinaryTreeNode<E> findMinElement(BinaryTreeNode<E> root){
    return findMin(root,root.getElement());
  }
  public BinaryTreeNode<E> findMin(BinaryTreeNode<E> node, E currentMin){
    // if called for a leaf child
    if(node==null){
      return null;
    }
    // else if searched is bigger than the current and there is a left node, try to find a smaller than this number in the left.
    if(node.getElement().compareTo(currentMin) <= 0 &&node.getLeftChild()!=null){
      node = findMin(node.getLeftChild(),node.getElement());
    }
    // if we are here than we are at the smallest node in the tree.
    return node;
  }

  // method used to check if all the values in a tree are smaller than a given value.
  public boolean isSubtreeLesser(BinaryTreeNode<E> node, E value){
    if(node==null) return true;
    return  node.getElement().compareTo(value)<0&&
            isSubtreeLesser(node.getLeftChild(),value)&&
            isSubtreeLesser(node.getRightChild(),value);
  };
  public boolean isSubtreeGreater(BinaryTreeNode<E> node, E value){
    if(node==null) return true;
    return  node.getElement().compareTo(value)>0&&
            isSubtreeGreater(node.getLeftChild(),value)&&
            isSubtreeGreater(node.getRightChild(),value);
  };
  public boolean isBinarySearch(){
    return isBinarySearch(getRoot());
  }
  public boolean isBinarySearch(BinaryTreeNode<E> node){
    if(node==null) return true;
    return isSubtreeLesser(node.getLeftChild(), (E) node.getElement())&&
            isSubtreeGreater(node.getRightChild(), (E) node.getElement())&&
            isBinarySearch(node.getLeftChild())&&
            isBinarySearch(node.getRightChild());
  }

// if not ballanced call the recursive brother.
  public void rebalance(){
    ArrayList<E> inOrder = inOrder();
    setRoot(calcRoot(inOrder()));
  }
  // accepts a root and a max difference between heights
  private BinaryTreeNode<E> calcRoot(List<E> list){
    if(list.size()==0){
      return null;
    }
    if(list.size()==1){
      return new BinaryTreeNode<E>(list.get(0));
    }
    if(list.size()==4){
      BinaryTreeNode<E> returned = new BinaryTreeNode<E>(list.get(2));
      BinaryTreeNode<E> left = new BinaryTreeNode<E>(list.get(1));
      left.addLeftChild(new BinaryTreeNode<E>(list.get(0)));
      returned.addLeftChild(left);
      returned.addRightChild(new BinaryTreeNode<E>(list.get(3)));
      return returned;
    }
    int current = (list.size())/2;
    BinaryTreeNode<E> head = new BinaryTreeNode<E>(list.get(current));
    List<E> left = list.subList(0,current);
    List<E> right = list.subList(current+1,list.size());
    head.addLeftChild(calcRoot(left));
    head.addRightChild(calcRoot(right));
    return head;
  }


  public boolean isBalanced(int maxDiff){
//    E balance = isBalanced(getRoot(),maxDiff);
//    return Math.abs(balance)<=maxDiff;
    return isBalanced(getRoot(),maxDiff);
  }
// an implementation of is balanced that returns boolean and not the balance value.
  public boolean isBalanced(BinaryTreeNode<E> node, int maxDiff){
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
  public BinaryTreeNode<E> rotateRight(BinaryTreeNode<E> node){
    if (node == null) return null;
    if(node.getLeftChild()==null) return node;
    BinaryTreeNode<E> left = node.getLeftChild();
    BinaryTreeNode<E> temp = left.getRightChild();
    node.addLeftChild(temp);
    left.addRightChild(node);
    return left;
  }

  // left rotation
  public BinaryTreeNode<E> rotateLeft(BinaryTreeNode<E> node){
    if (node == null) return null;
    if(node.getRightChild()==null) return node;
    BinaryTreeNode<E> right = node.getRightChild();
    BinaryTreeNode<E> temp = right.getLeftChild();
    node.addRightChild(temp);
    right.addLeftChild(node);
    return right;
  }




}
