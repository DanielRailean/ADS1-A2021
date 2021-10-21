import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class BinarySearchTreeTest {

  BinarySearchTree tree;
  BinaryTreePrint print = new BinaryTreePrint();

  @BeforeEach
  public void initEach(){
    tree = new BinarySearchTree();
  }

  @Test
  public void CheckInsert(){
    tree.insert(12);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(7);
    tree.insert(13);
    tree.insert(17);
    tree.insert(1);
    tree.insert(9);
    tree.insert(14);
    tree.insert(20);
    tree.insert(8);
    tree.insert(11);
    tree.insert(18);
    print.printTree(tree.getRoot());
    assertTrue(tree.contains(1));
    assertTrue(tree.contains(15));
    assertFalse(tree.contains(122));
  }
  @Test
  public void findMax(){
    tree.insert(12);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(7);
    tree.insert(13);
    tree.insert(17);
    tree.insert(1);
    tree.insert(9);
    tree.insert(14);
    tree.insert(20);
    tree.insert(8);
    tree.insert(11);
    tree.insert(18);
    print.printTree(tree.getRoot());
    System.out.println();
    System.out.println("------------------------------------------------------");
    System.out.println(tree.findMax());
    assertTrue(tree.findMax()==20);
  }
  @Test
  public void findMin(){
    tree.insert(12);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(7);
    tree.insert(13);
    tree.insert(17);
    tree.insert(1);
    tree.insert(9);
    tree.insert(14);
    tree.insert(20);
    tree.insert(8);
    tree.insert(11);
    tree.insert(18);
    print.printTree(tree.getRoot());
    System.out.println();
    System.out.println("------------------------------------------------------");
    System.out.println(tree.findMin());
    assertTrue(tree.findMin()==1);
  }
  @Test
  public void Remove(){
    tree.insert(12);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(7);
    tree.insert(13);
    tree.insert(17);
    tree.insert(1);
    tree.insert(9);
    tree.insert(14);
    tree.insert(20);
    tree.insert(8);
    tree.insert(11);
    tree.insert(18);

    assertTrue(tree.contains(15));
    assertTrue(tree.contains(5));
    assertTrue(tree.contains(1));
    assertTrue(tree.contains(20));
    print.printTree(tree.getRoot());
    System.out.println();
    System.out.println("------------------------------------------------------");
    tree.removeElement(15);
    print.printTree(tree.getRoot());

    assertFalse(tree.contains(15));
    assertTrue(tree.contains(5));
    assertTrue(tree.contains(1));
    assertTrue(tree.contains(20));

    System.out.println();
    System.out.println("------------------------------------------------------");
    tree.removeElement(5);
    print.printTree(tree.getRoot());

    assertFalse(tree.contains(15));
    assertFalse(tree.contains(5));
    assertTrue(tree.contains(1));
    assertTrue(tree.contains(20));

    System.out.println();
    System.out.println("------------------------------------------------------");
    tree.removeElement(1);
    print.printTree(tree.getRoot());

    assertFalse(tree.contains(15));
    assertFalse(tree.contains(5));
    assertFalse(tree.contains(1));
    assertTrue(tree.contains(20));

    System.out.println();
    System.out.println("------------------------------------------------------");
    tree.removeElement(20);
    print.printTree(tree.getRoot());
    System.out.println();
    System.out.println("------------------------------------------------------");

    assertFalse(tree.contains(15));
    assertFalse(tree.contains(5));
    assertFalse(tree.contains(1));
    assertFalse(tree.contains(20));

    assertTrue(tree.contains(13));
    assertTrue(tree.contains(17));
    assertTrue(tree.contains(3));
    assertTrue(tree.contains(7));
    assertTrue(tree.contains(18));
  }

  @Test
  public void checkBalance(){
    tree.insert(12);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(7);
    tree.insert(13);
    tree.insert(17);
    tree.insert(1);
    tree.insert(9);
    tree.insert(14);
    tree.insert(20);
    tree.insert(8);
    tree.insert(11);
    tree.insert(18);
//    tree.insert(16);

//    System.out.println("balanced 1: "+tree.isBalanced(1));
//
//    System.out.println("height of "+tree.getRoot().getRightChild().getElement()+" is "+tree.height(tree.getRoot().getRightChild()));
//    System.out.println("height of "+tree.getRoot().getLeftChild().getElement()+" is "+tree.height(tree.getRoot().getLeftChild()));
//    tree.insert(18);


    printTree();
    tree.rebalance();
    printTree();
    System.out.println("balanced 1: "+tree.isBalanced(1));
//    assertTrue(tree.isBalanced(2));
//    assertFalse(tree.isBalanced(0));
//    assertFalse(tree.isBalanced(1));
  }
  @Test
  public void checkRotateRight(){
    tree.insert(5);
    tree.insert(2);
    tree.insert(3);
    tree.insert(1);
    tree.insert(6);
    tree.insert(7);


    print.printTree(tree.getRoot());
    System.out.println();
    System.out.println("------------------------------------------------------");
    System.out.println("balanced 2: "+tree.isBalanced(2));
    System.out.println("balanced 1: "+tree.isBalanced(1));
    System.out.println("balanced 0: "+tree.isBalanced(0));
    tree.setRoot(tree.rotateRight(tree.getRoot()));
    print.printTree(tree.getRoot());
    System.out.println();
    System.out.println("------------------------------------------------------");
  }
  @Test
  public void checkRotateLeft(){
    tree.insert(5);
    tree.insert(2);
    tree.insert(3);
    tree.insert(1);
    tree.insert(6);
    tree.insert(7);


    print.printTree(tree.getRoot());
    System.out.println();
    System.out.println("------------------------------------------------------");
    System.out.println("balanced 2: "+tree.isBalanced(2));
    System.out.println("balanced 1: "+tree.isBalanced(1));
    System.out.println("balanced 0: "+tree.isBalanced(0));
    tree.setRoot(tree.rotateLeft(tree.getRoot()));
    print.printTree(tree.getRoot());
    System.out.println();
    System.out.println("------------------------------------------------------");
  }

  @Test
  public void checkSingleReBalance(){
    tree.insert(5);
    tree.insert(3);
    tree.insert(2);
    tree.insert(1);
    tree.insert(0);
    tree.insert(6);
    tree.insert(7);
    tree.insert(8);
    tree.insert(9);


    printTree();

    tree.setRoot(tree.rebalance(1,tree.getRoot()));

    printTree();

  }
  @Test
  public void checkReBalance(){
    tree.insert(12);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(7);
    tree.insert(13);
    tree.insert(17);
    tree.insert(1);
    tree.insert(9);
    tree.insert(14);
    tree.insert(20);
    tree.insert(8);
    tree.insert(11);
    tree.insert(18);

    printTree();

    tree.rebalance();
    printTree();

  }
  @Test
  public void bulkCheckReBalance(){
    int maxtest = 200;
    for(int i=1;i<=maxtest/2;i++){
      System.out.println("adding nr:"+ i );
      tree.insert(i);
      if(!tree.isBalanced(1)){
//        System.out.println("---- Rebalance");
        tree.rebalance();
      }
      System.out.println("adding nr:"+ (maxtest-i));

      tree.insert(maxtest-i);
      if (i % 1000 == 0) {
        System.out.println("adding nr:"+ i );
      }
      printTree();
      if(!tree.isBalanced(1)){
//        System.out.println("---- Rebalance");
        tree.rebalance();
      }
    }
    printTree();
    ArrayList<Integer> inorder = tree.inOrder();
    assertTrue(inorder.get(0)==1);
    assertTrue(inorder.get(inorder.size()-1)==maxtest-1);
  }

  public void printTree(){
    System.out.println();
    System.out.println("------------------------------------------------------");
    print.printTree(tree.getRoot());
    System.out.println();
    System.out.println("size: "+tree.size());
    System.out.println("is binary search: "+tree.isBinarySearch());
    System.out.println("balanced 3: "+tree.isBalanced(3));
    System.out.println("balanced 2: "+tree.isBalanced(2));
    System.out.println("balanced 1: "+tree.isBalanced(1));
    System.out.println("balanced 0: "+tree.isBalanced(0));
    System.out.println(tree.inOrder());
    System.out.println("------------------------------------------------------");
    System.out.println();
  }

}
