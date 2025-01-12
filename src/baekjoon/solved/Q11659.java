package baekjoon.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11659 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] nums = new int[N + 1];
    int[] sumArr = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    int sum = 0;
    for (int i = 1; i <= N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
      sumArr[i] = sum += nums[i];
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      sb.append(sumArr[end] - sumArr[start - 1]).append("\n");
    }

    System.out.println(sb);
  }

}
