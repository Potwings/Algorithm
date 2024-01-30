package baekjoon.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2875 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 여학생 수
    int M = Integer.parseInt(st.nextToken()); // 남학생 수
    int K = Integer.parseInt(st.nextToken()); // 인턴쉽 인원
    int total = N + M;

    // 팀은 여학생 2명 남학생 1명으로 구성되어야한다.
    int team = Math.min(N / 2, M); // 그중 더 작은 수의 팀 만큼 만들 수 있다.
    total -= (team * 3); // 이미 팀에 구성된 인원
    int diff = K - total; // 인턴쉽 인원에 부족한 학생 수
    if (diff > 0) {
      team -= diff / 3; // 부족한 수 만큼 팀을 해체한다.
      if (diff % 3 > 0) {
        team--; // 나누어 떨어지지 않을 경우 한 팀 더 해체
      }
    }
    System.out.println(team);
  }
}
