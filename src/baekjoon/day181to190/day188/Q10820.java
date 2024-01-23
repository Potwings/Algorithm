package baekjoon.day181to190.day188;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10820 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    StringBuilder sb = new StringBuilder();
    while ((input = br.readLine()) != null) {
      int[] result = new int[4]; // 소문자, 대문자, 숫자, 공백 순서로 값 저장
      char[] charArr = input.toCharArray();
      for (char c : charArr) {
        if (Character.isLowerCase(c)) {
          result[0]++;
        } else if (Character.isUpperCase(c)) {
          result[1]++;
        } else if (Character.isDigit(c)) {
          result[2]++;
        } else {
          result[3]++;
        }

      }

      for (int i = 0; i < 4; i++) {
        sb.append(result[i]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}