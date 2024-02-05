package baekjoon.day101to200.day141to150.day148;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q2667 {

  // 정사각형 한변의 길이
  static int N;

  // 집 배열 선언
  static boolean[][] houseArr;

  // 방문 배열 선언
  static boolean[][] visitArr;

  // 상하좌우 이동 가능 영역 배열 생성(dx, dy)
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    // 집 배열 생성
    houseArr = new boolean[N][N];
    // 방문 배열 생성
    visitArr = new boolean[N][N];
    // 단지 count 리스트 생성
    List<Integer> houseCountList = new ArrayList<>();

    // 입력받은 집 배열 저장
    char[] input = null;
    for (int i = 0; i < N; i++) {
      input = br.readLine().toCharArray();
      for (int j = 0; j < N; j++) {
        if (input[j] == '1') {
          houseArr[i][j] = true;
        }
      }
    }

    int complexCount = 0; // 단지 수
    // for loop 진행하며 집이 있고 방문하지 않은 경우 BFS 탐색 시작
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (houseArr[j][i] && !visitArr[j][i]) {
          // BFS 진행 후 결과값 단지 count 리스트에 저장
          int count = BFS(new int[]{j, i});
          houseCountList.add(count);
          complexCount++;
        }
      }
    }
    // 단지 count 리스트 정렬
    Collections.sort(houseCountList);
    // 단지 count 리스트 출력
    StringBuilder sb = new StringBuilder();
    sb.append(complexCount).append("\n"); // 단지 수 출력
    for (int houseCount : houseCountList) {
      sb.append(houseCount).append("\n");
    }
    System.out.println(sb);
  }

  public static int BFS(int[] startHouse) {
    // 큐 선언
    Queue<int[]> queue = new LinkedList<>();
    // 탐색 시작 집 방문처리
    visitArr[startHouse[0]][startHouse[1]] = true;

    // 탐색 시작 집 큐에 삽입
    queue.offer(startHouse);
    // count 1부터 시작
    int count = 1;

// 큐가 비어있지 않는 조건으로 while loop 진행
    while (!queue.isEmpty()) {
      // 큐에서 집 추출
      int[] house = queue.poll();
      // 해당 집의 인접 집 확인 dx, dy 이용하여 for loop 진행
      for (int i = 0; i < 4; i++) {
        int y = house[0] + dy[i];
        int x = house[1] + dx[i];
        // 탐색할 좌표가 유효해야함 x >= 0 && y >= 0 && x < N && y <N
        if (x >= 0 && y >= 0 && x < N && y < N) {
          // 탐색할 좌표가 방문한 적이 없고(!visit[]) 집이 있어야(house[]) 한다.
          if (!visitArr[y][x] && houseArr[y][x]) {
            // 위의 조건에 부합할 경우 방문 처리 count++ 후 queue에 삽입
            queue.offer(new int[]{y, x});
            visitArr[y][x] = true;
            count++;
          }
        }
      }
    }

    // 마지막에 count return
    return count;
  }
}
