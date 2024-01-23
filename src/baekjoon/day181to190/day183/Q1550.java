package baekjoon.day181to190.day183;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 개선 사항
 * Integer.parseInt의 두번째 파라미터로 몇 진수의 값을 10진수로 변환할 것인지 설정할 수 있다.
 */
public class Q1550 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(Integer.parseInt(br.readLine(), 16));
  }

//  public static void main(String[] args) throws Exception {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    String input = br.readLine();
//
//    int result = 0;
//    for (int i = 0; i < input.length(); i++) {
//      char c = input.charAt(i);
//      int digit = 0;
//      if (Character.isDigit(c)) {
//        digit = c - '0';
//      } else {
//        digit = c - 'A' + 10;
//      }
//      int num = (int) Math.pow(16, input.length() - i - 1) * digit;
//      result += num;
//    }
//    System.out.println(result);
//  }

}
