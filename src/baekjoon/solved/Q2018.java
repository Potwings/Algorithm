package baekjoon.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2018 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int start = 1;
    int end = 1;
    int result = 0;
    int sum = 1;
    while (end <= N) {
      if (sum > N) {
        sum -= start;
        start++;
      } else if (sum < N) {
        end++;
        sum += end;
      } else {
        result++;
        sum -= start;
        start++;
      }
    }
    System.out.println(result);
  }

}
