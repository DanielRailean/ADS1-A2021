import java.util.Objects;

public class  BinaryTreeNode<E>{

    // element contains a value , may be switched with a Generic that implements the comparable interface.
    // also contains reference to left and right child.
    private E element;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;

    // create a leaf node.
    public BinaryTreeNode(E element) {
        this.element = element;
        leftChild = null;
        rightChild = null;
    }

    // getters and setters
    public E getElement()
    {
        return element;
    }

    public void setElement(E element)
    {
        this.element = element;
    }

    public BinaryTreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void addLeftChild(BinaryTreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<E> getRightChild() {
        return rightChild;
    }

    public void addRightChild(BinaryTreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }

}
