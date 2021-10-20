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


    print.printTree(tree.getRoot());
    System.out.println();
    System.out.println("------------------------------------------------------");
//    System.out.println("balanced 2: "+tree.isBalanced(2));
//    System.out.println("balanced 1: "+tree.isBalanced(1));
//    System.out.println("balanced 0: "+tree.isBalanced(0));
    System.out.println(tree.getUnbalancedNode(2));
    System.out.println(tree.getUnbalancedNode(1).getElement());
    System.out.println(tree.getUnbalancedNode(0).getElement());
  }

}
