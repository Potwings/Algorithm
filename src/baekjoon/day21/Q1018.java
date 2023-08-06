package baekjoon.day21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다.
 * 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다.
 * 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
 * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다.
 * 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
 * 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
 * 보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
 * 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.
 * <p>
 * 출력
 * 첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
 */
public class Q1018 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 32; // 최대 변경 필요 갯수에서 줄여가며 최솟값을 구한다.

        // 입력받은 값을 지속적으로 확인을 해야하므로 배열에 담아준다.
        char[][] board = new char[N][M];
        String inputLine = null;
        for (int i = 0; i < N; i++) {
            inputLine = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = inputLine.charAt(j);
            }
        }

        // 8X8이 완성될 수 있도록 남은 행과 열이 8개 이상 남았을 경우만 진행
        for (int row = 0; row <= N - 8; row++) {
            for (int column = 0; column <= M - 8; column++) {
                int blackResult = 0;
                int whiteResult = 0;
                int tempResult = 0;
                row:
                // 해당 지점부터 시작할 경우 몇 개를 변경해야할 지 count. 기존 count값을 넘어갈 경우 break;
                for (int k = 0; k < 8; k++) {
                    char[] line = board[row + k];
                    for (int l = 0; l < 8; l += 2) {
                        char first = line[column + l];
                        char second = line[column + l + 1];

                        // B부터 시작했을 경우
                        if (blackResult <= result) {
                            if (k % 2 == 0) {
                                // 홀수번째 라인의 경우 BW 순서가 반대로 된다.
                                if (first != 'B') {
                                    blackResult++;
                                }
                                if (second != 'W') {
                                    blackResult++;
                                }
                            } else {
                                if (first != 'W') {
                                    blackResult++;
                                }
                                if (second != 'B') {
                                    blackResult++;
                                }
                            }
                        }

                        // W부터 시작했을 경우
                        if (whiteResult <= result) {
                            if (k % 2 == 0) {
                                if (first != 'W') {
                                    whiteResult++;
                                }

                                if (second != 'B') {
                                    whiteResult++;
                                }
                            } else {
                                if (first != 'B') {
                                    whiteResult++;
                                }

                                if (second != 'W') {
                                    whiteResult++;
                                }
                            }
                        }

                        if (whiteResult > result && blackResult > result) {
                            // 둘 다 기존의 값보다 커질 경우 최소값에 부합하지 않으므로 중단
                            break row;
                        }
                    }

                }
                tempResult = whiteResult > blackResult ? blackResult : whiteResult;
                if (result > tempResult) result = tempResult;
            }

        }

        System.out.println(result);
    }
}
