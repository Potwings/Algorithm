package baekjoon.day1to100.day10to50.day20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * 영학이는 딸기우유, 초코우유, 바나나우유를 좋아한다.
 * 입맛이 매우 까다로운 영학이는 자신만의 우유를 마시는 규칙이 있다.
 * 맨 처음에는 딸기우유를 한 팩 마신다.
 * 딸기우유를 한 팩 마신 후에는 초코우유를 한 팩 마신다.
 * 초코우유를 한 팩 마신 후에는 바나나우유를 한 팩 마신다.
 * 바나나우유를 한 팩 마신 후에는 딸기우유를 한 팩 마신다.
 * 영학이는 우유 축제가 열리고 있는 우유거리에 왔다. 우유 거리에는 우유 가게들이 일렬로 늘어서 있다.
 * 영학이는 우유 거리의 시작부터 끝까지 걸으면서 우유를 사먹고자 한다.
 * 각각의 우유 가게는 딸기, 초코, 바나나 중 한 종류의 우유만을 취급한다.
 * 각각의 우유 가게 앞에서, 영학이는 우유를 사마시거나, 사마시지 않는다.
 * 우유거리에는 사람이 많기 때문에 한 번 지나친 우유 가게에는 다시 갈 수 없다.
 * 영학이가 마실 수 있는 우유의 최대 개수를 구하여라.
 * <p>
 * 입력
 * 첫째 줄에 우유 가게의 수 N이 주어진다. (1 ≤ N ≤ 1000)
 * 둘째 줄에는 우유 가게 정보가 우유 거리의 시작부터 끝까지 순서대로 N개의 정수로 주어진다.
 * 0은 딸기우유만을 파는 가게, 1은 초코우유만을 파는 가게, 2는 바나나우유만을 파는 가게를 뜻하며, 0, 1, 2 외의 정수는 주어지지 않는다.
 * <p>
 * 출력
 * 영학이가 마실 수 있는 우유의 최대 개수를 출력하시오.
 */

/**
 * 개선 사항
 * 우유는 총 0,1,2으로 2까지 1씩 증가한다.
 * 1을 증가시킨 후 3으로 나눈 나머지를 확인하면 3이었을 경우 다시 0이 된다.
 * 이를 이용하여 불필요한 switch문을 제거할 수 있다.
 */
public class Q14720 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 딸기우유부터 먹는다
        int wantMilk = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            int store = Integer.parseInt(st.nextToken());

            if (store == wantMilk) {
                // 원하는 우유에 맞는 매장이 있을 경우 먹은 우유 횟수를 증가시킨다.
                result++;
                // 우유의 종류는 0,1,2로 2까지 1씩 증가하므로 3으로 나눈 나머지를 확인하여 3일 경우 다시 0이 되도록 해준다.
                wantMilk = (wantMilk + 1) % 3;
            }
        }

        System.out.println(result);
    }
}
