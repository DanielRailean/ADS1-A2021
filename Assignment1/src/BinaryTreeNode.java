public class BinaryTreeNode {

    private E element;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode(E element) {
        this.element = element;
        leftChild = null;
        rightChild = null;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
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
}
