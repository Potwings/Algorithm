package baekjoon.day101to200.day161to170.day164;

import java.io.*;
import java.util.*;

/**
 * 개선 사항
 * 이분 탐색 진행할 배열 크기순으로 정렬하지 않음
 */
public class Q2776 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st = null;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      int[] numArr = new int[N];
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        numArr[j] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(numArr);
      int M = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int target = Integer.parseInt(st.nextToken());
        int start = 0;
        int end = N - 1;
        int result = 0;
        while (start <= end) {
          int idx = (start + end) / 2;
          int now = numArr[idx];
          if (target < now) {
            end = idx - 1;
          } else if (target > now) {
            start = idx + 1;
          } else {
            result = 1;
            break;
          }
        } // binary search end
        sb.append(result).append("\n");
      } // for loop end
    }

    System.out.println(sb);
  }

}
