package baekjoon.day239;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q15873 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int result = 0;
    for (char c : input.toCharArray()) {
        int num = c - '0';
        if (num == 0) {
          // 0이 나왔을 경우 앞에 무조건 1이다.
          result += 9; // 기존에 더해준 1을 빼주고 10을 더한다.
        }
        result += num;
    }
    System.out.println(result);
  }
}
