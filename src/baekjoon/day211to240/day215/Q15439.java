package baekjoon.day211to240.day215;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q15439 {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    System.out.println(N * (N - 1));
  }
}