package baekjoon.day1to100.day10to50.day45;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * Day Of Mourning의 기타리스트 강토가 사용하는 기타에서 N개의 줄이 끊어졌다.
 * 따라서 새로운 줄을 사거나 교체해야 한다. 강토는 되도록이면 돈을 적게 쓰려고 한다.
 * 6줄 패키지를 살 수도 있고, 1개 또는 그 이상의 줄을 낱개로 살 수도 있다.
 * <p>
 * 끊어진 기타줄의 개수 N과 기타줄 브랜드 M개가 주어지고,
 * 각각의 브랜드에서 파는 기타줄 6개가 들어있는 패키지의 가격,
 * 낱개로 살 때의 가격이 주어질 때,
 * 적어도 N개를 사기 위해 필요한 돈의 수를 최소로 하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 N과 M이 주어진다. N은 100보다 작거나 같은 자연수이고, M은 50보다 작거나 같은 자연수이다.
 * 둘째 줄부터 M개의 줄에는 각 브랜드의 패키지 가격과 낱개의 가격이 공백으로 구분하여 주어진다.
 * 가격은 0보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
 * <p>
 * 출력
 * 첫째 줄에 기타줄을 적어도 N개 사기 위해 필요한 돈의 최솟값을 출력한다.
 */

/**
 * 개선 사항
 * 남은 개수를 단품으로 사는 것보다 패키지를 사는게 더 저렴할 경우 패키지를 구매한다.
 * 패키지보다 단품 6개를 사는게 더 저렴할 경우 단품을 구매한다.
 * 탐욕 알고리즘은 지금 당장 최적이라고 생각되는 것만 생각하고 진행한다는 것을 명심하자
 */
public class Q1049 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int lowestSixPack = 1000; // 6개 패키지 최저 가격
        int lowestSingle = 1000; // 한 줄 최저 가격
        // 최소값만 필요하므로 해당 가격들 중 최소값만 불러온다.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sixPack = Integer.parseInt(st.nextToken());
            int single = Integer.parseInt(st.nextToken());
            if (lowestSixPack > sixPack) {
                lowestSixPack = sixPack;
            }
            if (lowestSingle > single) {
                lowestSingle = single;
            }
        }

        int sixPack = N / 6;
        int single = N - sixPack * 6;

        int result = sixPack * lowestSixPack + single * lowestSingle;
        result = Math.min(result , (sixPack + 1) * lowestSixPack); // 패키지로 전부 구매하는 것이 더 져렴한 경우
        result = Math.min(result, N * lowestSingle); // 단품으로 전부 구매하는 것이 더 저렴한 경우

        System.out.println(result);
    }
}
