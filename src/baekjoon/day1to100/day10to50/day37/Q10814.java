package baekjoon.day1to100.day10to50.day37;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제
 * 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
 * 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
 * 둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
 * 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고,
 * 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다.
 * 입력은 가입한 순서로 주어진다.
 * <p>
 * 출력
 * 첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순,
 * 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
 */
public class Q10814 {

    public static class User implements Comparable<User> {

        int age;

        String name;

        // 가입 순서
        int idx;

        public User(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }

        @Override
        public int compareTo(User user) {
            if (this.age == user.age) {
                // 나이가 같을 경우 가입 순으로 정렬
                return this.idx - user.idx;
            } else {
                return this.age - user.age;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        User[] userArr = new User[N];

        StringTokenizer st = null;
        // 가입 순서 저장
        int idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            userArr[i] = new User(Integer.parseInt(st.nextToken()), st.nextToken(), idx);
        }

        Arrays.sort(userArr);

        StringBuilder sb = new StringBuilder();
        for (User user : userArr) {
            sb.append(user.age).append(" ").append(user.name).append("\n");
        }

        System.out.println(sb.toString());
    }
}
