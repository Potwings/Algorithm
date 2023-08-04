package baekjoon.day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * 수현이는 4차 산업혁명 시대에 살고 있는 중학생이다.
 * 코로나 19로 인해, 수현이는 버추얼 학교로 버추얼 출석해 버추얼 강의를 듣고 있다.
 * 수현이의 버추얼 선생님은 문자가 2개인 연립방정식을 해결하는 방법에 대해 강의하고,
 * 다음과 같은 문제를 숙제로 냈다.
 * 다음 연립방정식에서 x와 y의 값을 계산하시오.
 * <p>
 * 입력
 * 정수 a,b,c,d,e,f가 공백으로 구분되어 차례대로 주어진다. (-999 <= a,b,c,d,e,f <= 999)
 * 문제에서 언급한 방정식을 만족하는 (x,y)가 유일하게 존재하고,
 * 이 때 x와 y가 각각 -999 이상 999 이하의 정수인 경우만 입력으로 주어짐이 보장된다.
 * <p>
 * 출력
 * 문제의 답인 x와 y를 공백으로 구분해 출력한다.
 */
/**
 * 그냥 수학문제...
 */
public class Q19532 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Integer.parseInt(st.nextToken());
        double b = Integer.parseInt(st.nextToken());
        double c = Integer.parseInt(st.nextToken());
        double d = Integer.parseInt(st.nextToken());
        double e = Integer.parseInt(st.nextToken());
        double f = Integer.parseInt(st.nextToken());


        double x = (c * e - b * f) / (a * e - b * d);
        double y = (c * d - a * f) / (b * d - a * e);

        System.out.println(x + " " + y);

    }
}
