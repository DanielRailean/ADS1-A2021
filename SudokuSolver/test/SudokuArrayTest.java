import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class SudokuArrayTest {

  SudokuSmallSquare rect;

  @BeforeEach
  public void initEach(){
     rect = new SudokuSmallSquare();
  }

  @Test
  public void checkInit(){
    assertTrue(rect.isValid());
    rect.print();
  }
  @Test
  public void checkValid(){
    assertTrue(rect.isValid());
    rect.print();
    rect.insert(1,5);
    rect.insert(2,3);
    rect.insert(4,6);
    rect.insert(8,9);
    rect.insert(9,8);
    rect.print();
  }

}
