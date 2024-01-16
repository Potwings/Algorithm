package baekjoon.day184;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * result값이 int 범위가 넘어가는 경우 고려하지 않음
 * 그냥 숫자는 다 long으로 해버리자
 */
public class Q13458 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String candidateInfo = br.readLine();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int B = Integer.parseInt(st.nextToken()); // 총 감독관이 감시 가능한 수
    double C = Double.parseDouble(st.nextToken()); // 부 감독관이 감시 가능한 수

    st = new StringTokenizer(candidateInfo);
    long result = 0;
    for (int i = 0; i < N; i++) {
      result += 1; // 총 감독관 1명은 무조건 있어야 한다.
      int candidate = Integer.parseInt(st.nextToken());
      if (candidate > B) {
        // 남은 응시자 수를 부 감독관이 감시할 수 있는 수로 나누어 더해준다 (나누어 떨어지지 않을 경우 올림처리).
        result += (long) Math.ceil((candidate - B) / C);
      }
    }

    System.out.println(result);
  }

}
