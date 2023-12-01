package baekjoon.day138;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 개선 사항
 * 지렁이 배열을 제거 후 밭 배열에서 처리 완료된 배추를 제거
 */
public class Q1012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        boolean[][] fields;
        boolean[][] bugs;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<int[]> baechuList = new ArrayList<>();
            fields = new boolean[N][M];
            int count = 0; // 벌레 수

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                baechuList.add(new int[]{y, x});
                fields[y][x] = true; // 배추 심기
            }

            for (int[] baechu : baechuList) {
                if (fields[baechu[0]][baechu[1]]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(baechu);
                    fields[baechu[0]][baechu[1]] = false;
                    count++;
                    while (!queue.isEmpty()) {
                        baechu = queue.poll();
                        for (int l = 0; l < 4; l++) {
                            int y = baechu[0] + dy[l];
                            int x = baechu[1] + dx[l];
                            if (y >= 0 && x >= 0 && y < N && x < M) {
                                if (fields[y][x]) {
                                    queue.offer(new int[]{y, x});
                                    fields[y][x] = false;
                                }
                            }
                        }

                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

}