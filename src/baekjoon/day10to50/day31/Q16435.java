package baekjoon.day10to50.day31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제
 * 스네이크버드는 뱀과 새의 모습을 닮은 귀여운 생물체입니다.
 * 스네이크버드의 주요 먹이는 과일이며 과일 하나를 먹으면 길이가 1만큼 늘어납니다.
 * 과일들은 지상으로부터 일정 높이를 두고 떨어져 있으며 i (1 ≤ i ≤ N) 번째 과일의 높이는 hi입니다.
 * 스네이크버드는 자신의 길이보다 작거나 같은 높이에 있는 과일들을 먹을 수 있습니다.
 * 스네이크버드의 처음 길이가 L일때 과일들을 먹어 늘릴 수 있는 최대 길이를 구하세요.
 * <p>
 * 입력
 * 첫 번째 줄에 과일의 개수 N (1 ≤ N ≤ 1,000) 과 스네이크버드의 초기 길이 정수 L (1 ≤ L ≤ 10,000) 이 주어집니다.
 * 두 번째 줄에는 정수 h1, h2, ..., hN (1 ≤ hi ≤ 10,000) 이 주어집니다.
 * <p>
 * 출력
 * 첫 번째 줄에 스네이크버드의 최대 길이를 출력합니다.
 */
public class Q16435 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        // 과일 높이 내림차순 정렬
        Arrays.sort(fruits);

        for (int i = 0; i < N; i++) {
            if (fruits[i] > L) {
                // 현재 길이보다 큰 과일이 나왔을 경우 그 이후의 과일은 먹지 못한다.
                break;
            }
            L++;
        }

        System.out.println(L);
    }
}
