package baekjoon.day241to268.day266;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q2565 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = null;
//    Map<Integer, Integer> lineMap = new HashMap<>();
    int[][] lines = new int[N][2];
    // 전깃줄 정보 저장 (시작점 기준으로 오름 차순 정렬)
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      lines[i][0] = Integer.parseInt(st.nextToken());
      lines[i][1] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(lines, Comparator.comparingInt(nums -> nums[0]));

    int ascCount = 0;
    int[] D = new int[N];
    for (int i = 0; i < N; i++) {
      int end = lines[i][1];
      D[i] = 1;
      for (int j = N - 1; j >= 0; j--) {
        if (end > lines[j][1]) {
          D[i] = Math.max(D[i], D[j] + 1);
        }
      }
      ascCount = Math.max(ascCount, D[i]);
    }
    System.out.println(N - ascCount);
  }
}
