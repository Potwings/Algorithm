package baekjoon.day101to200.day151to160.day151;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 탐색 전에 익힐 토마토가 없을 경우 탐색 진행하지 않도록 수정
 * 더 이상 익힐 토마토가 없을 경우 탐색 중단하는 조건문 추가
 * 토마토 배열에 날짜값을 저장하여 해당일자에 익은 토마토 개수 따로 관리할 필요 없도록 수정
 */
public class Q7569 {

  static int H; // 높이
  static int N; // 세로
  static int M; // 가로
  static int[][][] tomatoArr;
  static boolean[][][] visit;
  static int unripeTomato;
  static List<Tomato> ripeTomatoList;

  static int result;

  static int[] dz = {1, -1, 0, 0, 0, 0};
  static int[] dy = {0, 0, 1, -1, 0, 0};
  static int[] dx = {0, 0, 0, 0, 1, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()); // M,N,H 순으로 주어짐
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    ripeTomatoList = new ArrayList<>();
    visit = new boolean[H][N][M];
    tomatoArr = new int[H][N][M];
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < M; k++) {
          int block = Integer.parseInt(st.nextToken());
          tomatoArr[i][j][k] = block;
          if (block == 1) {
            ripeTomatoList.add(new Tomato(i, j, k));
          } else if (block == 0) {
            unripeTomato++;
          }
        }
      }
    }

    if (unripeTomato > 0) {
      BFS();
    }

    System.out.println(unripeTomato > 0 ? -1 : result);
  }

  public static void BFS() {
    Queue<Tomato> queue = new LinkedList<>();
    for (Tomato riped : ripeTomatoList) {
      queue.offer(riped);
      visit[riped.z][riped.y][riped.x] = true;
    }

    while (!queue.isEmpty()) {
      Tomato tomato = queue.poll();
      for (int j = 0; j < 6; j++) {
        int z = tomato.z + dz[j];
        int y = tomato.y + dy[j];
        int x = tomato.x + dx[j];

        if (x >= 0 && x < M && y >= 0 && y < N && z >= 0 && z < H) {
          if (!visit[z][y][x] && tomatoArr[z][y][x] == 0) {
            queue.offer(new Tomato(z, y, x));
            visit[z][y][x] = true;
            tomatoArr[z][y][x] = tomatoArr[tomato.z][tomato.y][tomato.x] + 1; // 해당 토마토가 익은 일자 + 1 (익은 토마토는 1부터 시작하기 때문)
            result = tomatoArr[z][y][x] - 1; // 가장 마지막으로 토마토가 익은 일자
            if (--unripeTomato == 0) {
              // 더 이상 익힐 토마토가 없을 경우 중단
              queue.clear();
              break;
            }
          }
        }
      }
    }
  }

  public static class Tomato {

    int z;
    int y;
    int x;

    public Tomato(int z, int y, int x) {
      this.z = z;
      this.y = y;
      this.x = x;
    }
  }
}