package baekjoon.day10to50.day22;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * 666은 종말을 나타내는 수라고 한다. 따라서, 많은 블록버스터 영화에서는 666이 들어간 제목을 많이 사용한다. 영화감독 숌은 세상의 종말 이라는 시리즈 영화의 감독이다.
 * 조지 루카스는 스타워즈를 만들 때, 스타워즈 1, 스타워즈 2, 스타워즈 3, 스타워즈 4, 스타워즈 5, 스타워즈 6과 같이 이름을 지었고,
 * 피터 잭슨은 반지의 제왕을 만들 때, 반지의 제왕 1, 반지의 제왕 2, 반지의 제왕 3과 같이 영화 제목을 지었다.
 * 하지만 숌은 자신이 조지 루카스와 피터 잭슨을 뛰어넘는다는 것을 보여주기 위해서 영화 제목을 좀 다르게 만들기로 했다.
 * 종말의 수란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수를 말한다. 제일 작은 종말의 수는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, .... 이다.
 * 따라서, 숌은 첫 번째 영화의 제목은 "세상의 종말 666", 두 번째 영화의 제목은 "세상의 종말 1666"와 같이 이름을 지을 것이다.
 * 일반화해서 생각하면, N번째 영화의 제목은 세상의 종말 (N번째로 작은 종말의 수) 와 같다.
 * 숌이 만든 N번째 영화의 제목에 들어간 수를 출력하는 프로그램을 작성하시오. 숌은 이 시리즈를 항상 차례대로 만들고, 다른 영화는 만들지 않는다.
 * <p>
 * 입력
 * 첫째 줄에 N이 주어진다. N은 10,000보다 작거나 같은 자연수이다.
 * <p>
 * 출력
 * 첫째 줄에 N번째 영화의 제목에 들어간 수를 출력한다.
 */

/**
 * 개선 사항
 * 6이 3번 연속으로 나오는지 판단할 때 string으로 변환 후 contains로 판단하는 것보다
 * int 상태에서 10으로 나누었을 때 나머지가 3번 연속으로 6이 나오는지를 확인하면 성능이 더 좋다.
 */
public class Q1436 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int result = 666; // 첫번째 수인 666부터 시작
        // 666이 들어가는 수 중 N번째 숫자를 가져오면된다.
        while (true) {
            if (count == N) {
                // N번째일 경우 loop 중단
                break;
            }

            result++;

            int temp = result;
            int sixCount = 0;
            while (temp > 0) {

                // 해당 조건 확인하는 시간이나 루프 한 번 더 도는 시간이랑 비슷하다. 차라리 코드 길이와 메모리를 줄여주기 위해 조건을 하나 더 줄이자
                // if ((sixCount == 0 && temp < 100) || (sixCount == 1 && temp < 10)) {
                //     break;
                // }

                if (temp % 10 == 6) {
                    sixCount++;
                } else {
                    // 10으로 나눈 나머지가 6이 아닐 경우 다시 0부터 시작
                    sixCount = 0;
                }

                temp /= 10;

                if (sixCount == 3) {
                    // 10으로 나눈 나머지가 3번 연속 6일 경우 count 증가
                    count++;
                    break;
                }
            }

        }

        System.out.println(result);
    }
}
