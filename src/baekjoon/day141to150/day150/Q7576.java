package baekjoon.day141to150.day150;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  개선 사항
 *  토마토가 모두 익지 못하는 상황
 *  마지막에 모든 토마토 확인 -> 안익은 토마토 개수 처음에 확인 후 익을 때 마다 감소시켜 확인으로 개선
 */
public class Q7576 {

  static int N; // 세로 y
  static int M; // 가로 x
  static int[][] tomatoArr;
  static boolean[][] visit;
  static int result;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  static List<Tomato> ripeTomatoArr; // 익은 토마토 리스트
  static int unripeTomato; // 안익은 토마토 개수

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    tomatoArr = new int[N][M];
    visit = new boolean[N][M];
    ripeTomatoArr = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int block = Integer.parseInt(st.nextToken());
        tomatoArr[i][j] = block;
        if (block == 1) {
          ripeTomatoArr.add(new Tomato(i, j, 0));
        } else if (block == 0) {
          unripeTomato++;
        }

      }
    }

    // 탐색 진행
    BFS();

    System.out.println(unripeTomato > 0 ? -1 : result);
  }

  public static void BFS() {
    Queue<Tomato> queue = new LinkedList<>();
    // 익어있는 토마토가 주변 토마토를 익히는 과정을 동시에 진행한다.l
    for (Tomato start : ripeTomatoArr) {
      queue.add(start);
      visit[start.y][start.x] = true;
    }
    while (!queue.isEmpty()) {
      Tomato check = queue.poll();
      for (int i = 0; i < 4; i++) {
        int y = check.y + dy[i];
        int x = check.x + dx[i];
        if (x >= 0 && x < M && y >= 0 && y < N) {
          if (!visit[y][x] && tomatoArr[y][x] == 0) {
            unripeTomato--;
            tomatoArr[y][x] = 1;
            visit[y][x] = true;
            result = Math.max(result, check.day + 1); // 최소 일수를 구하기 때문에 가장 마지막에 익은 일자를 저장한다.
            queue.offer(new Tomato(y, x, check.day + 1));
          }
        }
      }
    }
  }

  public static class Tomato {

    int x;
    int y;
    int day;

    public Tomato(int y, int x, int day) {
      this.x = x;
      this.y = y;
      this.day = day;
    }
  }
}
