package baekjoon.day158;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q10026 {

  static char[][] normalGrid; // 그리드 배열 선언
  static char[][] colorBlindGrid; // 색약 그리드 배열 선언
  static boolean[][] normalVisit;// 방문 배열 선언
  static boolean[][] colorBlindVisit; // 색약 방문 배열 선언

  static int N;// 한변의 길이 N 선언

  // dx,dy(x축 y축 이동 범위) 선언
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine()); // N값 저장
    normalVisit = new boolean[N][N];// 방문 배열 생성
    colorBlindVisit = new boolean[N][N];// 색약 방문 배열 생성
    normalGrid = new char[N][N];// 그리드 배열 생성
    colorBlindGrid = new char[N][N];// 색약 그리드 배열 생성

    // 그리드 배열 값 입력 받아 저장
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        char block = line.charAt(j);
        normalGrid[i][j] = block;
        colorBlindGrid[i][j] = block == 'G' ? 'R' : block; // 색약의 경우 G도 R로 저장
      }
    }

    int normalCount = 0;// 일반인 count 선언
    int colorBlindCount = 0;// 색약자 count 선언

    // for loop 진행
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        // 방문하지 않은 좌표에 대해 탐색 -> 탐색할 경우 count 증가
        if (!normalVisit[j][i]) {
          BFS(j, i, normalGrid, normalVisit);
          normalCount++;
        }

        // 방문하지 않은 좌표에 대해 색약자 탐색 -> 탐색할 경우 count 증가
        if (!colorBlindVisit[j][i]) {
          BFS(j, i, colorBlindGrid, colorBlindVisit);
          colorBlindCount++;
        }
      }
    }

    // 결과 출력
    StringBuilder sb = new StringBuilder();
    sb.append(normalCount).append(" ").append(colorBlindCount);
    System.out.println(sb);
  }

  // BFS 메소드
  private static void BFS(int startY, int startX, char[][] grid, boolean[][] visit) {
    // 큐 생성
    Queue<int[]> queue = new LinkedList<>();
    // 큐에 시작점 삽입
    queue.offer(new int[]{startY, startX});
    // 시작점 방문 처리
    visit[startY][startX] = true;

    // 큐가 비어있지 않을 경우 while loop 시작
    while (!queue.isEmpty()) {
      // 큐에서 좌표 값 추출
      int[] point = queue.poll();
      char now = grid[point[0]][point[1]];
      // 해당 좌표값 기준으로 이동가능 범위 판단 하여 for loop 진행
      for (int i = 0; i < 4; i++) {
        int y = point[0] + dy[i];
        int x = point[1] + dx[i];
        // 좌표가 그리드 범위 내일 경우 탐색 진행
        if (x >= 0 && x < N && y >= 0 && y < N) {
          if (!visit[y][x] && grid[y][x] == now) {
            // 방문한 적이 없고 자신의 색상과 동일할 경우 큐에 추가
            visit[y][x] = true;
            queue.offer(new int[]{y, x});
          }
        }
      }
    }
  }

}
