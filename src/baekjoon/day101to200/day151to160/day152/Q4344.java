package baekjoon.day101to200.day151to160.day152;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4344 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int C = Integer.parseInt(br.readLine());
    StringTokenizer st = null;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < C; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      double sum = 0;
      int[] scores = new int[N];
      for (int j = 0; j < N; j++) {
        int score = Integer.parseInt(st.nextToken());
        scores[j] = score;
        sum += score;
      }
      double average = sum / N;

      double overAverage = 0;
      for (int score : scores) {
        if (score > average) {
          overAverage++;
        }
      }
      double result = overAverage / N * 100;
      sb.append(String.format("%.3f", result)).append("%").append("\n");
    }
    System.out.println(sb);
  }
}
