package baekjoon.day101to200.day111to120.day117;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1388 {

    static int N;
    static int M;
    static char[][] charArr;
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        charArr = new char[N][M];
        visit = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            // 가로 블럭 개수 우선 확인
            String[] lineArr = input.split("\\|");
            for (String str : lineArr) {
                if (str.length() > 0) {
                    count++;
                }
            }
            for (int j = 0; j < M; j++) {
                charArr[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (charArr[i][j] == '|' && !visit[i][j]) {
                    count++;
                    DFS(i,j);
                }
            }
        }
        System.out.println(count);
    }

    public static void DFS(int i, int j) {
        visit[i][j] = true;
        i++;
        if(i == N) {
            // 마지막 줄일 경우 중단
            return;
        }
        if (charArr[i][j] == '|' && !visit[i][j]) {
            DFS(i, j);
        }
    }
}
