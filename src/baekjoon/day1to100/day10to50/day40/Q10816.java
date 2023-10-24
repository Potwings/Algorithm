package baekjoon.day1to100.day10to50.day40;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 문제
 * 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
 * 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
 * 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
 * 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다.
 * 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다.
 * 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
 * <p>
 * 출력
 * 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.
 */

/**
 * 개선 사항
 * 개수를 확인할 정수가 동일한 값이 들어있을 경우를 생각하지 않았다.
 * Map으로 처리할 경우 Key에 동일한 값이 여러개 들어갈 수 없어 문제가 발생한다.
 * 결과값 처리를 위한 별도의 배열을 추가해주었다.
 *
 * 처음에 카드의 개수를 Map에 저장한 후
 * M 정수 값을 읽어올 때 비교하면 for loop(결과값 처리를 위한 배열 생성 과정)를 한 번 더 줄일 수 있다.
 *
 * 범위가 정해져있고 개수를 확인하는 문제이니 카운팅 정렬의 카운팅 방식으로 카운팅도 가능
 */
public class Q10816 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> cardMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            Integer cardNum = Integer.parseInt(st.nextToken());
            Integer count = cardMap.get(cardNum);
            if (count == null) {
                // Map에 없으면 추가
                cardMap.put(cardNum, 1);
            } else {
                // Map에 있을 경우 +1
                cardMap.put(cardNum, count + 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            Integer count = cardMap.get(Integer.parseInt(st.nextToken()));
            sb.append(count == null ? 0 : count).append(" ");
        }

        System.out.println(sb.toString());
    }
}