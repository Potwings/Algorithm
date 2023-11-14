package baekjoon.day121;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260 {
    static ArrayList<Integer>[] adjListArr;

    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 노드 수 입력 int
        int N = Integer.parseInt(st.nextToken());
        // 에지 수 입력 int
        int M = Integer.parseInt(st.nextToken());
        // 시작 노드
        int V = Integer.parseInt(st.nextToken());

        // 인접리스트 생성 ArrayList[]
        adjListArr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjListArr[i] = new ArrayList<>();
        }
        // 방문배열 생성
        visit = new boolean[N + 1];
        // 인접리스트 값 삽입
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            // 양방향 에지이므로 양쪽 모두 추가
            adjListArr[node1].add(node2);
            adjListArr[node2].add(node1);
        }

        // 방문 노드가 여러 개일 경우 번호가 작은 것을 미리 방문하므로 인접리스트 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjListArr[i]);
        }

        // DFS 진행
        DFS(V);

        // 방문배열 초기화
        visit = new boolean[N + 1];
        // 두 결과 사이의 개행
        sb.append("\n");

        // BFS 진행
        BFS(V);

        // 결과 출력
        System.out.println(sb);
    }

    public static void DFS(int n) {
        // 방문 처리
        visit[n] = true;

        // 탐색 결과에 추가
        sb.append(n).append(" ");

        // 인접 노드 방문
        for (int node : adjListArr[n]) {
            if (!visit[node]) {
                // 방문한 적이 없으면 방문
                DFS(node);
            }
        }
    }

    public static void BFS(int v) {
        Queue<Integer> bfsQueue = new LinkedList<>();
        // 시작 노드 큐에 삽입 & 방문 처리
        bfsQueue.offer(v);
        visit[v] = true;

        /*
         * while 반복 시작(큐가 비어있지 않으면 반복)
         * 1. 큐에서 제거
         * 2. 제거된 노드 탐색 기록 & 인접 노드 확인
         * 3. 해당 노드 방문한 적 없을 시 큐에 삽입 & 방문 기록
         */
        while (!bfsQueue.isEmpty()) {
            int n = bfsQueue.poll();
            sb.append(n).append(" ");
            for (int node : adjListArr[n]) {
                if (!visit[node]) {
                    bfsQueue.offer(node);
                    visit[node] = true;
                }
            }
        }
    }
}
