package baekjoon.day190;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항 우측으로만 진행하므로 처음에 입력 받을 때 진행할 때 비교 진행하면 반복을 줄일 수 있다.
 */
public class Q14659 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int max = 0; // 최고 높이의 봉우리
    int count = 0; // 현재 봉우리의 처치 수
    int result = 0; // 최대 처치 수
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int now = Integer.parseInt(st.nextToken());
      if (now > max) {
        max = now;
        count = 0;
      } else {
        count++;
      }
      result = Math.max(result, count);
    }

    System.out.println(result);
  }

}
