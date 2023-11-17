package baekjoon.day124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q2178 {
    static List<Position>[][] adjPositionListArr;

    static boolean[][] visit;

    static int N;

    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 미로 배열 저장
        boolean[][] maze = new boolean[N + 2][M + 2]; // 마지막 인접리스트 검사까지 고려하여 + 2로 생성
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == '1') {
                    maze[i + 1][j + 1] = true;
                }
            }
        }
        // 방문 배열 생성
        visit = new boolean[N + 1][M + 1];
        // 인접 리스트 생성
        adjPositionListArr = new ArrayList[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                adjPositionListArr[i][j] = new ArrayList<Position>();
                if (maze[i + 1][j]) {
                    adjPositionListArr[i][j].add(new Position(i + 1, j));
                }
                if (maze[i][j + 1]) {
                    adjPositionListArr[i][j].add(new Position(i, j + 1));
                }
                if (maze[i - 1][j]) {
                    adjPositionListArr[i][j].add(new Position(i - 1, j));
                }
                if (maze[i][j - 1]) {
                    adjPositionListArr[i][j].add(new Position(i, j - 1));
                }
            }
        }

        // (1,1)부터 시작
        int result = BFS(new Position(1, 1));
        System.out.println(result);
    }

    public static int BFS(Position position) {

        Queue<Position> queue = new LinkedList<>();
        position.count = 1;
        // 큐에 추가
        queue.offer(position);
        // 방문 처리
        position.changeVisit();

        // 큐 탐색
        while (!queue.isEmpty()) {
            Position p = queue.poll();
            if (p.isEndPoint()) {
                return p.count;
            }
            for (Position adjPosition : p.getAdjPositionList()) {
                if (!adjPosition.isVisit()) {
                    // 방문한 적 없을 경우 count 증가 후 큐에 추가
                    adjPosition.count = p.count + 1;
                    adjPosition.changeVisit();
                    queue.offer(adjPosition);
                }
            }
        }

        return 0; // 방문할 수 없는 경우는 없다.
    }

    public static class Position {
        int row;

        int column;

        int count; // 현재까지 이동한 칸 수

        public void changeVisit() {
            visit[row][column] = true;
        }

        public boolean isEndPoint() {
            return row == N && column == M;
        }

        public boolean isVisit() {
            return visit[row][column];
        }

        public List<Position> getAdjPositionList() {
            return adjPositionListArr[row][column];
        }

        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "row=" + row +
                    ", column=" + column +
                    ", count=" + count +
                    '}';
        }
    }
}
