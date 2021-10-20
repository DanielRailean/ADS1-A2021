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
        return getRoot()==null;
    }

    public int size(){
        return size(getRoot()) ;
    }

    private int size(BinaryTreeNode node){
        if(node==null) return 0;
        else return 1+size(node.getRightChild())+size(node.getLeftChild());
    }

    public boolean contains(int element){
        return contains(getRoot(),element);
    }
    private boolean contains(BinaryTreeNode node, int element){
        if(node==null) return false;
        if(node.getElement()==element) return true;
        else return contains(node.getLeftChild(),element)||contains(node.getRightChild(),element);

    }

    public ArrayList inOrder(){
        ArrayList list = new ArrayList<Integer>();
        return inOrder(list,getRoot());
    }
    private ArrayList inOrder(ArrayList list,BinaryTreeNode node){
        if(node==null){
            return list;
        }
        list = inOrder(list,node.getLeftChild());
        list.add(node.getElement());
        list = inOrder(list,node.getRightChild());
        return list;
    }
    public ArrayList preOrder(){
        ArrayList list = new ArrayList<Integer>();
        return preOrder(list,getRoot());
    }
    private ArrayList preOrder(ArrayList list, BinaryTreeNode node){
        if(node==null){
            return list;
        }
        list.add(node.getElement());
        list = preOrder(list,node.getLeftChild());
        list = preOrder(list,node.getRightChild());
        return list;
    }
    public ArrayList postOrder(){
        ArrayList list = new ArrayList<Integer>();
        return postOrder(list,getRoot());

    }
    private ArrayList postOrder(ArrayList list, BinaryTreeNode node){
        if(node==null){
            return list;
        }
        list = postOrder(list,node.getLeftChild());
        list = postOrder(list,node.getRightChild());
        list.add(node.getElement());
        return list;
    }
    public ArrayList levelOrder(){
        ArrayList list = new ArrayList<Integer>();
        ArrayList discovered = new ArrayList<BinaryTreeNode>();
        discovered.add(getRoot());
        return levelOrder(list,discovered);
    }
    private ArrayList levelOrder(ArrayList list, ArrayList<BinaryTreeNode> discovered){
        if(discovered.size()==0){
            return list;
        }
        BinaryTreeNode current = discovered.get(0);
        discovered.remove(0);
        if(current==null){
            levelOrder(list,discovered);
        }else{
            list.add(current.getElement());
            discovered.add(current.getLeftChild());
            discovered.add(current.getRightChild());
            list = levelOrder(list,discovered);
        }
        return list;

    }
    //height is set to be the highest number of edges from the root to a leaf. // by convention an empty tree has height -1
    public int height(){
        return height(getRoot());
    }
    public int height(BinaryTreeNode node){
        if(node==null) return -1;
        int leftH = height(node.getLeftChild());
        int rightH = height(node.getRightChild());
        return Math.max(leftH,rightH)+1;
    }
}
