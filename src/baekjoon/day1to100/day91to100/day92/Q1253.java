package baekjoon.day1to100.day91to100.day92;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 특정 수의 합을 찾을 때 가장 큰 수와 가장 작은 수를 합한 후
 * 합을 감소시킬 경우 큰 수를 줄이고
 * 합을 증가시킬 경우 작은 수를 줄인다.
 * <p>
 * 개선 사항
 * 배열의 첫번째, 마지막 수가 자기 자신일 경우를 확인하지 않음
 * 같은 값의 수여도 인덱스가 다를 경우 다른 수로 취급하는 부분을 고려하지 않음
 * 합의 대상이 되는 수가 자기 자신인지 확인하는 것은 좋은 수로 판정되었을 경우만 판단하면 된다.
 */
public class Q1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);

        int count = 0;
        for (int i = 0; i < N; i++) {

            int smallIdx = 0;
            int largeIdx = N - 1;
            int targetNum = numArr[i];

            // 인덱스 변경은 한번에 하나만 일어나므로 같은 경우가 무조건 발생한다. 따라서 같지 않을 경우만 반복
            while (smallIdx != largeIdx) {
                int sum = numArr[smallIdx] + numArr[largeIdx];
                if (sum > targetNum) {
                    largeIdx--;
                } else if (sum < targetNum) {
                    smallIdx++;
                } else {
                    if (smallIdx != i && largeIdx != i) {
                        count++;
                        break;
                    } else if (smallIdx == i) {
                        smallIdx++;
                    } else {
                        largeIdx--;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
