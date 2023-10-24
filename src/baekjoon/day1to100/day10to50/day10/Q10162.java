package baekjoon.day1to100.day10to50.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * 3개의 시간조절용 버튼 A B C가 달린 전자레인지가 있다.
 * 각 버튼마다 일정한 시간이 지정되어 있어 해당 버튼을 한번 누를 때마다 그 시간이 동작시간에 더해진다.
 * 버튼 A, B, C에 지정된 시간은 각각 5분, 1분, 10초이다.
 * 냉동음식마다 전자레인지로 요리해야할 시간 T가 초단위로 표시되어 있다.
 * <p>
 * 우리는 A, B, C 3개의 버튼을 적절히 눌러서 그 시간의 합이 정확히 T초가 되도록 해야 한다.
 * 단 버튼 A, B, C를 누른 횟수의 합은 항상 최소가 되어야 한다. 이것을 최소버튼 조작이라고 한다.
 * <p>
 * 만일 요리시간이 100초라고 하면(T=100) B를 1번, C는 4번 누르면 된다.
 * 이와 다르게 C를 10번 눌러도 100초가 되지만 이 경우 10번은 최소 횟수가 아니기 때문이 답이 될 수 없다.
 * 이 경우 B 1번, C 4번, 총 5번이 최소버튼 조작이다. 그리고 T=234와 같이 3개의 버튼으로 시간을 정확히 맞출 수 없는 경우도 있다.
 * <p>
 * 여러분은 주어진 요리시간 T초를 맞추기 위한 최소버튼 조작 방법을 구하는 프로그램을 작성해야 한다.
 * <p>
 * 입력
 * 첫 번째 줄에는 요리시간 T(초)가 정수로 주어져 있으며 그 범위는 1 ≤ T ≤ 10,000 이다.
 * <p>
 * 출력
 * 여러분은 T초를 위한 최소버튼 조작의 A B C 횟수를 첫 줄에 차례대로 출력해야 한다. 각각의 횟수 사이에는 빈 칸을 둔다. 해당 버튼을 누르지 않는 경우에는 숫자 0을 출력해야한다.
 * 만일 제시된 3개의 버튼으로 T초를 맞출 수 없으면 음수 -1을 첫 줄에 출력해야 한다.
 */

/**
 * 개선 사항
 * 다들 배열을 애용하는 경향이 있다.
 * 배열을 쓸 경우 append하는 작업을 반복문을 통하여 코드를 더 줄일 수 있다.
 */
public class Q10162 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        if (T % 10 > 0) {
            // 10으로 나누어 떨어지지 않을 경우 3개의 버튼으로 시간을 정확히 맞출 수 없다.
            System.out.println(-1);
            return;
        }

        int[] result = new int[3];
        result[0] = T / 300; // A버튼을 누른 횟수
        T %= 300; // A버튼으로 최대한 누른 후 남은 시간값
        result[1] = T / 60; // B버튼을 누른 횟수
        T %= 60; // B버튼으로 최대한 누른 후 남은 시간값
        result[2] = T / 10; // C버튼을 누른 횟수

        StringBuilder sb = new StringBuilder();

        for(int i : result){
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
    }
}
