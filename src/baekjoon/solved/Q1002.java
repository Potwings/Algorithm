package baekjoon.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1002 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      // 하나의 원으로 생각
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int r1 = Integer.parseInt(st.nextToken());

      // 하나의 원으로 생각
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int r2 = Integer.parseInt(st.nextToken());

      double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      double rSum = r1 + r2;
      double rSub = Math.abs(r1 - r2);

      int result = -1;
      if (x1 == x2 && y1 == y2 && r1 == r2) {
        // 두 원이 일치하는 경우(무한대이므로 result = -1)
      } else if (distance > rSum) {
        // 하나의 원에 포함되어 접하지 않는 경우
        result = 0;
      } else if (distance == rSub) {
        // 내접하는 경우
        result = 1;
      } else if (distance > rSub && distance < rSum) {
        // 두 점에서 만나는 경우
        result = 2;
      } else if (distance == rSum) {
        // 외접하는 경우
        result = 1;
      } else {
        // 만나지 않는 경우
        result = 0;
      }
      sb.append(result).append("\n");
    }
    System.out.print(sb);
  }

}
