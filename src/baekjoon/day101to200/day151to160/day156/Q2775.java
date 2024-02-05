package baekjoon.day101to200.day151to160.day156;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2775 {

  static int[][] house;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    house = new int[15][15];
    for (int i = 1; i <= 14; i++) {
      house[i][1] = 1; // 각층에 1호는 한명만 산다.
      house[0][i] = i; // 0층은 호수의 숫자만큼 산다.
    }
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      int k = Integer.parseInt(br.readLine()); // 층
      int n = Integer.parseInt(br.readLine()); // 호수
      sb.append(checkPerson(k, n)).append("\n");
    }

    System.out.println(sb);
  }

  public static int checkPerson(int floor, int num) {
    if (house[floor][num] == 0) {
      // 인원수가 계산되지 않았을 경우 계산을 진행한다.
      /*
       * 문제에 주어졌듯이 k층의 n호의 인원 수는 k-1층의 1 ~ n호까지의 인원수를 모두 합한 것과 같다.
       * 이로 인하여 k층의 n-1호는 k-1층의 1 ~ n-1호까지의 인원수를 모두 합한 것과 같다.
       * 여기에 k-1층의 n호의 인원을 합하면 특정 층의 n호의 인원수를 알아낼 수 있다.
       */
      house[floor][num] = checkPerson(floor - 1, num) + checkPerson(floor, num - 1);
    }
    // 그 이외는 저장된 값 반환
    return house[floor][num];
  }

}
