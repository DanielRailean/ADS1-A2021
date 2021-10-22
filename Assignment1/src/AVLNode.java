public class AVLNode {
    private int data;
    private int height;
    private int balance;
    private AVLNode leftChild;
    private AVLNode rightChild;

    public AVLNode(int data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public AVLNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AVLNode leftChild) {
        this.leftChild = leftChild;
    }

    public AVLNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(AVLNode rightChild) {
        this.rightChild = rightChild;
    }
}
