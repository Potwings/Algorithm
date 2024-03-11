package baekjoon.day211to240.day213;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항 시작값이 1일 경우 고려 안함 (0과 1은 소수가 아니다)
 */
public class Q1929 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());

    boolean[] arr = new boolean[end + 1]; // 소수가 아닌 경우 true로 바꿔준다.
    arr[1] = true; // 1부터 시작하는 경우를 위하여(1은 소수가 아니다)

    for (int i = 2; i <= Math.sqrt(end); i++) {
      if (!arr[i]) {
        // 소수가 아닌 수는 이미 그 수의 약수로 인하여 배수 확인을 진행하였으므로 소수만 진행한다.
        for (int j = i * i; j <= end; j += i) {
          // i * i부터 시작하는 이유는 i * 2와 i * 3은 이미 이전에 2와 3의 배수로 처리되었기 때문
          arr[j] = true;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = start; i <= end; i++) {
      if (!arr[i]) {
        // false(소수)인 값만 출력
        sb.append(i).append("\n");
      }
    }
    System.out.println(sb);
  }
}
