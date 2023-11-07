package baekjoon.day101to110.day101.day102;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1075 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        int temp = N / 100 * 100; // 뒤의 두자리 0으로 초기화
        int remain = temp % F; // 뒤의 두자리 제외한 나머지 확인

        int result = 0;
        // 나누어떨어질 경우 결과는 0이다.
        if (remain > 0) {
            // F로 나누어 떨어지게하기 위해서 나머지와 F의 차를 확인 후 끝자리에 넣어주면 된다.
            result = F - remain;
        }
        System.out.printf("%02d%n", result); // 한자리수일 경우 십의 자리에 0 추가하여 출력
    }
}
