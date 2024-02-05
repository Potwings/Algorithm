package baekjoon.day101to200.day191to200.day194;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11655 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (Character.isAlphabetic(c)) {
        char result = (char) (c + 13);
        if (Character.isUpperCase(c) && result > 'Z' || result > 'z') {
          result -= 26;
        }
        sb.append(result);
      } else {
        sb.append(c);
      }
    }
    System.out.println(sb);
  }
}
