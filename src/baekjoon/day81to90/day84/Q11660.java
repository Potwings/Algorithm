package baekjoon.day81to90.day84;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 우선 각 좌표의 (0,0)에서의 부터의 구간합을 구해하여 배열로 정리해둔다.
 * 그 후 (x2,y2)까지 합에서 (x2,y1-1)까지의 값과 (x1-1,y2)까지의 값을 빼준 후
 * (x1-1,y1-1)의 값을 합해주면 된다.(빼줄때 중복 되는 부분)
 * <p>
 * 만일 x1 또는 y1이 0일 경우
 * x1이 0일 경우 (x2, y1-1)까지의 합만 빼주면 되고
 * y1이 0일 경우 (x1-1, y2)까지의 합만 빼주면 된다.
 */

/*
 * 개선 사항
 * xy는 일반적인 x좌표 y좌표가 아닌 x행의 y좌표이다
 */
public class Q11660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] sumBoard = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                sumBoard[i][j] = Integer.parseInt(st.nextToken()) + sumBoard[i - 1][j] + sumBoard[i][j - 1] - sumBoard[i - 1][j - 1];
            }
        }

        int x1, y1, x2, y2 = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            sb.append(sumBoard[x2][y2] + sumBoard[x1 - 1][y1 - 1] - sumBoard[x1 - 1][y2] - sumBoard[x2][y1 - 1])
                    .append("\n");
        }

        System.out.println(sb);
    }

}
