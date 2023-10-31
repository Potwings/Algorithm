package baekjoon.day108;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 자연수가 5개 주어진다는 내용을 놓쳐서 List로 진행하였어서 배열로 변경
 * num의 최소값을 숫자 배열의 최소값으로 진행하면 반복 줄일 수 있다.
 */
public class Q1145 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numArr = new int[5];
        for (int i = 0; i < 5; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int num = Arrays.stream(numArr).min().getAsInt();
        int count = 0;
        while (true) {
            for (int i = 0; i < 5; i++) {
                if (num % numArr[i] == 0) {
                    count++;
                    if (count == 3) {
                        System.out.println(num);
                        return;
                    }
                }
            }
            // count 초기화 & num 증가하여 다시 진행
            count = 0;
            num++;
        }


    }
}
