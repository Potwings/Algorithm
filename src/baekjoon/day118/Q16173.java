package baekjoon.day118;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 0일 경우 확인하지 않음
 * 만일 방문배열을 사용했다면 0인 경우를 확인하지 않아도 됐다.
 */
public class Q16173 {

    static int N;
    static int[][] board;
    static boolean[][] visit;
    static boolean success;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];
        StringTokenizer st = null;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색 시작
        DFS(1, 1);

        System.out.println(success ? "HaruHaru" : "Hing");
    }

    public static void DFS(int row, int column) {
        if (row > N || column > N) {
            // 구역을 벗어났거난 경우 중단
            return;
        }

        if (success || visit[row][column]) {
            // 이미 성공하였거나 방문했던 적이 있는 경우 중단
            return;
        }

        int num = board[row][column];
        visit[row][column] = true;

        if (num == -1) {
            // 성공 지점에 도착한 경우 success
            success = true;
            return;
        }

        // 해당 칸의 숫자만큼 우측으로 이동하는 경우, 하단으로 이동하는 경우 모두 확인
        DFS(row + num, column);
        DFS(row, column + num);
    }
}
