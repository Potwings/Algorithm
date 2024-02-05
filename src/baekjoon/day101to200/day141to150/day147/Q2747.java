package baekjoon.day101to200.day141to150.day147;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2747 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int before = 0;
    int result = 1;
    for (int i = 1; i < N; i++) {
      int temp = result;
      result += before;
      before = temp;
    }

    System.out.println(result);
  }

}
