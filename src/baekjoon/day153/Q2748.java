package baekjoon.day153;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2748 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long before = 0;
    long now = 1;
    for (int i = 1; i < N; i++) {
      long temp = now;
      now += before;
      before = temp;
    }

    System.out.println(now);
  }
}
