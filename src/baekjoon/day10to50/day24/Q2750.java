package baekjoon.day10to50.day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 *
 * 출력
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */

/**
 * 개선 사항
 * Arrays.sort를 이용하면 바로 정렬이 가능하지만 직접 로직은 구현해보았다.
 * 정렬 알고리즘 확인해볼 것
 */
public class Q2750 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        int[] resultArr = new int[N];
        for(int i = 0; i < N; i++){
            int count = 0;
            int compareNum = nums[i];
            for (int j = 0; j < N; j++){
                if(compareNum > nums[j]) {
                    // 배열의 다른 숫자들과 비교 후 더 작은 수의 개수를 count한다.
                    count++;
                }
            }
            // 앞에 더 작은수가 들어올 자리를 남긴 후 배열에 넣어준다.
            resultArr[count] = compareNum;
        }

        StringBuilder sb = new StringBuilder();
        for(int num : resultArr) {
           sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}
