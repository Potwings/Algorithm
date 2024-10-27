package baekjoon.day241to268.day245;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11053 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] D = new int[N];
    for (int i = 0; i < N; i++) {
      D[i] = 1;
    }
    int[] numArr = new int[N];
    numArr[0] = Integer.parseInt(st.nextToken());
    int max = 1;
    for (int i = 1; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      numArr[i] = num;
      // 자신보다 작은 값 찾아 해당 값의 D값 확인 후 그 값에 + 1 진행
      for (int j = i - 1; j >= 0; j--) {
        int before = numArr[j];
        if (before < num) {
          int count = D[j] + 1;
          D[i] = Math.max(D[i], count);
        }
      }
      max = Math.max(max, D[i]);
    }
    System.out.println(max);
  }
}
