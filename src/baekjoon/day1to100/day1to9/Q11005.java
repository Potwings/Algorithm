package baekjoon.day1to100.day1to9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * 10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
 * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
 * A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
 */

public class Q11005 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 입력 받은 십진법 수
        int B = Integer.parseInt(st.nextToken()); // 몇 진법으로 변환할 지
        StringBuilder builder = new StringBuilder();

        do {
            int alpha = 55; // 10이상의 숫자들은 55를 더하면 알파벳 대문자의 char값이 된다.
            int remainder = (int) (N % B);
            // 삼항 연산자로 진행하려했으나 둘의 데이터 타입이 다른데 같은 메소드(파라미터 int로 인식)를 호출하여 if문으로 진행
            if (remainder < 10) {
                builder.append(remainder);
            } else {
                builder.append((char) (alpha + remainder)); // 나머지 값은 해당 자리의 값이 된다. 10보다 클 경우 알파벳으로 표현
            }
        } while ((N /= B) > 0); // 몫을 다시 나누어 주고 반복하여 나머지를 다음 자리의 값에 넣어준다.

        System.out.println(builder.reverse().toString()); // 먼저 나온 나머지가 작은 수이므로 역순으로 정렬
    }
}
