import java.util.Objects;

public class  BinaryTreeNode {

    private int element;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode(int data) {
        element = data;
        leftChild = null;
        rightChild = null;
    }

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
