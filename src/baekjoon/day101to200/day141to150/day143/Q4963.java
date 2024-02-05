package baekjoon.day101to200.day141to150.day143;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q4963 {

    static int X;
    static int Y;
    static boolean[][] map;
    static boolean[][] checked;

    static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while (true) {
            input = br.readLine();
            if (input.equals("0 0")) {
                break;
            }
            st = new StringTokenizer(input);
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            map = new boolean[Y][X];
            checked = new boolean[Y][X];

            // 지도 배열 저장
            for (int i = 0; i < Y; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < X; j++) {
                    if (st.nextToken().equals("1")) {
                        map[i][j] = true;
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    // 확인한 적이 없고 땅일 경우 탐색
                    if (!checked[i][j] && map[i][j]) {
                        BFS(new int[]{i, j}); // 하나의 탐색에서 확인한 땅은 하나의 섬이다.
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static void BFS(int[] point) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(point);
        checked[point[0]][point[1]] = true;

        while (!queue.isEmpty()) {
            int[] checkPoint = queue.poll();
            for (int i = 0; i < 8; i++) {
                int y = checkPoint[0] + dy[i];
                int x = checkPoint[1] + dx[i];
                if (x >= 0 && x < X && y >= 0 && y < Y && !checked[y][x] && map[y][x]) {
                    queue.offer(new int[]{y, x});
                    checked[y][x] = true;
                }
            }
        }
    }
}
