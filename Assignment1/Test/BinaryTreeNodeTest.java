import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BinaryTreeNodeTest {

    BinaryTreeNode node;

    @BeforeEach
    public void initEach(){
        node = new BinaryTreeNode(10);
    }

    @Test
    public void CheckNullInitial(){
        assertTrue(node.getElement()==10);
        assertTrue(node.getRightChild()==null);
        assertTrue(node.getLeftChild()==null);
    }

    @Test
    public void CheckLeftChild(){
        BinaryTreeNode left = new BinaryTreeNode(11);
        node.addLeftChild(left);
        assertFalse(node.getLeftChild()==null);
        assertTrue(node.getRightChild()==null);
        assertTrue(node.getLeftChild().getElement()==11);
    }
    @Test
    public void CheckRightChild(){
        BinaryTreeNode Right = new BinaryTreeNode(16);
        node.addRightChild(Right);
        assertFalse(node.getRightChild()==null);
        assertTrue(node.getLeftChild()==null);
        assertTrue(node.getRightChild().getElement()==16);
    }
    @Test
    public void CheckElement(){
        assertFalse(node.getElement()==11);
        assertTrue(node.getElement()==10);

        node.setElement(11);

        assertTrue(node.getElement()==11);
        assertFalse(node.getElement()==10);
    }
    @Test
    public void CheckEquals(){
        BinaryTreeNode node2 = new BinaryTreeNode(10);
        assertFalse(node.equals(node2));
        assertFalse(node2.equals(node));

        assertTrue(node.equals(node));
        assertTrue(node2.equals(node2));
    }




}
