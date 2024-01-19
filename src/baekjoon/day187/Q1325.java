package baekjoon.day187;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * queue를 static 변수로 선언하여 주소값 할당하는데 소요되는 시간을 줄여서 통과함
 * TODO 완전 탐색이 아닌 다른 방식으로 접근하여 성능을 더 개선할 수 있어보임
 */
public class Q1325 {

  static Queue<Integer> queue;
  static int N;
  static int M;
  static ArrayList<Integer>[] adjListArr;
  static boolean[] visitArr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    adjListArr = new ArrayList[N + 1]; // 해당 컴퓨터를 신뢰하는 컴퓨터 목록
    int[] countArr = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      adjListArr[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      // A가 B를 신뢰한다는 형식으로 입력된다.(B를 신뢰하는 컴퓨터 목록에 A를 추가하면된다)
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      adjListArr[B].add(A);
    }

    // 1번부터 N번까지의 컴퓨터를 확인하며 가장 신뢰하는 컴퓨터 수가 많은 컴퓨터를 확인하면 된다.
    int maxCount = 0;
    for (int i = 1; i <= N; i++) {
      visitArr = new boolean[N + 1]; // 중복 확인 여부 배열 생성
      int count = BFS(i);
      countArr[i] = count;
      maxCount = Math.max(count, maxCount);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      if (countArr[i] == maxCount) {
        sb.append(i).append(" ");
      }
    }
    System.out.println(sb);
  }

  public static int BFS(int N) {
    queue = new LinkedList<>();
    int count = 0;
    queue.add(N);
    visitArr[N] = true;

    while (!queue.isEmpty()) {
      int com = queue.poll();
      count++;
      for (int adj : adjListArr[com]) {
        if (!visitArr[adj]) {
          queue.add(adj);
          visitArr[adj] = true;
        }
      }
    } // end while
    return count;
  }


}
