package baekjoon.day205;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11365 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    StringBuilder result = new StringBuilder();
    while (!(input = br.readLine()).equals("END")) {
      StringBuilder sb = new StringBuilder(input);
      result.append(sb.reverse()).append("\n");
    }
    System.out.println(result);
  }
}
