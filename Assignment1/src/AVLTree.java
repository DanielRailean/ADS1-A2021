import java.util.ArrayList;

public class AVLTree{
    public AVLTree() {
        root = null;
        nodeCount = 0;
    }
    private int nodeCount;
    private AVLNode root;
    
    public AVLNode getRoot() {
        return root;
    }

    public void setRoot(AVLNode root) {
        this.root = root;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    public boolean contains(int element){
        return contains(getRoot(),element);
    }

    private boolean contains(AVLNode node, int element){
        if(node==null) return false;
        // returns true only if current element is true.
        if(node.getData()==element) return true;
            // call self for left and right child.
        else return contains(node.getLeftChild(),element)||contains(node.getRightChild(),element);

    }
    public ArrayList inOrder(){
        ArrayList list = new ArrayList<Integer>();
        return inOrder(list,getRoot());
    }
    private ArrayList inOrder(ArrayList list,AVLNode node){
        // if called for a leaf child return list == set nothing.
        if(node==null){
            return list;
        }
        // set left child set self and the set right child to the list.
        list = inOrder(list,node.getLeftChild());
        list.add(node.getData());
        list = inOrder(list,node.getRightChild());
        return list;
    }
    public int height(){
        // call the recursive function passing the root
        return height(getRoot());
    }
    //height is set to be the highest number of edges from the root to a leaf. // by convention an empty tree has height -1
    public int height(AVLNode node){
        if(node==null) return -1;
        int leftH = height(node.getLeftChild());
        int rightH = height(node.getRightChild());
        return Math.max(leftH,rightH)+1;
    }
    public int findMax(){
        if(findMaxData(getRoot())!=null)
            return findMaxData(getRoot()).getData();
        else return Integer.MIN_VALUE;
    }
    // calling the recursive brother passing the root and min possible value for integer
    public AVLNode findMaxData(AVLNode root){
        int max = Integer.MIN_VALUE;
        return findMax(root,max);
    };
    private AVLNode findMax(AVLNode node,int currentMax){
        // if called for a leaf child
        if(node==null){
            return null;
        }
        // else if searched is smaller than the current and there is a right node, try to find bigger number in the right than the current node value
        // other implementation might be going to the right until the right is null , then returning the value.
        if(node.getData()>currentMax&&node.getRightChild()!=null){
            node = findMax(node.getRightChild(),node.getData());
        }
        // if we are here than we are at the biggest node in the tree.
        return node;
    }

    // calling the recursive brother passing the root and returning its node value.
    public int findMin(){
        if(findMinData(getRoot())!=null)
            return findMinData(getRoot()).getData();
        else return Integer.MAX_VALUE;
    };

    // calling the recursive brother passing the root and min possible value for integer
    public AVLNode findMinData(AVLNode root){
        int max = Integer.MAX_VALUE;
        return findMin(root,max);
    }
    public AVLNode findMin(AVLNode node, int currentMin){
        // if called for a leaf child
        if(node==null){
            return null;
        }
        // else if searched is bigger than the current and there is a left node, try to find a smaller than this number in the left.
        if(node.getData()<currentMin&&node.getLeftChild()!=null){
            node = findMin(node.getLeftChild(),node.getData());
        }
        // if we are here than we are at the smallest node in the tree.
        return node;
    }

    public boolean isBalanced(int maxDiff){
//    int balance = isBalanced(getRoot(),maxDiff);
//    return Math.abs(balance)<=maxDiff;
        return isBalanced(getRoot(),maxDiff);
    }
    // an implementation of is balanced that returns boolean and not the balance value.
    public boolean isBalanced(AVLNode node, int maxDiff){
        if(node==null) return true;
        if(node.getRightChild()==null&&node.getLeftChild()==null) return true;
        else{
            int relativeDiff = height(node.getRightChild())-height(node.getLeftChild());

            int currentDiff =Math.abs(relativeDiff);

            boolean returned = (currentDiff<=maxDiff)&&isBalanced(node.getLeftChild(),maxDiff)&& isBalanced(node.getRightChild(),maxDiff);


            return returned;
        }
    }


    public AVLNode rotateRight(AVLNode node){
//        if (node == null) return null;
//        if(node.getLeftChild()==null) return node;

        AVLNode left = node.getLeftChild();
        node.setLeftChild(left.getRightChild());
        left.setRightChild(node);

        updateNode(node);
        updateNode(left);

        return left;
    }

    // left rotation
    public AVLNode rotateLeft(AVLNode node){
//        if (node == null) return null;
//        if(node.getRightChild()==null) return node;
        AVLNode right = node.getRightChild();
        node.setRightChild(right.getLeftChild());
        right.setLeftChild(node);

        updateNode(node);
        updateNode(right);

        return right;
    }
    public boolean insert(int element){
        if(!contains(element)){
            setRoot(insert(element,getRoot()));;
            nodeCount++;
            return true;
        }
        return false;
    };

    private AVLNode insert(int element, AVLNode node){
        if(node==null){
            return new AVLNode(element);
        }
        if(node.getData()>element){
            node.setLeftChild(insert(element,node.getLeftChild()));
        }else if(node.getData()<element){
            node.setRightChild(insert(element,node.getRightChild()));
        }

        updateNode(node);

        return balance(node);
    }

    public AVLNode balance(AVLNode node){
        if(node.getBalance() == -2){
            if(node.getLeftChild().getBalance()<=0){
                return leftLeftCase(node);
            }else{
                return leftRightCase(node);
            }
        }else if(node.getBalance() == 2){
            if(node.getRightChild().getBalance()>=0){
                return rightRightCase(node);
            }else{
                return rightLeftCase(node);
            }
        }
        return node;
    }

    public void updateNode(AVLNode node){
        int lh = -1;
        int rh = -1;
        if(node.getLeftChild()!=null) lh = node.getLeftChild().getHeight();
        if(node.getRightChild()!=null) rh = node.getRightChild().getHeight();

        node.setHeight(1+Math.max(lh,rh));
        node.setBalance(rh-lh);
    }

//     calling the recursive brother passing the root
    public boolean removeElement(int element){
        if(contains(element)){
            setRoot(delete(element,getRoot()));;
            nodeCount--;
            return true;
        }
        return false;
    };

    private AVLNode delete(int element, AVLNode node){
        if(node==null){
            return null;
        }
        if(node.getData()>element){
            node.setLeftChild(delete(element,node.getLeftChild()));
        }else if(node.getData()<element){
            node.setRightChild(delete(element,node.getRightChild()));
        }
        else{
            if(node.getRightChild()==null &&node.getLeftChild()==null)
                return null;

            else if(node.getLeftChild()==null){
                return node.getRightChild();
            }
            else if(node.getRightChild()==null){
                return node.getLeftChild();
            }
            else{
                int min = findMinData(node.getRightChild()).getData();
                node.setData(min);
                node.setRightChild(delete(min,node.getRightChild()));
            }
        }
        updateNode(node);

        return balance(node);
    }

    public AVLNode leftLeftCase(AVLNode node){
        return rotateRight(node);
    }
    public AVLNode leftRightCase(AVLNode node){
        node.setLeftChild(rotateLeft(node.getLeftChild()));
        return rotateRight(node);
    }
    public AVLNode rightRightCase(AVLNode node){
        return rotateLeft(node);
    }
    public AVLNode rightLeftCase(AVLNode node){
        node.setRightChild(rotateRight(node.getRightChild()));
        return rotateLeft(node);
    }


}
