package baekjoon.day241to268.day259;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 개선 사항
 *
 * 이 문제의 경우 TOP-DOWN 방식으로 진행 시 재귀호출의 깊이가 깊어져 성능 저하가 발생한다.
 */
public class Q1699 {

  // BOTTOM-UP
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] D = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      D[i] = i;
      for (int j = 0; j <= (int) Math.sqrt(i); j++) {
        D[i] = Math.min(D[i], D[i - j * j] + 1);
      }
    }
    System.out.println(D[N]);
  }

  // TOP-DOWN
//  static int[] D;
//
//  public static void main(String[] args) throws Exception {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int N = Integer.parseInt(br.readLine());
//    D = new int[N + 1];
//    System.out.println(getCount(N));
//  }
//
//  public static int getCount(int num) {
//    if (D[num] == 0) {
//      D[num] = num; // 최대값은 num을 1로만 만들었을 때의 개수이다.
//      int square = (int) Math.sqrt(num);
//      for (int i = 1; i <= square; i++) {
//        int tempNum = num - i * i;
//        int count = 1; // 1은 위에서 제곱 수 빼주면서 발생한 count
//        if (tempNum > 0) {
//          count += getCount(tempNum);
//        }
//        D[num] = Math.min(count, D[num]);
//      }
//    }
//    return D[num];
//  }
}
