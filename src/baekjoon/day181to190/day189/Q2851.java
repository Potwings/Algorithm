package baekjoon.day181to190.day189;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2851 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long sum = 0;
    long beforeDiff = 100;
    for (int i = 0; i < 10; i++) {
      long now = Long.parseLong(br.readLine());
      sum += now;
      long nowDiff = Math.abs(sum - 100);
      if (nowDiff <= beforeDiff) {
        // 차이가 작아졌을 경우 변경
        // 차이가 같을 경우 100보다 큰 경우와 작은 경우인데 큰 경우를 선택하므로 변경해준다.
        beforeDiff = nowDiff;
      } else {
        // 100과의 차이가 더 커졌을 경우 중단
        sum -= now;
        break;
      }
    }
    System.out.println(sum);
  }
}
