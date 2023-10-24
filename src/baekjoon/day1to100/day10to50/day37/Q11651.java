package baekjoon.day1to100.day10to50.day37;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제
 * 2차원 평면 위의 점 N개가 주어진다.
 * 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
 * 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
 * (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
 * <p>
 * 출력
 * 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 */
public class Q11651 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] pointArr = new int[N][2];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pointArr[i][0] = Integer.parseInt(st.nextToken());
            pointArr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 배열의 두번째 값을 우선으로 비교 후 같을 경우 첫번째 값을 활용하여 비교 진행
        Arrays.sort(pointArr, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        StringBuilder sb = new StringBuilder();
        for (int[] point : pointArr) {
            sb.append(point[0]).append(" ").append(point[1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
