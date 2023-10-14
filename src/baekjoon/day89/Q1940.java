package baekjoon.day89;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 처음 진행한 방법의 경우 합이 M보다 클지라도 배열의 i번째가 M보다 클 때까지 계속 진행하므로 불필요한 과정이 수행된다.
 * 아래와 같은 방식으로 진행하면 수행 속도를 개선할 수 있다.
 * <p>
 * 배열을 정렬한 후 배열의 양 끝에서 인덱스를 확인하기 시작한다.
 * 두 수의 합이 M보다 작을 경우 더 커져야 하므로 작은 수의 값을 늘려준다.
 * 두 수의 합이 M보다 클 경우 합이 더 작아져야 하므로 큰 수의 값을 줄여준다.
 * 만일 두 수의 합이 M과 같을 경우 해당 수들은 다른 수와 합쳤을 경우 M이 나올 수 없으므로
 * 두 수 모두 변경해준다.
 * 양 끝에서 시작하여 인덱스를 변경하므로 두 수의 대소 여부가 변경되기 전까지 진행하면 된다.
 */
public class Q1940 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] materials = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(materials);
        int result = 0;
        int i = 0;
        int j = N - 1;
        while (i < j) {
            int sum = materials[i] + materials[j];
            if (sum < M) {
                i++;
            } else if (sum == M) {
                result++;
                i++;
                j--;
            } else {
                j--;
            }
        }

        System.out.println(result);
    }
}
