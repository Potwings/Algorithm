package baekjoon.day136;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개선 사항
 * 둘다 큰 경우에만 크다고 판단한다.
 */
public class Q7568 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Person[] personArr = new Person[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            personArr[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 자기보다 큰 사람 수 count
        StringBuilder sb = new StringBuilder();
        for (Person person : personArr) {
            int count = 1; // 순위이므로 1부터 시작
            for (Person otherPerson : personArr) {
                if (person.weight < otherPerson.weight && person.height < otherPerson.height) {
                    count++;
                }
            }
            sb.append(count).append(" ");
        }

        System.out.println(sb);

    }

    public static class Person {
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
