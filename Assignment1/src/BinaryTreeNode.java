public class  BinaryTreeNode<T> {

    private T element;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode(T data) {
        element = data;
        leftChild = null;
        rightChild = null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
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
