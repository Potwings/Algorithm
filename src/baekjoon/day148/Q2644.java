package baekjoon.day148;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2644 {

  // 인접 리스트
  static ArrayList<Integer>[] adjList;

  // 방문 배열
  static boolean[] visit;

  // 시작점
  static int start;
  // 종료 지점
  static int end;

  // main 메소드 시작
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 전체 인원 수 저장
    int N = Integer.parseInt(br.readLine());

    // 인접리스트, 방문배열 생성 (1부터 시작)
    adjList = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      adjList[i] = new ArrayList<>();
    }
    visit = new boolean[N + 1];

    // 확인해야할 대상 저장
    StringTokenizer st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());

    // 인접 리스트 저장(양방향)
    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      adjList[v1].add(v2);
      adjList[v2].add(v1);
    }

    // 시작점부터 BFS 시작
    int result = BFS(new Node(start, 0));
    System.out.println(result);
  }

  // BFS 메소드 시작
  public static int BFS(Node startNode) {

    // 큐 선언 Queue<Node>
    Queue<Node> queue = new LinkedList<>();

    // 시작점 방문 처리
    visit[startNode.num] = true;

    // 시작점 큐에 추가
    queue.offer(startNode);

    int result = -1; // 일치하는 노드가 없어 값이 변경되지 않을 경우 -1 반환
    // 큐가 비어있지 않을 경우 while loop
    while (!queue.isEmpty()) {
      // 큐에서 노드 추출
      Node node = queue.poll();
      int num = node.num;
      int count = node.count;
      if (num == end) {
        // 타겟 노드와 번호가 동일할 경우 현재 노드의 count result에 저장 후 break;
        result = count;
        break;
      }
      // 해당 노드의 인접리스트 확인
      for (int adj : adjList[num]) {
        // 방문하지 않은 인접 노드 방문
        if (!visit[adj]) {
          visit[adj] = true;
          queue.offer(new Node(adj, count + 1));
        }
      }
    }
    return result;
  }

  // Node 클래스 선언
  public static class Node {

    int num;// 자신의 번호 (num)
    int count;// 현재까지 방문한 노드의 수 (count)

    public Node(int num, int count) {
      this.num = num;
      this.count = count;
    }
  }

}
