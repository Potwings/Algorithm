package baekjoon.day262;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q15727 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int L = Integer.parseInt(br.readLine());
    System.out.println((int) Math.ceil(L / 5.0));
  }
}