package baekjoon.day211to240.day233;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q27433 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long result = 1;
    for (int N = Integer.parseInt(br.readLine()); N > 0; N--) {
      result *= N;
    }
    System.out.println(result);
  }
}
