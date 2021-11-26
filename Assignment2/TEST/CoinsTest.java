import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CoinsTest
{

  CoinsProblem problem;

  public void init(int amount){
    problem = new CoinsProblem(amount);
    List<Integer> coins = new ArrayList<>();
    coins.add(1);
    coins.add(7);
    coins.add(10);
    coins.add(22);
    problem.setCoins(coins);
  }

  @Test
  public void check20(){
    init(20);
    assertEquals(problem.solve(),2);
  }
  @Test
  public void check22(){
    init(22);
    assertEquals(problem.solve(),1);
  }
  @Test
  public void check23(){
    init(24);
    assertEquals(problem.solve(),3);
  }
  @Test
  public void check220(){
    init(220);
    assertEquals(problem.solve(),10);
  }
  @Test
  public void check15(){
    init(15);
    assertEquals(problem.solve(),3);
  }
  @Test
  public void check0(){
    init(0);
    assertEquals(problem.solve(),0);
  }
}
