package baekjoon.day257;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q11723 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Set<Integer> numSet = new HashSet<>();
    Integer[] numArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      switch (st.nextToken()) {
        case "add":
          int num = Integer.parseInt(st.nextToken());
          numSet.add(num);
          break;
        case "remove":
          num = Integer.parseInt(st.nextToken());
          numSet.remove(num);
          break;
        case "check":
          num = Integer.parseInt(st.nextToken());
          sb.append(numSet.contains(num) ? 1 : 0).append("\n");
          break;
        case "toggle":
          num = Integer.parseInt(st.nextToken());
          if (numSet.contains(num)) {
            numSet.remove(num);
          } else {
            numSet.add(num);
          }
          break;
        case "all":
          numSet = new HashSet<>(Arrays.asList(numArr));
          break;
        case "empty":
          numSet = new HashSet<>();
          break;
      }
    }
    System.out.println(sb);
  }
}
