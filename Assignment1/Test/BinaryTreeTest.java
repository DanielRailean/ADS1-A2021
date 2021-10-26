import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class BinaryTreeTest {

    BinaryTree tree;

    @BeforeEach
    public void initEach(){
       tree = new BinaryTree<Integer>();
    }

    @Test
    public void CheckRoot(){
        BinaryTreeNode node =new BinaryTreeNode(10);
        tree.setRoot(node);
        assertTrue(tree.getRoot()!=null);
        assertTrue(tree.getRoot().equals(node));
        tree.setRoot(null);
        assertTrue(tree.getRoot()==null);
    }

    @Test
    public void CheckEmpty(){
        BinaryTreeNode node =new BinaryTreeNode(10);
        tree.setRoot(node);
        assertFalse(tree.isEmpty());
        tree.setRoot(null);
        assertTrue(tree.isEmpty());
    }
    @Test
    public void CheckSize(){
        BinaryTreeNode node =new BinaryTreeNode(10);
        BinaryTreeNode node1 =new BinaryTreeNode(11);
        BinaryTreeNode node2 =new BinaryTreeNode(12);
        BinaryTreeNode node3 =new BinaryTreeNode(13);
        BinaryTreeNode node4 =new BinaryTreeNode(14);
        node3.addLeftChild(node4);
        node1.addRightChild(node2);
        node.addRightChild(node3);
        node.addLeftChild(node1);
        tree.setRoot(node);
        BinaryTreePrint print = new BinaryTreePrint();
        print.printTree(node);
        assertFalse(tree.size()==1);
        assertFalse(tree.size()==0);
        assertTrue(tree.size()==5);
        tree.setRoot(null);
        assertTrue(tree.size()==0);
        assertFalse(tree.size()==1);
        assertFalse(tree.size()==5);
    }
    @Test
    public void CheckContains(){
        BinaryTreeNode node =new BinaryTreeNode(10);
        BinaryTreeNode node1 =new BinaryTreeNode(11);
        BinaryTreeNode node2 =new BinaryTreeNode(12);
        BinaryTreeNode node3 =new BinaryTreeNode(13);
        BinaryTreeNode node4 =new BinaryTreeNode(14);
        node3.addLeftChild(node4);
        node1.addRightChild(node2);
        node.addRightChild(node3);
        node.addLeftChild(node1);
        tree.setRoot(node);
        BinaryTreePrint print = new BinaryTreePrint();
        print.printTree(node);
        assertFalse(tree.contains(1));
        assertFalse(tree.contains(2));
        assertFalse(tree.contains(15));
        assertTrue(tree.contains(10));
        assertTrue(tree.contains(11));
        assertTrue(tree.contains(12));
        assertTrue(tree.contains(13));
        assertTrue(tree.contains(14));
        tree.setRoot(null);
        assertFalse(tree.contains(1));
        assertFalse(tree.contains(2));
        assertFalse(tree.contains(15));
        assertFalse(tree.contains(10));
        assertFalse(tree.contains(11));
        assertFalse(tree.contains(12));
        assertFalse(tree.contains(13));
        assertFalse(tree.contains(14));
    }
    @Test
    public void CheckInOrder(){
        BinaryTreeNode node =new BinaryTreeNode(10);
        BinaryTreeNode node1 =new BinaryTreeNode(11);
        BinaryTreeNode node2 =new BinaryTreeNode(12);
        BinaryTreeNode node3 =new BinaryTreeNode(13);
        BinaryTreeNode node4 =new BinaryTreeNode(14);
        node3.addLeftChild(node4);
        node1.addRightChild(node2);
        node.addRightChild(node3);
        node.addLeftChild(node1);
        tree.setRoot(node);
        BinaryTreePrint print = new BinaryTreePrint();
        print.printTree(tree.getRoot());
        ArrayList<Integer> correct = new ArrayList<>();
        correct.add(10);
        correct.add(11);
        correct.add(12);
        correct.add(13);
        assertFalse(ListIdentical(tree.inOrder(),correct));
        correct.add(14);
        System.out.println(tree.inOrder());
        assertFalse(ListIdentical(tree.inOrder(),correct));
        tree.setRoot(null);
        node3.addLeftChild(null);
        node1.addRightChild(null);
        node.addRightChild(null);
        node.addLeftChild(null);

        node.addRightChild(node1);
        node4.addLeftChild(node3);
        node2.addLeftChild(node);
        node2.addRightChild(node4);
        tree.setRoot(node2);
        print.printTree(tree.getRoot());
        System.out.println(tree.inOrder());
        assertTrue(ListIdentical(tree.inOrder(),correct));
    }
    @Test
    public void CheckPreOrder(){
        BinaryTreeNode node =new BinaryTreeNode(10);
        BinaryTreeNode node1 =new BinaryTreeNode(11);
        BinaryTreeNode node2 =new BinaryTreeNode(12);
        BinaryTreeNode node3 =new BinaryTreeNode(13);
        BinaryTreeNode node4 =new BinaryTreeNode(14);
        node3.addLeftChild(node4);
        node1.addRightChild(node2);
        node.addRightChild(node3);
        node.addLeftChild(node1);
        tree.setRoot(node);
        BinaryTreePrint print = new BinaryTreePrint();
        print.printTree(tree.getRoot());
        ArrayList<Integer> correct = new ArrayList<>();
        correct.add(12);
        correct.add(10);
        correct.add(11);
        correct.add(14);
        assertFalse(ListIdentical(tree.preOrder(),correct));
        correct.add(13);
        System.out.println(tree.preOrder());
        assertFalse(ListIdentical(tree.preOrder(),correct));
        tree.setRoot(null);
        node3.addLeftChild(null);
        node1.addRightChild(null);
        node.addRightChild(null);
        node.addLeftChild(null);

        node.addRightChild(node1);
        node4.addLeftChild(node3);
        node2.addLeftChild(node);
        node2.addRightChild(node4);
        tree.setRoot(node2);
        print.printTree(tree.getRoot());
        System.out.println(tree.preOrder());
        assertTrue(ListIdentical(tree.preOrder(),correct));
    }
    @Test
    public void CheckPostOrder(){
        BinaryTreeNode node =new BinaryTreeNode(10);
        BinaryTreeNode node1 =new BinaryTreeNode(11);
        BinaryTreeNode node2 =new BinaryTreeNode(12);
        BinaryTreeNode node3 =new BinaryTreeNode(13);
        BinaryTreeNode node4 =new BinaryTreeNode(14);
        node3.addLeftChild(node4);
        node1.addRightChild(node2);
        node.addRightChild(node3);
        node.addLeftChild(node1);
        tree.setRoot(node);
        BinaryTreePrint print = new BinaryTreePrint();
        print.printTree(tree.getRoot());
        ArrayList<Integer> correct = new ArrayList<>();
        correct.add(11);
        correct.add(10);
        correct.add(13);
        correct.add(14);
        assertFalse(ListIdentical(tree.postOrder(),correct));
        correct.add(12);
        System.out.println(tree.postOrder());
        assertFalse(ListIdentical(tree.postOrder(),correct));
        tree.setRoot(null);
        node3.addLeftChild(null);
        node1.addRightChild(null);
        node.addRightChild(null);
        node.addLeftChild(null);

        node.addRightChild(node1);
        node4.addLeftChild(node3);
        node2.addLeftChild(node);
        node2.addRightChild(node4);
        tree.setRoot(node2);
        print.printTree(tree.getRoot());
        System.out.println(tree.postOrder());
        assertTrue(ListIdentical(tree.postOrder(),correct));
    }
    @Test
    public void CheckLevelOrder(){
        BinaryTreeNode node =new BinaryTreeNode(10);
        BinaryTreeNode node1 =new BinaryTreeNode(11);
        BinaryTreeNode node2 =new BinaryTreeNode(12);
        BinaryTreeNode node3 =new BinaryTreeNode(13);
        BinaryTreeNode node4 =new BinaryTreeNode(14);
        node3.addLeftChild(node4);
        node1.addRightChild(node2);
        node.addRightChild(node3);
        node.addLeftChild(node1);
        tree.setRoot(node);
        BinaryTreePrint print = new BinaryTreePrint();
        print.printTree(tree.getRoot());
        ArrayList<Integer> correct = new ArrayList<>();
        correct.add(12);
        correct.add(10);
        correct.add(14);
        correct.add(11);
        assertFalse(ListIdentical(tree.levelOrder(),correct));
        correct.add(13);

        correct = new ArrayList<Integer>();

        correct.add(10);
        correct.add(11);
        correct.add(13);
        correct.add(12);
        assertFalse(ListIdentical(tree.levelOrder(),correct));
        correct.add(14);
        assertTrue(ListIdentical(tree.levelOrder(),correct));

        correct = new ArrayList<Integer>();
        correct.add(12);
        correct.add(10);
        correct.add(14);
        correct.add(11);
        correct.add(13);

        tree.setRoot(null);
        node3.addLeftChild(null);
        node1.addRightChild(null);
        node.addRightChild(null);
        node.addLeftChild(null);

        node.addRightChild(node1);
        node4.addLeftChild(node3);
        node2.addLeftChild(node);
        node2.addRightChild(node4);
        tree.setRoot(node2);
        print.printTree(tree.getRoot());
        System.out.println(tree.levelOrder());
        assertTrue(ListIdentical(tree.levelOrder(),correct));
    }
    @Test
    public void CheckHeight(){
        BinaryTreePrint print = new BinaryTreePrint();
        BinaryTreeNode node =new BinaryTreeNode(10);
        BinaryTreeNode node1 =new BinaryTreeNode(11);
        BinaryTreeNode node2 =new BinaryTreeNode(12);
        BinaryTreeNode node3 =new BinaryTreeNode(13);
        BinaryTreeNode node4 =new BinaryTreeNode(14);
        BinaryTreeNode node5 =new BinaryTreeNode(15);

        //height should be 2
        System.out.println(tree.height());
        assertTrue(tree.height()==-1);
        node3.addLeftChild(node4);
        node1.addRightChild(node2);
        node.addRightChild(node3);
        node.addLeftChild(node1);
        tree.setRoot(node);

        print.printTree(tree.getRoot());
        System.out.println(tree.height());

        assertTrue(tree.height()==2);
        assertFalse(tree.height()==1);
        assertFalse(tree.height()==3);

        //height should be 1
        tree.setRoot(null);
        node3.addLeftChild(null);
        node1.addRightChild(null);
        node.addRightChild(null);
        node.addLeftChild(null);
        assertTrue(tree.height()==-1);

        node2.addLeftChild(node);
        node2.addRightChild(node4);
        tree.setRoot(node2);

        print.printTree(tree.getRoot());
        System.out.println(tree.height());

        assertTrue(tree.height()==1);
        assertFalse(tree.height()==2);

        //height should be 3
        tree.setRoot(null);
        node3.addLeftChild(null);
        node1.addRightChild(null);
        node.addRightChild(null);
        node.addLeftChild(null);
        node1.addRightChild(node5);
        node.addRightChild(node1);
        node4.addLeftChild(node3);
        node2.addLeftChild(node);
        node2.addRightChild(node4);
        tree.setRoot(node2);

        print.printTree(tree.getRoot());
        System.out.println(tree.height());

        assertTrue(tree.height()==3);
        assertFalse(tree.height()==2);
        assertFalse(tree.height()==1);
    }

    @Test
    public void checkListIdentical(){
        ArrayList list1 = new ArrayList<Integer>();
        ArrayList list2 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        assertFalse(ListIdentical(list1,list2));
        list2.add(5);
        assertFalse(ListIdentical(list1,list2));
        list2.remove(3);
        list2.add(4);
        assertTrue(ListIdentical(list1,list2));
        assertTrue(ListIdentical(list2,list1));


    }

    public boolean ListIdentical(ArrayList list1,ArrayList list2){
        if(list1.size()!= list2.size()) return false;
        for(int i=0;i<list1.size();i++){
            if(list1.get(i)!=list2.get(i)) return false;
        }
        return true;
    }



}
