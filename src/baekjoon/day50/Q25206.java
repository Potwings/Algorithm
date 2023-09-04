package baekjoon.day50;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q25206 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        double totalScore = 0; // 학점 총합
        double totalClassScore = 0; // 전공과목 합
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 과목명 skip

            double score = Double.parseDouble(st.nextToken()); // 학점

            String grade = st.nextToken();
            if (grade.equals("P")) continue; // P일 경우 생략
            double gradePoint = gradeToPoint(grade); // 과목 평점

            totalScore += score;
            totalClassScore += gradePoint * score;
        }

        System.out.println(totalClassScore / totalScore);

    }

    public static double gradeToPoint(String grade) {
        double point = 0;
        switch (grade) {
            case "A+":
                point = 4.5;
                break;
            case "A0":
                point = 4.0;
                break;
            case "B+":
                point = 3.5;
                break;
            case "B0":
                point = 3.0;
                break;
            case "C+":
                point = 2.5;
                break;
            case "C0":
                point = 2.0;
                break;
            case "D+":
                point = 1.5;
                break;
            case "D0":
                point = 1.0;
                break;
        }

        return point;
    }
}
