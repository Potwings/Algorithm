package baekjoon.day51;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * 분수 A/B는 분자가 A, 분모가 B인 분수를 의미한다. A와 B는 모두 자연수라고 하자.
 * 두 분수의 합 또한 분수로 표현할 수 있다. 두 분수가 주어졌을 때, 그 합을 기약분수의 형태로 구하는 프로그램을 작성하시오.
 * 기약분수란 더 이상 약분되지 않는 분수를 의미한다.
 * <p>
 * 입력
 * 첫째 줄과 둘째 줄에, 각 분수의 분자와 분모를 뜻하는 두 개의 자연수가 순서대로 주어진다. 입력되는 네 자연수는 모두 30,000 이하이다.
 * <p>
 * 출력
 * 첫째 줄에 구하고자 하는 기약분수의 분자와 분모를 뜻하는 두 개의 자연수를 빈 칸을 사이에 두고 순서대로 출력한다.
 */

/**
 * 개선 사항
 * 처음 입력 시 분자와 분모 입력받는 순서 헷갈림... 문.제.잘.읽.기 제발.....
 *
 * 어차피 나중에 최대 공약수로 약분을 진행하므로
 * 처음에 분수 합 계산 시 분자를 num1 * den2 + num2 * den1 분모를 den * den2로 진행해도 된다.
 */
public class Q1735 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int den1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int num2 = Integer.parseInt(st.nextToken());
        int den2 = Integer.parseInt(st.nextToken());

        // 두 분수의 합을 구한 후 최대 공약수로 약분을 진행하여 기약 분수를 만든다.

        // 두 분모의 최소공배수를 구하여 통분 후 계산을 진행한다.
        if (den2 > den1) {
            // 유클리드 호제법을 위한 대소비교하여 정렬
            // 분모
            int temp = den1;
            den1 = den2;
            den2 = temp;
            //분자
            temp = num1;
            num1 = num2;
            num2 = temp;
        }

        // 분수 합 결과
        int denGCD = gcd(den1, den2); // 분모의 최대공약수
        int sumDen = den1 * den2 / denGCD; // 분모의 최소공배수 계산
        int sumNum = num1 * (den2 / denGCD) + num2 * (den1 / denGCD); // 통분을 위해 분모에 곱한 값을 분자에도 곱해준다.

        // 분수 합 기약 분수가 되도록 약분
        int a = sumNum;
        int b = sumDen;
        if (sumDen > sumNum) {
            a = sumDen;
            b = sumNum;
        }

        int numDenGCD = gcd(a, b);

        StringBuilder sb = new StringBuilder();
        sb.append(sumNum / numDenGCD).append(" ").append(sumDen / numDenGCD);
        System.out.println(sb.toString());
    }

    public static int gcd(int A, int B) {

        int r = A % B;

        if (r == 0) {
            return B;
        }
        return gcd(B, r);
    }
}
