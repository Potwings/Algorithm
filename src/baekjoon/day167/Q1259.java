package baekjoon.day167;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1259 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    StringBuilder sb = new StringBuilder();
    while (!(input = br.readLine()).equals("0")) {
      int num = Integer.parseInt(input);
      int length = input.length();
      boolean result = true;

      for (int i = 1; i <= length / 2; i++) {
        int digit1 = num / (int) Math.pow(10, length - i) % 10; // 10^length - i로 나눈 후 그 수의 가장 뒷자리수만 가져온다.
        int digit2 = num % (int) Math.pow(10, i) / (int) Math.pow(10, i - 1); // 10^i로 나눈 후 그 수의 가장 앞자리수만 가져온다.
        if (digit1 != digit2) {
          result = false;
          break;
        }
      } // for loop end
      sb.append(result ? "yes" : "no").append("\n");
    } // while loop end
    System.out.println(sb);
  }

}
