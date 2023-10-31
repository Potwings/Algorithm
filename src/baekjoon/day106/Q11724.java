package baekjoon.day106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 방향이 없는 그래프인데 양방향으로 고려하지 않음
 * DFS 메소드에서 해당 노드를 이미 방문하였을 경우 return하도록 하여 불필요한 반복 줄임
 * -> 애초에 DFS 메소드가 실행되는 경우가 방문한 적이 없는 경우만이므로 확인할 필요없음
 * DFS 메소드 실행 시 해당 노드 방문 바로 체크하도록 수정(시작 지점 방문 체크하지 않음)
 * -> 이번 문제는 양방향이라 문제가 안되었으나 다른 문제에서는 문제가 될 수 있음
 * 리스트 리스트 -> 리스트 배열로 수정
 */
public class Q11724 {

    static ArrayList<Integer>[] adjListArr;
    static boolean[] visitArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjListArr = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adjListArr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            adjListArr[node1].add(node2);
            adjListArr[node2].add(node1);
        }

        visitArr = new boolean[N + 1];
        int result = 0;
        for (int j = 1; j <= N; j++) {
            if (!visitArr[j]) {
                result++;
                DFS(j);
            }
        }
        System.out.println(result);
    }

    public static void DFS(int num) {
        visitArr[num] = true;
        for (int point : adjListArr[num]) {
            if (!visitArr[point]) {
                DFS(point);
            }
        }
    }
}
