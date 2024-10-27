package baekjoon.day241to268.day264;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1373 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder input = new StringBuilder(br.readLine());
    while (input.length() % 3 > 0) {
      input.insert(0, 0);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); i += 3) {
      int num = (input.charAt(i) - '0') * 4
          + (input.charAt(i + 1) - '0') * 2
          + (input.charAt(i + 2) - '0') * 1;
      sb.append(num);
    }
    System.out.println(sb);
  }
}