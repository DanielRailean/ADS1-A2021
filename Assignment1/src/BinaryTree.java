import java.util.ArrayList;

public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }
    public boolean isEmpty(){
        return true;
    }

    public int size(){
        return 0;
    }

    public boolean contains(E element){
        return true;
    }

    ArrayList inOrder(){
        return new ArrayList();
    }
    ArrayList preOrder(){
        return new ArrayList();

    }
    ArrayList postOrder(){
        return new ArrayList();

    }
    ArrayList levelOrder(){
        return new ArrayList();

    }
    public int height(){
        if (root == null) return -1;
        return 0;
    }
}
