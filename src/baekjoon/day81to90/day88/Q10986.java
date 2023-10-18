package baekjoon.day81to90.day88;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 같은 자료형끼리 계산하였을 경우 계산 결과는 이미 해당 자료형으로 생성되어 다른 변수에 담아도 정상적인 결과가 저장이 안된다.
 * long result = int * int -> 이미 결과값이 int로 생성되어 오버플로우가 발생한다.
 * 따라서 result에서 remainCount[i]를 long으로 캐스팅해주면 정상적으로 동작한다.
 * /2L을 우선적으로 하여 형변환을 시도하였으나 그럴 경우 remainCount[i]가 홀수일 경우 나머지가 버려져서 계산이 잘못된다.
 *
 * 정수의 범위 잘 확인하자
 * 아니면 처음부터 long으로 생성하자
 */
public class Q10986 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] remainCount = new int[M];
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            remainCount[(int) (sum % M)]++;
        }

        long result = remainCount[0];
        for (int i = 0; i < M; i++) {
            result += remainCount[i] * (long)(remainCount[i] - 1) / 2;
        }

        System.out.println(result);
    }
}
