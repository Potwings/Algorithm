package baekjoon.day134;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1167 {

    static List<Node>[] adjList;

    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        // 인접 리스트 생성
        adjList = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 인접 리스트 값 저장
        StringTokenizer st = null;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = 0;
            while ((v2 = Integer.parseInt(st.nextToken())) != -1) {
                adjList[v1].add(new Node(v2, Long.parseLong(st.nextToken())));
            }
        }


        // 방문 배열 생성
        visit = new boolean[V + 1];
        // BFS를 통하여 임의의 노드(1)에서 가장 멀리있는 노드 확인(트리 지름의 한점)
        Node diameter1 = BFS(1);

        // 위에서 반환받은 노드는 지름의 한 점이므로 해당 노드에서 가장 멀리있는 노드 확인
        visit = new boolean[V + 1];
        Node result = BFS(diameter1.num);
        // BFS 메소드에서 계산한 가장 긴 거리 출력
        System.out.println(result.distance);
    }

    //BFS (방문처리 -> 값 변경 후 큐에 삽입)
    public static Node BFS(int startNum) {
        // 큐 생성
        Queue<Node> queue = new LinkedList<>();
        // 방문 처리
        visit[startNum] = true;
        // 큐에 삽입
        Node startNode = new Node(startNum, 0);
        queue.offer(startNode);

        Node maxNode = startNode; // 거리가 최대일 때 노드

        // 큐에 값이 있을 경우 반복
        while (!queue.isEmpty()) {
            // 큐에서 데이터 반환 후 해당 값 인접 리스트 확인
            Node v1 = queue.poll();
            if (v1.distance > maxNode.distance) {
                maxNode = v1;
            }
            for (Node v2 : adjList[v1.num]) {
                if (!visit[v2.num]) {
                    // 방문한 적 없을 경우
                    queue.offer(new Node(v2.num, v1.distance + v2.distance)); // 인접 리스트의 노드 queue에 삽입
                    visit[v2.num] = true;// 해당 노드 방문처리
                }
            }
        }

        return maxNode;
    }

    public static class Node {
        int num;
        long distance;

        public Node(int num, long distance) {
            this.num = num;
            this.distance = distance;
        }
    }

}
