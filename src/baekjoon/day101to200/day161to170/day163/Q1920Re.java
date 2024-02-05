package baekjoon.day101to200.day161to170.day163;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 복기를 위한 재풀이
 */
public class Q1920Re {

  static int[] nums;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    nums = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(nums);
    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      int find = Integer.parseInt(st.nextToken());
      boolean result = false;
      int start = 0;
      int end = N - 1;
      while (start <= end) {
        int now = (start + end) / 2;
        if (nums[now] < find) {
          start = now + 1;
        } else if (find < nums[now]) {
          end = now - 1;
        } else {
          result = true;
          break;
        }
      }
      sb.append(result ? 1 : 0).append("\n");
    }
    System.out.println(sb);
  }

}
