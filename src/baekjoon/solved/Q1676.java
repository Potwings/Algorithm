package baekjoon.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1676 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int count = 0;

    if (N == 0) {
      System.out.println(1);
      return;
    }

    count += N / 5;
    count += N / 25;
    count += N / 125;

    System.out.println(count);

  }

}
