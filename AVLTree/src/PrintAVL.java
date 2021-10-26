import java.util.ArrayList;

public class PrintAVL   {

    AVLNode root;

    /*
     * This method requires that there is a class AVLNode
     * and that the field "root" is initialized
     * as well as methods to set and get nodes and values:
     * E getData() // return the element stored in the node
     * (integers can be used directly used due to javas autoboxing unboxing
     * AVLNode getLeftChild()) // return a reference to leftChild
     * AVLNode getRightChild()) // return a reference to rightChild
     *
     * The tree must be created elsewhere (possible in a Main or Test class).
     */

    public void printTree(AVLNode root) {
        ArrayList<AVLNode> parent = new ArrayList<AVLNode>();
        parent.add(root);
        printT(parent, 64);
    }

    private void printT(ArrayList<AVLNode> parent, int left) {
        ArrayList<AVLNode> children = new ArrayList<AVLNode>();
        AVLNode current;
        boolean moreNodes = false;
        boolean firstNode = true;
        AVLNode dummy = new AVLNode(0);

        int dist = 0;
        System.out.println();
        System.out.println();

        while (!parent.isEmpty()) {
            current = parent.remove(0);

            if (firstNode) {
                printSpace(left);
                if (current.getData() != 0)
                    System.out.print("|"+current.getData()+"|");
                dist = 2 * left;
                firstNode = false;

                if (current.getData() != 0) {
                    if (current.getLeftChild() != null) {
                        children.add(current.getLeftChild());
                        moreNodes = true;
                    } else
                        children.add(dummy);
                    if (current.getRightChild() != null) {
                        children.add(current.getRightChild());
                        moreNodes = true;
                    } else
                        children.add(dummy);
                } else {
                    children.add(dummy);
                    children.add(dummy);
                }
            } else {
                if (current.getData() != 0) {
                    printSpace(dist - 1);
                    System.out.print("|"+current.getData()+"|");
                    if (current.getLeftChild() != null) {
                        children.add(current.getLeftChild());
                        moreNodes = true;
                    } else
                        children.add(dummy);
                    if (current.getRightChild() != null) {
                        children.add(current.getRightChild());
                        moreNodes = true;
                    } else
                        children.add(dummy);
                } else {
                    printSpace(dist - 1);
                    System.out.print(" ");
                    children.add(dummy);
                    children.add(dummy);
                }
            }
        }

        if (moreNodes)
            printT(children, left / 2);

    }

    private void printSpace(int pos) {
        for (int i = 0; i < pos; i++)
            System.out.print(" ");

    }


}
