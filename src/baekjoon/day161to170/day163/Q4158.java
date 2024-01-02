package baekjoon.day161to170.day163;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q4158 {

  public static void main(String[] args) throws Exception {
//    solveByBinarySearch();
    solveByHashMap();
  }

  public static void solveByHashMap() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = null;
    while (true) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken()); // N - 상근이 개수
      int M = Integer.parseInt(st.nextToken()); // M - 선영이 개수

      if (N == 0 && M == 0) {
        break;
      }

      HashSet<Integer> cdSet = new HashSet<>();
      for (int i = 0; i < N; i++) {
        cdSet.add(Integer.parseInt(br.readLine()));
      }

      int count = 0;
      for (int i = 0; i < M; i++) {
        if (cdSet.contains(Integer.parseInt(br.readLine()))) {
          count++;
        }
      }

      sb.append(count).append("\n");
    }
    System.out.println(sb);
  }

  public static void solveByBinarySearch() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = null;
    while (true) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken()); // N - 상근이 개수
      int M = Integer.parseInt(st.nextToken()); // M - 선영이 개수

      if (N == 0 && M == 0) {
        break;
      }

      // N개의 상근이 CD 번호
      int[] cdArr = new int[N];
      for (int i = 0; i < N; i++) {
        cdArr[i] = Integer.parseInt(br.readLine());
      }

      // M개의 선영이 CD 번호 -> 입력 받으면서 상근이 배열에서 이분 탐색 진행하며 개수 저장
      int count = 0;
      for (int i = 0; i < M; i++) {
        int findNum = Integer.parseInt(br.readLine());
        int start = 0;
        int end = N - 1;
        while (start <= end) {
          int now = (start + end) / 2;
          int nowNum = cdArr[now];
          if (nowNum < findNum) {
            start = now + 1;
          } else if (findNum < nowNum) {
            end = now - 1;
          } else {
            count++;
            break;
          }
        } // while search loop end
      } // for loop end
      sb.append(count).append("\n");
    } // while loop end
    System.out.println(sb);
  }
}
