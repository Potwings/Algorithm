package baekjoon.day101to200.day121to130.day125;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 중간값은 이미 확인을 완료하였음으로 중간값 + 1 또는 -1을 하여 다음 연산을 진행한다.
 * 존재여부만 확인하므로 boolean값 추가하여 해당 값으로 결과 추가
 */
public class Q1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 기준 배열 길이 저장 N
        int N = Integer.parseInt(br.readLine());
        // 기준 배열 생성 후
        long[] numArr = new long[N];
        // 기준 배열 값 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Long.parseLong(st.nextToken());
        }
        // 기준 배열 오름차순으로 정렬
        Arrays.sort(numArr);

        // 확인 배열 길이 저장 M
        int M = Integer.parseInt(br.readLine());
        // 확인 배열 생성
        long[] checkArr = new long[M];
        // 확인 배열값 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            checkArr[i] = Long.parseLong(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        // 확인배열 반복 진행
        for (long checkNum : checkArr) {
            // 기준 배열 시작 값 끝나는 값 저장
            int start = 0;
            int end = N - 1;
            // 최대값보다 크거나 최소값보다 작을 경우 탐색 진행하지 않는다.
            if (checkNum > numArr[end] || checkNum < numArr[start]) {
                sb.append(0).append("\n");
                continue;
            }
            int midIdx = (start + end) / 2;
            boolean exist = false;
            while (start <= end) {
                if (numArr[midIdx] > checkNum) {
                    // 확인값이 중앙값보다 작을 경우 시작 값 유지, 끝나는 값 중앙값-1로 변경
                    end = midIdx - 1;
                } else if (numArr[midIdx] < checkNum) {
                    // 확인값이 중앙값보다 클 경우 끝나는 값 유지 시작 값 중앙값+1으로 변경
                    start = midIdx + 1;
                } else {
                    // 결과값이 중앙값과 같을 경우
                    exist = true;
                    break;
                }
                midIdx = (start + end) / 2;
            }
            sb.append(exist ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }

}
