public class BinarySearchTreeNode<E extends Comparable<E>> extends BinaryTreeNode<E>
{

  private BinarySearchTreeNode<E> leftChild;
  private BinarySearchTreeNode<E> rightChild;
  public BinarySearchTreeNode(E element)
  {
    super(element);
  }

  @Override public BinarySearchTreeNode<E> getLeftChild()
  {
    return leftChild;
  }

   public void addLeftChild(BinarySearchTreeNode<E> leftChild)
  {
    this.leftChild = leftChild;
  }

  @Override public BinarySearchTreeNode<E> getRightChild()
  {
    return rightChild;
  }

   public void addRightChild(BinarySearchTreeNode<E> rightChild)
  {
    this.rightChild = rightChild;
  }
}
