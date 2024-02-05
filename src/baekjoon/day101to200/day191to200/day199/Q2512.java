package baekjoon.day101to200.day191to200.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * upperbound로 진행 시 총액이 예산합과 일치하는 경우 고려하지 않음
 */
public class Q2512 {

  static int[] budgets;
  static int N;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    budgets = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int max = 0;
    for (int i = 0; i < N; i++) {
      int budget = Integer.parseInt(st.nextToken());
      budgets[i] = budget;
      max = Math.max(budget, max);
    }
    int total = Integer.parseInt(br.readLine());

    int start = total / N;
    int end = max;

    while (end >= start) {
      int now = (start + end) / 2;
      int nowTotal = getTotal(now);

      if (nowTotal <= total) {
        // 실제 총액보다 작을 경우 예산을 증가시켜도 된다.
        start = now + 1;
      } else {
        // 실제 총액보다 크거나 같을 경우 예산을 줄여야 한다.
        end = now - 1;
      }
    }
    /*
     * 반복문을 start와 end가 같을 경우까지 실행하면 반복문의 마지막은 start == end인 경우이다.
     * 해당 경우는 total이 nowTotal이랑 같은 경우이고 start = now + 1이 발생하는데 이때 now가 정답이다.
     * 따라서 결과값은 end 또는 start - 1 이다.
     */
    System.out.println(end);
  }

//  public static void main(String[] args) throws Exception {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    N = Integer.parseInt(br.readLine());
//    budgets = new int[N];
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    int max = 0;
//    int sum = 0;
//    for (int i = 0; i < N; i++) {
//      int budget = Integer.parseInt(st.nextToken());
//      budgets[i] = budget;
//      sum += budget;
//      max = Math.max(budget, max);
//    }
//    int total = Integer.parseInt(br.readLine());
//
//    if (sum <= total) {
//      // 총액이 예산 총합보다 큰 경우 최대값 출력 후 종료
//      System.out.println(max);
//      return;
//    }
//
//    int start = total / N; // 상한선은 예산 총합을 N으로 나눈 값보단 크다
//    int end = max; // 최대값은 예산중 가장 큰 값이다.
//    /*
//     1. 넘지 않는 값 중 가장 큰 값을 구해야 하므로 총액을 처음으로 넘는 값을 uppderbound로 구한 후 1을 빼주면 된다.
//     */
//    while (end > start) {
//      int now = (start + end) / 2;
//      int nowTotal = getTotal(now);
//      if (nowTotal <= total) {
//        start = now + 1;
//      } else {
//        end = now;
//      }
//    }
//    System.out.println(end - 1);
//  }

  public static int getTotal(int maxBudget) {
    int total = 0;
    for (int i = 0; i < N; i++) {
      total += Math.min(budgets[i], maxBudget); // 상한선보다 클 경우 상한선 만큼 예산을 배정한다.
    }
    return total;
  }
}
