package baekjoon.day35;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문제
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다.
 * 이 수는 10,000보다 작거나 같은 자연수이다.
 * <p>
 * 출력
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */
public class Q10989 {

    // 문제에서 힌트로 제시한 카운팅 정렬을 이용한 풀이
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] countArr = new int[10001];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            countArr[num]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < countArr.length; i++) {
            int count = countArr[i];
            for (int j = 0; j < count; j++) {
                // 해당 인덱스의 값이 존재하는 개수만큼 결과값에 추가
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    // 자바 내장 정렬을 이용한 풀이
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] nums = new int[N];
//        for (int i = 0; i < N; i++) {
//            nums[i] = Integer.parseInt(br.readLine());
//        }
//        Arrays.sort(nums);
//
//        StringBuilder sb = new StringBuilder();
//        for (int num : nums) {
//            sb.append(num).append("\n");
//        }
//        System.out.println(sb.toString());
//    }
}
