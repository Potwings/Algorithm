package baekjoon.day223;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2010 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long result = 0;
    for (int i = 0; i < N; i++) {
      result += Integer.parseInt(br.readLine());
    }
    System.out.println(result - (N - 1));
  }
}
