package baekjoon.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제
 * 임씨의 이름이 새겨진 옥구슬의 위치 N 개가 주어질 때에, 임씨에게 돌아갈 대지의 넓이를 계산하는 프로그램을 작성하시오.
 * 단, 옥구슬의 위치는 2 차원 정수 좌표로 주어지고 옥구슬은 같은 위치에 여러 개가 발견될 수도 있으며, x 축의 양의방향을 동쪽, y 축의 양의방향을 북쪽이라고 가정한다.
 * <p>
 * 입력
 * 첫째 줄에는 점의 개수 N (1 ≤ N ≤ 100,000) 이 주어진다. 이어지는 N 줄에는 각 점의 좌표가 두 개의 정수로 한 줄에 하나씩 주어진다. 각각의 좌표는 -10,000 이상 10,000 이하의 정수이다.
 * <p>
 * 출력
 * 첫째 줄에 N 개의 점을 둘러싸는 최소 크기의 직사각형의 넓이를 출력하시오.
 */

/**
 * 개선 사항
 * List에 넣어둔 후 Collections.max, Collections.min을 통하여 최대 최소값을 구해오는 것도 좋으나
 * 애초에 읽어올 때 최대값 최소값인지 확인 후 불러오면 작업을 더 줄일 수 있다.
 */
public class Q9063 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            // 1일 경우 직사각형을 만들 수 없다.
            System.out.println(0);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int xMin = Integer.parseInt(st.nextToken());
        int xMax = xMin;
        int yMin = Integer.parseInt(st.nextToken());
        int yMax = yMin;

        for (int i = 1; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            if (x < xMin) {
                xMin = x;
            } else if (xMax < x) {
                xMax = x;
            }

            int y = Integer.parseInt(st.nextToken());

            if (y < yMin) {
                yMin = y;
            } else if (yMax < y) {
                yMax = y;
            }
        }

        // x좌표의 최대값과 최소값의 차와 y 좌표의 최대값과 최소값의 차를 곱하면 된다
        System.out.println((xMax - xMin) * (yMax - yMin));
    }
}
