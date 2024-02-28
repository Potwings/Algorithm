package baekjoon.day228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1016 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long min = Long.parseLong(st.nextToken());
    long max = Long.parseLong(st.nextToken());
    int diff = (int) (max - min); // 둘의 차이의 최대값은 1000000이므로 int이다.
    boolean[] resultArr = new boolean[diff + 1]; // 제곱수의 배수이면 true로 저장
    for (int i = 2; i <= Math.sqrt(max); i++) {
      long squareNum = (long) i * i;
      long share = (long) Math.ceil((double) min / squareNum);
      for (long j = share * squareNum; j <= max; j += squareNum) {
        int idx = (int) (j - min);
        resultArr[idx] = true;
      }
    }
    int count = 0;
    for (boolean result : resultArr) {
      if (!result) {
        count++;
      }
    }
    System.out.println(count);
  }
}
