package baekjoon.day10to50.day48;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문제
 * 어느 날, 미르코는 우연히 길거리에서 양수 N을 보았다. 미르코는 30이란 수를 존경하기 때문에, 그는 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.
 * 미르코를 도와 그가 만들고 싶어하는 수를 계산하는 프로그램을 작성하라.
 *
 * 입력
 * N을 입력받는다. N는 최대 10^5개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.
 *
 * 출력
 * 미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라. 그 수가 존재하지 않는다면, -1을 출력하라.
 */

/**
 * 개선 사항
 * 마지막 결과값 생성 시 사용하는 for문을 이전 for문에서 미리 결과값을 생성해두어 생략할 수 있다
 */
public class Q10610 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        /**
         *  30의 배수는 끝자리가 무조건 0이어야 한다.
         *  또 끝자리 0을 제외한 나머지 수는 3의 배수여야한다. 3의 배수는 모든 수의 합이 3의 배수여야한다.
         *  따라서 0이 없을경우 & 합이 3의 배수가 아닐 경우 -1 출력
         */
        if(!input.contains("0")) {
            System.out.println("-1");
            return;
        }

        // 30의 배수 중 가장 큰 수를 출력해야한다. -> 가장 큰 숫자를 앞으로 오게 하면된다. 내림차순으로 정렬
        int totalSum = 0;
        char[] charArr = input.toCharArray();
        Arrays.sort(charArr);
        StringBuilder sb = new StringBuilder();
        for(int i = charArr.length - 1; i >= 0; i--){
            int num = charArr[i] - '0';
            totalSum += num;
            sb.append(num);
        }

        if(totalSum % 3 > 0) {
            System.out.println("-1");
            return;
        }

        System.out.println(sb.toString());
    }
}
