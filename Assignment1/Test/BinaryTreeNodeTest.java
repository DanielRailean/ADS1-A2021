import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BinaryTreeNodeTest {

    BinaryTreeNode node;

    @BeforeEach
    public void initEach(){
        node = new BinaryTreeNode(new E(10));
    }

    @Test
    public void CheckNullInitial(){
        assertTrue(node.getElement().getValue()==10);
        assertTrue(node.getRightChild()==null);
        assertTrue(node.getLeftChild()==null);
    }

    @Test
    public void CheckLeftChild(){
        BinaryTreeNode left = new BinaryTreeNode(new E(11));
        node.addLeftChild(left);
        assertFalse(node.getLeftChild()==null);
        assertTrue(node.getRightChild()==null);
        assertTrue(node.getLeftChild().getElement().getValue()==11);
    }
    @Test
    public void CheckRightChild(){
        BinaryTreeNode Right = new BinaryTreeNode(new E(16));
        node.addRightChild(Right);
        assertFalse(node.getRightChild()==null);
        assertTrue(node.getLeftChild()==null);
        assertTrue(node.getRightChild().getElement().getValue()==16);
    }
    @Test
    public void CheckElement(){
        assertFalse(node.getElement().getValue()==11);
        assertTrue(node.getElement().getValue()==10);

        node.setElement(new E(11));
        
        assertTrue(node.getElement().getValue()==11);
        assertFalse(node.getElement().getValue()==10);
    }



}
