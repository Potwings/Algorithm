package baekjoon.day193;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1357 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    StringBuilder X = new StringBuilder(st.nextToken());
    StringBuilder Y = new StringBuilder(st.nextToken());

    int sum = Integer.parseInt(X.reverse().toString()) + Integer.parseInt(Y.reverse().toString());
    StringBuilder sumString = new StringBuilder(String.valueOf(sum));
    System.out.println(Integer.parseInt(sumString.reverse().toString())); // 앞자리 0을 제거하기위해 int로 변환
  }

//  /**
//   * 수를 활용하여 풀이
//   */
//  public static int rev(int num) {
//
//    int result = 0;
//    int length = (int) (Math.log10(num));
//    for (int i = 0; i <= length; i++) {
//      int digit = num % 10;
//      result += digit * Math.pow(10, length - i);
//      num /= 10;
//    }
//
//    return result;
//  }
}
