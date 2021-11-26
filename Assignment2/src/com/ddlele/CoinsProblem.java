package com.ddlele;

import java.util.ArrayList;
import java.util.List;

public class CoinsProblem
{

  int amount;
  List<Integer> coins;

  public CoinsProblem(int amount)
  {
    this.amount = amount;
    coins = new ArrayList<>();
  }

  public List<Integer> getCoins()
  {
    return coins;
  }

  public void setCoins(List<Integer> coins)
  {
    this.coins = coins;
  }

  public int solve()
  {

    // store calculated values
    int[] knownMin = new int[amount + 1];

    // 0 for 0
    knownMin[0] = 0;

    // set know mins to max possible
    for (int i = 1; i <= amount; i++)
      knownMin[i] = Integer.MAX_VALUE;

    // compute all for values up to desired amount
    for (int i = 1; i <= amount; i++)
    {
      // use coins smaller than amount
      for (int j = 0; j < coins.size(); j++)
        if (coins.get(j) <= i)
        {
          // check if result for current amount - max coin exists
          int result = knownMin[i - coins.get(j)];

          // if just calculated result is smaller than existing then reassign
          if (result != Integer.MAX_VALUE
              && result + 1 < knownMin[i])
            knownMin[i] = result + 1;
        }
    }
    if(knownMin[amount]==Integer.MAX_VALUE)
      return -1;

    return knownMin[amount];

  }
}