package baekjoon.day157;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q5543 {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] buger = new int[3];
    int[] drink = new int[2];
    for(int i = 0; i < 3; i++) {
      buger[i] = Integer.parseInt(br.readLine());
    }
    for(int i = 0; i < 2; i++) {
      drink[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(buger);
    Arrays.sort(drink);

    System.out.println(buger[0] + drink[0] - 50);
  }
}
