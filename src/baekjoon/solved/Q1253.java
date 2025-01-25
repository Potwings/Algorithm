package baekjoon.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1253 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] nums = new int[N];
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      nums[i] = num;
    }
    Arrays.sort(nums);

    int count = 0;
    for (int find = 0; find < N; find++) {
      int findNum = nums[find];
      int i = 0;
      int j = N - 1;
      while (i < j) {
        int sum = nums[i] + nums[j];
        if (sum > findNum) {
          j--;
        } else if (sum == findNum) {
          if (i == find) {
            i++;
            continue;
          }
          if (j == find) {
            j--;
            continue;
          }
          count++;
          break;
        } else {
          i++;
        }
      }
    }
    System.out.println(count);
  }
}
