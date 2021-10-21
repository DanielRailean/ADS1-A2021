import java.util.ArrayList;

public class BinaryTree {
    private BinaryTreeNode root;

    // getters and setters initial the tree root is null.
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

    // calling the recursive for the root.
    public int size(){
        return size(getRoot()) ;
    }

    private int size(BinaryTreeNode node){
        if(node==null) return 0;
        // calling size recursively for all nodes in the tree.
        else return 1+size(node.getRightChild())+size(node.getLeftChild());
    }

    // calling recursive contains func passing the root and element
    public boolean contains(int element){
        return contains(getRoot(),element);
    }

    private boolean contains(BinaryTreeNode node, int element){
        if(node==null) return false;
        // returns true only if current element is true.
        if(node.getElement()==element) return true;
        // call self for left and right child.
        else return contains(node.getLeftChild(),element)||contains(node.getRightChild(),element);

    }

    //calling the recursive inOrder passing the root and empty items array.
    public ArrayList inOrder(){
        ArrayList list = new ArrayList<Integer>();
        return inOrder(list,getRoot());
    }
    private ArrayList inOrder(ArrayList list,BinaryTreeNode node){
        // if called for a leaf child return list == add nothing.
        if(node==null){
            return list;
        }
        // add left child add self and the add right child to the list.
        list = inOrder(list,node.getLeftChild());
        list.add(node.getElement());
        list = inOrder(list,node.getRightChild());
        return list;
    }
    // calling the recursive preOrder with root and empty list
    public ArrayList preOrder(){
        ArrayList list = new ArrayList<Integer>();
        return preOrder(list,getRoot());
    }

    private ArrayList preOrder(ArrayList list, BinaryTreeNode node){
        // if called for a leaf child return list == add nothing.
        if(node==null){
            return list;
        }
        // else add self add left then right child.
        list.add(node.getElement());
        list = preOrder(list,node.getLeftChild());
        list = preOrder(list,node.getRightChild());
        return list;
    }
    // call the recursive brother
    public ArrayList postOrder(){
        ArrayList list = new ArrayList<Integer>();
        return postOrder(list,getRoot());

    }
    private ArrayList postOrder(ArrayList list, BinaryTreeNode node){
        // if called for a leaf child return list == add nothing.
        if(node==null){
            return list;
        }
        //else add left right then self.
        list = postOrder(list,node.getLeftChild());
        list = postOrder(list,node.getRightChild());
        list.add(node.getElement());
        return list;
    }
    // returns level ordered items in an array.
    public ArrayList levelOrder(){
        // create a new array for node values and for discovered nodes & call the level order for the the root and the empty list of items.
        ArrayList list = new ArrayList<Integer>();
        ArrayList discovered = new ArrayList<BinaryTreeNode>();
        discovered.add(getRoot());
        return levelOrder(list,discovered);
    }
    private ArrayList levelOrder(ArrayList list, ArrayList<BinaryTreeNode> discovered){
        // if node left to discover return all already added.
        if(discovered.size()==0){
            return list;
        }
        //get oldest discovered node && remove it from the front.
        BinaryTreeNode current = discovered.get(0);
        discovered.remove(0);
        // if current is null go to the next one.
        if(current==null){
            levelOrder(list,discovered);
        }
        //else add it to the list & add its children to the list. call function recursively for the updated discovered list.
        else{

            list.add(current.getElement());
            discovered.add(current.getLeftChild());
            discovered.add(current.getRightChild());
            list = levelOrder(list,discovered);
        }
        return list;

    }
    //returns height of the tree.
    public int height(){
        // call the recursive function passing the root
        return height(getRoot());
    }
    //height is set to be the highest number of edges from the root to a leaf. // by convention an empty tree has height -1
    public int height(BinaryTreeNode node){
        if(node==null) return -1;
        int leftH = height(node.getLeftChild());
        int rightH = height(node.getRightChild());
        return Math.max(leftH,rightH)+1;
    }
}
