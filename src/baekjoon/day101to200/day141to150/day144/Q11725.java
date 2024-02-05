package baekjoon.day101to200.day141to150.day144;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q11725 {

  static boolean[] visit; // 방문 배열 boolean[]
  static List<Integer>[] adjList; // 트리 배열 List<Integer> []

  static int[] resultArr; // 결과값(부모 노드) 저장 배열

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    visit = new boolean[N + 1];
    resultArr = new int[N+1];
    adjList = new List[N + 1];
    for (int i = 1; i <= N; i++) {
      adjList[i] = new ArrayList<>();
    }

    StringTokenizer st = null;
    // 자신의 인접 리스트 양방향으로 저장
    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      adjList[v1].add(v2);
      adjList[v2].add(v1);
    }

    // DFS 1부터 시작
    DFS(1);

    StringBuilder sb = new StringBuilder();
    for (int i = 2; i <= N; i++) {
      sb.append(resultArr[i]).append("\n");
    }
    System.out.println(sb);
  }

  public static void DFS(int node) {

    // 방문처리
    visit[node] = true;

    // 인접리스트 확인 후 탐색
    for (int n : adjList[node]) {
      if (!visit[n]) {
        // 탐색 진행 전 해당 노드의 부모 노드 저장
        resultArr[n] = node;
        DFS(n);
      }
    }
  }

}
