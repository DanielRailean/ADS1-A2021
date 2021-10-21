import java.util.Objects;

public class  BinaryTreeNode {

    // element contains a value , may be switched with a Generic that implements the comparable interface.
    // also contains reference to left and right child.
    private int element;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    // create a leaf node.
    public BinaryTreeNode(int data) {
        element = data;
        leftChild = null;
        rightChild = null;
    }

    // getters and setters
    public int getElement()
    {
        return element;
    }

    public void setElement(int element)
    {
        this.element = element;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void addLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void addRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override public boolean equals(Object o)
    {
        if (this == o)
            return true;
        return false;
    }

    @Override public int hashCode()
    {
        return Objects.hash(element, leftChild, rightChild);
    }
}
