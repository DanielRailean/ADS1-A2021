import java.util.ArrayList;
import java.util.List;

public class Main
{
  public static void main(String[] args)
  {
    int n = 4;
    QueenProblem queenProblem = new QueenProblem(n);
    queenProblem.solve();

    System.out.println("Result for queens problem for n = "+n+" :");
    queenProblem.print();
    System.out.println();

    int amount = 15;
    CoinsProblem coinsProblem = new CoinsProblem(amount);
    List<Integer> coins = new ArrayList<>();
    coins.add(1);
    coins.add(7);
    coins.add(10);
    coins.add(22);
    coinsProblem.setCoins(coins);
    System.out.println("Min nr of coins to sum  "+amount+" is "+ coinsProblem.getResult());
  }
}
