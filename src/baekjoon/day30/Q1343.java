package baekjoon.day30;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * 민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. AAAA와 BB
 * 이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다.
 * 이때, '.'는 폴리오미노로 덮으면 안 된다.
 * 폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 보드판이 주어진다. 보드판의 크기는 최대 50이다.
 * <p>
 * 출력
 * 첫째 줄에 사전순으로 가장 앞서는 답을 출력한다. 만약 덮을 수 없으면 -1을 출력한다.
 */

/**
 * 개선 사항
 * 그냥 입력받은 문자열에서 XXXX인 경우 우선적으로 AAAA로 변환한 후
 * XX인 경우 B로 치환하면 된다.
 * 그 후 X가 남아있을 경우 -1을 return 한다.
 *
 * <b>좀 더 단순하게 생각하자.</b>
 */
public class Q1343 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(solution2(br.readLine()));
    }

    public static String solution2(String input) {
        String result = input.replace("XXXX", "AAAA").replace("XX", "BB");
        if (result.contains("X")) {
            result = "-1";
        }
        return result;
    }

//    public static String solution(String input) {
//
//        input += " "; // 마지막에 .만 있는 경우도 처리하기 위해서 마지막에 공백문자 추가
//        // StringTokenizer를 사용할 경우 "."이 여러개 있는 경우 처리 불가하여 split 사용
//        String[] strArr = input.split("\\.");
//        int arrayLength = strArr.length;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < arrayLength; i++) {
//            int boardLength = strArr[i].trim().length(); // 공백 제거
//            if (boardLength % 2 > 0) {
//                // x가 홀수개일 경우 변환이 불가능하므로 -1 반환
//                return "-1";
//            }
//
//            while (boardLength > 0) {
//                if (boardLength >= 4) {
//                    // X가 4개 이상일 경우 A를 우선적으로 사용
//                    boardLength -= 4;
//                    sb.append("AAAA");
//                } else {
//                    boardLength -= 2;
//                    sb.append("BB");
//                }
//            }
//            if (arrayLength - 1 > i) {
//                // 마지막일 경우 "." 추가 안함
//                sb.append(".");
//            }
//        }
//
//        return sb.toString();
//    }
}
