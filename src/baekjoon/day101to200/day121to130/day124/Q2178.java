package baekjoon.day101to200.day121to130.day124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 인접리스트를 생성하는 것이 아닌 이동 시에 이동할 수 있는 좌표를 확인한다.
 * 이동할 수 있는 경우는 4가지로 한정되어있으므로 배열로 생성하여 처리한다.
 */
public class Q2178 {
    static boolean[][] maze;
    static boolean[][] visit;
    static int[][] count;

    static int N;

    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 미로 배열 저장
        maze = new boolean[N + 2][M + 2]; // 첫번쨰 줄과 마지막 줄까지 고려하여 +2로 진행
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == '1') {
                    maze[i+1][j+1] = true;
                }
            }
        }

        count = new int[N + 1][M + 1];
        // 방문 배열 생성
        visit = new boolean[N + 1][M + 1];

        // (1,1)부터 시작
        BFS(1, 1);
    }

    public static int BFS(int row, int column) {

        Queue<int[]> queue = new LinkedList<>();
        // 큐에 추가
        queue.offer(new int[]{row, column});

        // 방문 처리
        visit[row][column] = true;

        // 방문칸 수 저장
        count[row][column] = 1;

        // 한 칸에서 가능한 좌표가 변화할 수 있는 경우의 수
        int[] dRow = {0, 1, 0, -1};
        int[] dColumn = {1, 0, -1, 0};

        // 큐 탐색
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowRow = now[0];
            int nowColumn = now[1];
            if (nowRow == N && nowColumn == M) {
                System.out.println(count[nowRow][nowColumn]);
            }

            for (int i = 0; i < 4; i++) {
                int afterRow = nowRow + dRow[i];
                int afterColumn = nowColumn + dColumn[i];
                if (maze[afterRow][afterColumn] && !visit[afterRow][afterColumn]) {
                    // 길이 있고 방문한 적이 없을 경우
                    visit[afterRow][afterColumn] = true;
                    count[afterRow][afterColumn] = count[nowRow][nowColumn] + 1;
                    queue.offer(new int[]{afterRow, afterColumn});
                }
            }
        }

        return 0; // 방문할 수 없는 경우는 없다.
    }
}
