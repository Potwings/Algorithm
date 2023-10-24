package baekjoon.day1to100.day1to9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2738 {

    /**
     * 문제
     * 첫째 줄에 행렬의 크기 N 과 M이 주어진다.
     * 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다.
     * 이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다.
     * N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.
     */

    /**
     * 개선 사항
     * 1. 결과값을 구현하는 과정에서 대부분의 사람들이 StringBuilder를 이욯하더라
     * -> StringBuffer를 이용하여 마지막에 System.out.print를 통하여 출력하면 BufferedWriter와 동일하게 한 번에 출력 가능
     * 2. 입력값에서 두번째 배열을 변수로 저장할 필요가 없었다.
     * -> 두번째 for문 동작 시 바로 첫번째 배열의 값과 합쳐서 출력값을 준비하면 된다.
     */


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());


        int[][] inputArr1 = new int[row][column];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                inputArr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                sb.append(inputArr1[i][j] + Integer.parseInt(st.nextToken()) + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
