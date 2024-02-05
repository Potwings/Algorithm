package baekjoon.day101to200.day171to180.day173;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * min 최소값 1로 수정
 * min = now + 1로 인하여 int 최대값 초과하는 경우 발생하므로 자료형 long으로 수정
 */
public class Q1654 {

  static int[] cables;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 소유하고 있는 랜선 개수 K 입력
    int K = Integer.parseInt(st.nextToken());
    // 만들어야할 랜선 개수 N 입력
    int N = Integer.parseInt(st.nextToken());

    cables = new int[K];
    long min = 1;
    long max = 0;
    // 최대값 확인하며 랜선 길이 배열 입력
    for (int i = 0; i < K; i++) {
      int cable = Integer.parseInt(br.readLine());
      cables[i] = cable;
      if (cable > max) {
        max = cable;
      }
    }

    /* 제작할 랜선 길이에 따른 변화하는 랜선 개수를 확인하며 이분 탐색 진행
     * 랜선 길이가 증가할 경우 -> 랜선 개수 감소
     * 랜선 길이가 감소할 경우 -> 랜선 개수 증가
     *
     * 탐색 규칙
     * 목표 랜선 개수(N)보다 랜선 개수가 적을 경우 랜선 길이 감소시킨다 - 탐색 대상 min = now + 1
     * 목표 랜선 개수(N)보다 랜선 개수가 많거나 같을 경우 랜선 길이 증가시킨다(최대 길이를 구해야하기 때문) - 탐색 대상 max = now - 1.
     * 탐색 최소 랜선 길이가 탐색 최대 랜선 길이보다 커질 경우 탐색 종료
     * 결과값은 max값이다.(개수를 충족하며 가장 긴 경우)
     *
     * 결과값 max return 하는 이유
     * 탐색 범위에서 min보다 작은값은 결과로 가능하나 최대값이 아닐 수 있으나, max보다 큰 값은 결과로 불가능한 값이다.
     * 이떄 만일 now가 불가능하다면 max = now -1로 인해 max는 가능한 수가 된다.
     * 만일 now가 가능하다면 min = now + 1이 되겠으나 max보다 큰 값이므로 이미 불가능한 수이다.
     * 따라서 결과값은 항상 max이다.
     */
    while (min <= max) {
      long now = (min + max) / 2;
      int count = getCableCount(now);
      if (count >= N) {
        min = now + 1; // 랜선의 최대 길이는 2^31 - 1 인데 여기서 + 1을 진행할 경우 int 범위를 초과한다.
      } else {
        max = now - 1;
      }
    }
    // min 값 출력
    System.out.println(max);
  }

  public static int getCableCount(long length) {

    int count = 0;
    for (int cable : cables) {
      count += cable / length;
    }
    return count;
  }
}
