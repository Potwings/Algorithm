package baekjoon.day1to100.day10to50.day46;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * 정수 B에 0보다 큰 정수인 N을 곱해 정수 A를 만들 수 있다면, A는 B의 배수이다.
 * 예:
 * 10은 5의 배수이다 (5*2 = 10)
 * 10은 10의 배수이다(10*1 = 10)
 * 6은 1의 배수이다(1*6 = 6)
 * 20은 1, 2, 4,5,10,20의 배수이다.
 * <p>
 * 다른 예:
 * 2와 5의 최소공배수는 10이고, 그 이유는 2와 5보다 작은 공배수가 없기 때문이다.
 * 10과 20의 최소공배수는 20이다.
 * 5와 3의 최소공배수는 15이다.
 * 당신은 두 수에 대하여 최소공배수를 구하는 프로그램을 작성 하는 것이 목표이다.
 * <p>
 * 입력
 * 한 줄에 두 정수 A와 B가 공백으로 분리되어 주어진다.
 * 50%의 입력 중 A와 B는 1000(103)보다 작다. 다른 50%의 입력은 1000보다 크고 100000000(108)보다 작다.
 * 추가: 큰 수 입력에 대하여 변수를 64비트 정수로 선언하시오. C/C++에서는 long long int를 사용하고, Java에서는 long을 사용하시오.
 * <p>
 * 출력
 * A와 B의 최소공배수를 한 줄에 출력한다.
 */
public class Q13241 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        if (B > A) {
            long temp = A;
            A = B;
            B = temp;
        }
        long gcd = gcd(A, B);
        // 최소 공배수는 두수의 합을 최대 공약수로 나눈 것이다.
        long result = A * B / gcd;

        System.out.println(result);
    }

    public static long gcd(long A, long B) {

        long r = A % B;

        if (r == 0) {
            return B;
        }

        while (B % r > 0) {
            long temp = B % r;
            B = r;
            r = temp;
        }

        return r;
    }
}
