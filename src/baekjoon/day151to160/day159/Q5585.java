package baekjoon.day151to160.day159;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5585 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int price = Integer.parseInt(br.readLine());
    int change = 1000 - price;
    int count = 0;
    int[] coins = {500, 100, 50, 10, 5, 1};
    for (int coin : coins) {
      if (change == 0) {
        break;
      }
      count += change / coin;
      change %= coin;
    }
    System.out.println(count);
  }
}
