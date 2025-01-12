package baekjoon.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1940 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int count = 0;
    int[] nums = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(nums);

    // nums들을 활용해서 M이 되도록 만들어야함
    // 매번 합을 구하는 것이 아닌 이미 구해진 합에서 뺴주는 것을 통해 계산을 줄일 수 있음
    int i = 0;
    int j = N - 1;
    while (i < j) {
      int sum = nums[i] + nums[j];
      if (sum > M) {
        j--;
      } else if (sum == M) {
        count++;
        i++;
        j--;
      } else {
        i++;
      }
    }
    System.out.println(count);
  }
}
