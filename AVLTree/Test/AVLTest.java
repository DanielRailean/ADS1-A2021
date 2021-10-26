import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class AVLTest {

    // tree to be checked
    AVLTree tree;
    // used to print in the printTree() method at the bottom
    PrintAVL print = new PrintAVL();
    // maximum number of elements to check balance after inserts.
    int maxtest = 10000;
    // random to use in random insert.
    Random random = new Random();


    // create a new tree after each test.
    @BeforeEach
    public void initEach(){
        tree = new AVLTree();
    }

    // check if tree contains only inserted elements.

    // test removal

    // checking the tree balance after inserting maxtest amount of random numbers //
    // fails at random time between 10 and 100 inserts //
    // always returns a balanced avl tree. , tested up to 50 000 random values
    @Test
    public void bulkCheckInsertRandom(){
        for(int i=1;i<=maxtest;i++){
            int rand = random.nextInt(maxtest*10);
            tree.insert(rand);
            if (i % 1000 == 0) {
                System.out.println("inserted: no: " + i);
            }
            assertTrue(tree.isBalanced(1));
            assertTrue(tree.contains(rand));
        }

        ArrayList<Integer> inorder = tree.inOrder();
        System.out.println(inorder);
        assertTrue(inorder.size()==tree.getNodeCount());
        printTree();
    }

    @Test
    public void bulkCheckInsertDeleteRandom(){
        for(int i=1;i<=maxtest;i++){
            int rand = random.nextInt(maxtest);
            tree.insert(rand);
            if (i % 1000 == 0) {
                System.out.println("inserted: no: " + i);
            }
            assertTrue(tree.isBalanced(1));
            assertTrue(tree.contains(rand));
        }
        System.out.println("SIZE AFTER INSERTION: "+ tree.getNodeCount());
        printTree();
        for(int i=1;i<=maxtest*4;i++){
            int rand = random.nextInt(maxtest);
            tree.removeElement(rand);
            if (i % 1000 == 0) {
                System.out.println("removed: no: " + i);
            }
            assertTrue(tree.isBalanced(1));
            assertFalse(tree.contains(rand));

        }
        ArrayList<Integer> inorder = tree.inOrder();
        System.out.println(inorder);
        assertTrue(inorder.size()==tree.getNodeCount());
        System.out.println("SIZE AFTER deletion: "+ tree.getNodeCount());
        printTree();
    }

    //printing information about the tree as well as asserting its balancing
    public void printTree(){

//     uncomment to see info about trees after tests

//    print.printTree(tree.getRoot());
    System.out.println();
    System.out.println("------------------------------------------------------");
    System.out.println("Balance: "+Math.abs(tree.getRoot().getBalance()));
    assertTrue(Math.abs(tree.getRoot().getBalance())<2);
    System.out.println("balanced 2: "+tree.isBalanced(2));
    System.out.println("balanced 1: "+tree.isBalanced(1));
    assertTrue(tree.isBalanced(1));
    System.out.println("balanced 0: "+tree.isBalanced(0));
    assertTrue(tree.isBalanced(1));
    System.out.println(tree.inOrder());
    System.out.println("------------------------------------------------------");
    System.out.println();
    }

}
