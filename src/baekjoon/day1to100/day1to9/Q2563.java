package baekjoon.day1to100.day1to9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * 첫째 줄에 색종이의 수가 주어진다.
 * 이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다.
 * 색종이를 붙인 위치는 두 개의 자연수로 주어지는데 첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고,
 * 두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다.
 * 색종이의 수는 100 이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다
 */

/**
 * 정수로 나누어 떨어지기 때문에 한칸을 배열의 구성요소 하나로 생각하면 된다고 판단했다.
 * 색종이가 채워진 부분을 1로 변환하는 것을 생각했고
 * 이미 색종이가 붙어 있으면 겹치는 부분이기 때문에 넓이를 계산할 필요가 없으므로 변환하지 않도록 했다.
 *
 * 처음에는 전부 색칠 후 채워진 부분의 개수를 세는 것으로 생각하였으나
 * 처음부터 색칠할 때 결과값을 계산하면 더 좋을 거라는 판단이 들어 아래와 같이 문제를 풀었다.
 */
public class Q2563 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] paper = new int[100][100];
        int squareCount = Integer.parseInt(br.readLine()); //전체 색종이 개수
        int result = 0;
        StringTokenizer st = null;
        for (int i = 0; i < squareCount; i++) {

            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken()); //색종이 높이
            int width = Integer.parseInt(st.nextToken()); //색종이 넓이
            for (int j = 0; j < 10; j++) { //정사각형 변의 길이는 10이다.
                for (int k = 0; k < 10; k++) {
                    if (paper[length + j][width + k] == 0) { //색칠되지 않은부분만 생각한다.
                        result++; //검은색으로 색칠된 부분의 총 넓이
                        paper[length + j][width + k] = 1; //다시 색칠되지 않도록 1로 변경
                    }
                }
            }
        }
        System.out.println(result);
    }
}
