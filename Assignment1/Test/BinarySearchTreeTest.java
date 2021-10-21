import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class BinarySearchTreeTest {

  // tree to be checked
  BinarySearchTree tree;
  // used to print in the printTree() method at the bottom
  BinaryTreePrint print = new BinaryTreePrint();
  // maximum number of elements to check balance after inserts.
  int maxtest = 1000;
  // random to use in random insert.
  Random random = new Random();


  // create a new tree after each test.
  @BeforeEach
  public void initEach(){
    tree = new BinarySearchTree();
  }

  // check if tree contains only inserted elements.
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
    printTree();
    assertTrue(tree.contains(1));
    assertTrue(tree.contains(15));
    assertFalse(tree.contains(122));
  }

  // adds elements and finds max.
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
    printTree();
    assertTrue(tree.findMax()==20);
  }

  // adds elements and finds min.
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
    printTree();

    assertTrue(tree.findMin()==1);
  }

  // test removal
  @Test
  public void Remove(){
    // add nodes
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

    // check content
    assertTrue(tree.contains(15));
    assertTrue(tree.contains(5));
    assertTrue(tree.contains(1));
    assertTrue(tree.contains(20));
    printTree();
    tree.removeElement(15);
    printTree();

    // remove one check rest
    assertFalse(tree.contains(15));
    assertTrue(tree.contains(5));
    assertTrue(tree.contains(1));
    assertTrue(tree.contains(20));

    printTree();
    tree.removeElement(5);
    printTree();

    // remove one more check rest

    assertFalse(tree.contains(15));
    assertFalse(tree.contains(5));
    assertTrue(tree.contains(1));
    assertTrue(tree.contains(20));

    printTree();
    tree.removeElement(1);
    printTree();

    // remove one more check rest

    assertFalse(tree.contains(15));
    assertFalse(tree.contains(5));
    assertFalse(tree.contains(1));
    assertTrue(tree.contains(20));

    printTree();
    tree.removeElement(20);
    printTree();

    // remove one more check rest

    assertFalse(tree.contains(15));
    assertFalse(tree.contains(5));
    assertFalse(tree.contains(1));
    assertFalse(tree.contains(20));

    // check rest

    assertTrue(tree.contains(13));
    assertTrue(tree.contains(17));
    assertTrue(tree.contains(3));
    assertTrue(tree.contains(7));
    assertTrue(tree.contains(18));
  }

  // makes an unbalanced tree, tries to rebalance and checks if succeed.
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

    tree.rebalance();
    printTree();
    assertTrue(tree.isBalanced(1));
  }

  // insert elements print tree, rotate left then print again.
  @Test
  public void checkRotateRight(){
    tree.insert(5);
    tree.insert(2);
    tree.insert(3);
    tree.insert(1);
    tree.insert(6);
    tree.insert(7);

    printTree();
    tree.setRoot(tree.rotateRight(tree.getRoot()));
    printTree();
  }

  // check left rotate;
  @Test
  public void checkRotateLeft(){
    tree.insert(5);
    tree.insert(2);
    tree.insert(3);
    tree.insert(1);
    tree.insert(6);
    tree.insert(7);

    printTree();
    tree.setRoot(tree.rotateLeft(tree.getRoot()));
    printTree();
  }

  // try to rebalance once
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

    tree.setRoot(tree.rebalance(1,tree.getRoot()));

    printTree();
    assertTrue(tree.isBalanced(1));
  }
  // same as before pretty much
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

    tree.rebalance();
    printTree();
    assertTrue(tree.isBalanced(1));


  }
  // checking the tree balance after inserting all numbers between  maxtest and 1 value
  // inserts small then big
  // tested up to maxtest =50000;
  @Test
  public void bulkCheckReBalanceSmallBig(){
    for(int i=1;i<=maxtest/2;i++){
      tree.insert(i);
      tree.rebalance();
      tree.insert(maxtest-i);
      tree.rebalance();
      if (i % 1000 == 0) {
        System.out.println("adding nr:"+ i );
      }
    }
    printTree();
    ArrayList<Integer> inorder = tree.inOrder();
    assertTrue(inorder.get(0)==1);
    assertTrue(tree.isBalanced(1));
    assertTrue(inorder.get(inorder.size()-1)==maxtest-1);
  }
  // checking the tree balance after inserting all numbers between  maxtest and 1 value
  // inserts big then small
  // tested up to maxtest =50000;
  @Test
  public void bulkCheckReBalanceBigSmall(){
 
    for(int i=1;i<=maxtest/2;i++){
      tree.insert(maxtest-i);
      tree.rebalance();
      tree.insert(i);
      tree.rebalance();
      if (i % 1000 == 0) {
        System.out.println("adding nr:"+ i );
        assertTrue(tree.isBalanced(1));
      }
    }
    printTree();
    ArrayList<Integer> inorder = tree.inOrder();
    assertTrue(inorder.get(0)==1);
    assertTrue(tree.isBalanced(1));
    assertTrue(inorder.get(inorder.size()-1)==maxtest-1);
  }
  // checking the tree balance after inserting all numbers between  maxtest and 1 value  // tested up to maxtest =50000;
  @Test
  public void bulkCheckReBalanceBig(){
 
    for(int i=1;i<=maxtest;i++){
      tree.insert(maxtest-i);
      tree.rebalance();
      if (i % 1000 == 0) {
        System.out.println("adding nr:"+ i );
      }
    }
    printTree();
    ArrayList<Integer> inorder = tree.inOrder();
    assertTrue(inorder.get(0)==0);
    assertTrue(tree.isBalanced(1));
    assertTrue(inorder.get(inorder.size()-1)==maxtest-1);
  }
  // checking the tree balance after inserting maxtest amount of random numbers //
  // fails at random time between 10 and 100 inserts //
  // always returns a tree balanced with a minimum value of 2 , tested up to 50 000 random values (1h16m)
  @Test
  public void bulkCheckReBalanceRandom(){
    for(int i=1;i<=maxtest;i++){
      int rand = random.nextInt(maxtest*10);
      tree.insert(rand);
      tree.rebalance();
      if (i % 1000 == 0){
        System.out.println("adding nr:"+ i );
        //uncomment the code below to check when the balance is no longer maintained
//        assertTrue(tree.isBalanced(1));
      }

    }
    printTree();
    ArrayList<Integer> inorder = tree.inOrder();
    assertTrue(tree.isBalanced(1));
  }

  // checking the tree balance after inserting all numbers between 1 and maxtest value  // tested up to maxtest =50000;
  @Test
  public void bulkCheckReBalanceSmall(){
    for(int i=1;i<=maxtest;i++){
      tree.insert(i);
      tree.rebalance();
      if (i % 1000 == 0) {
        System.out.println("adding nr:"+ i );
      }
    }
    printTree();
    ArrayList<Integer> inorder = tree.inOrder();
    assertTrue(inorder.get(0)==1);
    assertTrue(tree.isBalanced(1));
    assertTrue(inorder.get(inorder.size()-1)==maxtest);
  }

  //printing information about the tree as well as asserting its balancing
  public void printTree(){

//     uncomment to see info about trees after tests.
//    System.out.println();
//    System.out.println("------------------------------------------------------");
////    print.printTree(tree.getRoot());
//    System.out.println();
//    System.out.println("size: "+tree.size());
//    assertTrue(tree.isBinarySearch());
//    System.out.println("balanced 2: "+tree.isBalanced(2));
//    System.out.println("balanced 1: "+tree.isBalanced(1));
////    assertTrue(tree.isBalanced(1));
//    System.out.println("balanced 0: "+tree.isBalanced(0));
//    System.out.println(tree.inOrder());
//    System.out.println("------------------------------------------------------");
//    System.out.println();
  }

}
