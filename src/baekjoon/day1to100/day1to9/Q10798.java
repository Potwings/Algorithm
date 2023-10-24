package baekjoon.day1to100.day1to9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 문제
 * 한 줄의 단어는 글자들을 빈칸 없이 연속으로 나열해서 최대 15개의 글자들로 이루어진다. 또한 만들어진 다섯 개의 단어들의 글자 개수는 서로 다를 수 있다.
 * 심심해진 영석이는 칠판에 만들어진 다섯 개의 단어를 세로로 읽으려 한다. 세로로 읽을 때, 각 단어의 첫 번째 글자들을 위에서 아래로 세로로 읽는다.
 * 다음에 두 번째 글자들을 세로로 읽는다. 이런 식으로 왼쪽에서 오른쪽으로 한 자리씩 이동 하면서 동일한 자리의 글자들을 세로로 읽어 나간다.
 * 위의 그림 1의 다섯 번째 자리를 보면 두 번째 줄의 다섯 번째 자리의 글자는 없다. 이런 경우처럼 세로로 읽을 때 해당 자리의 글자가 없으면, 읽지 않고 그 다음 글자를 계속 읽는다. 그림 1의 다섯 번째 자리를 세로로 읽으면 D1gk로 읽는다.
 * 칠판에 붙여진 단어들이 주어질 때, 영석이가 세로로 읽은 순서대로 글자들을 출력하는 프로그램을 작성하시오.
 */

/**
 * 입력받은 문자열을 split 후 이차원 배열을 구성하는 하나의 String 배열로 넣어주려 하였다.
 * 하지만 그렇게 하였을 경우 해당 String 배열의 길이가 입력받은 문자열의 길이로 한정되어 해당 문자열의 길이를 넘어가는 조회를 하게될 경우 Index out of bound가 발생하였다.
 * 이를 해결하기 위하여 split 후 반복문을 통하여 하나하나 이차원 배열에 값을 넣어주었다.
 *
 * 추가로 이 문제에서는 문자를 하나씩만 처리하기 때문에 String대신 char를 사용할 수도 있었다.
 */
public class Q10798 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] resultArr = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();

            for(int j = 0; j < line.length(); j++) {
                resultArr[i][j] = line.charAt(j); //String일 경우 split을 통하여 처리
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < 15; j++) {
            for (int k = 0; k < 5; k++) {
                builder.append(resultArr[k][j] != '\0' ? resultArr[k][j] : "");
            }

            if (builder.length() == 0) {
                break;
            }

            bw.write(builder.toString());
            builder.setLength(0);
        }

        bw.flush();
        bw.close();
    }
}
