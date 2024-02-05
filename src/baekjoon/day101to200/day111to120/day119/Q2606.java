package baekjoon.day101to200.day111to120.day119;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2606 {
    // 감염된 컴퓨터 대수 선언 1번 컴퓨터는 제외해야 한다.
    static int count;

    // 총 피시 대수 선언
    static int N;

    // 총 네트워크 연결 정보 선언
    static ArrayList<Integer>[] networkArr;

    // 방문여부 저장한 배열 선언
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 총 피시 수 입력 받음
        N = Integer.parseInt(br.readLine());

        // 네트워크 연결 수
        int M = Integer.parseInt(br.readLine());

        // 네트워크 관계 저장한 ArrayList배열 값 저장
        networkArr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            networkArr[i] = new ArrayList<>();
        }
        StringTokenizer st = null;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            // 양방향 연결이므로 양쪽 모두에 저장
            networkArr[v1].add(v2);
            networkArr[v2].add(v1);
        }

        //
        visit = new boolean[N + 1];

        // 1번 컴퓨터부터 탐색 시작 -> DFS 메소드 실행
        DFS(1);

        // 총 감염 컴퓨터 대수 출력
        System.out.println(count);
    }

    public static void DFS(int comNum) {

        // 해당 컴퓨터 방문여부 변경
        visit[comNum] = true;

        // 해당 컴퓨터의 네트워크 확인 후 방문하지 않은 경우 연결 진행
        for (int otherComNum : networkArr[comNum]) {
            if(!visit[otherComNum]) {
                // 감염된 컴퓨터 대수 증가
                count++;
                DFS(otherComNum);
            }
        }
    }
}
