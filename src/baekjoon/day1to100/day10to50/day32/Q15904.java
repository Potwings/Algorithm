package baekjoon.day1to100.day10to50.day32;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제
 * UCPC는 '전국 대학생 프로그래밍 대회 동아리 연합 여름 대회'의 줄임말로 알려져있다. 하지만 이 줄임말이 정확히 어떻게 구성되었는지는 아무도 모른다.
 * UCPC 2018을 준비하던 ntopia는 여러 사람들에게 UCPC가 정확히 무엇의 줄임말인지 물어보았지만, 아무도 정확한 답을 제시해주지 못했다. ntopia가 들은 몇 가지 답을 아래에 적어보았다.
 * Union of Computer Programming Contest club contest
 * Union of Computer Programming contest club Contest
 * Union of Collegiate Programming contest Club contest
 * Union of Collegiate Programming contest club Contest
 * University Computer Programming Club contest
 * University Computer Programming club Contest
 * University Collegiate Programming Contest
 * University CPC
 * ...
 * ntopia는 이렇게 다양한 답을 듣고는 UCPC가 무엇의 약자인지는 아무도 모른다고 결론내렸다. 적당히 슥삭해서 UCPC를 남길 수 있으면 모두 UCPC의 약자인 것이다!
 * 문자열이 주어지면 이 문자열을 적절히 축약해서 "UCPC"로 만들 수 있는지 확인하는 프로그램을 만들어보자.
 * 축약이라는 것은 문자열에서 임의의 문자들을 제거하는 행동을 뜻한다. 예를 들면, "apple"에서 a와 e를 지워 "ppl"로 만들 수 있고,
 * "University Computer Programming Contest"에서 공백과 소문자를 모두 지워 "UCPC"로 만들 수 있다.
 * <p>
 * 문자열을 비교할 때는 대소문자를 구분해 정확히 비교한다. 예를 들어 "UCPC"와 "UCpC"는 다른 문자열이다.
 * 따라서 "University Computer programming Contest"를 "UCPC"로 축약할 수 있는 방법은 없다.
 * 그나저나 UCPC는 정말 무엇의 약자였을까? 정확히 아시는 분은 제보 부탁드립니다.
 * <p>
 * 입력
 * 첫 번째 줄에 알파벳 대소문자, 공백으로 구성된 문자열이 주어진다. 문자열의 길이는 최대 1,000자이다. 문자열의 맨 앞과 맨 끝에 공백이 있는 경우는 없고, 공백이 연속해서 2번 이상 주어지는 경우도 없다.
 * <p>
 * 출력
 * 첫 번째 줄에 입력으로 주어진 문자열을 적절히 축약해 "UCPC"로 만들 수 있으면 "I love UCPC"를 출력하고, 만들 수 없으면 "I hate UCPC"를 출력한다.
 */

/**
 * 개선 사항
 * 1. 한 단어에 대문자가 여러개 들어있을 경우 고려 안했음
 * 2. 대문자들로 구성되었을 경우 UCPC가 아닌 문자들을 제거하여 UCPC를 만들 수 있는 점을 간과함
 * 3. subString 시 현재 인덱스의 +1을 파라미터로 전달해주어야 그 이후의 값들로만 구성되는데 +1을 누락함.
 * 4. UCPC인데 UCDC로 배열에 써놓음...(문제 잘 읽자)
 * 5. 굳이 대문자만 뽑을 필요 없이 전체 문장에서 UCPC 확인해도 된다...(더 쉽게 생각하자)
 * 6. indexOf 시 substring할 필요 없이 두번째 파라미터에 시작지점을 전달해주면된다.
 */
public class Q15904 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

//        StringBuilder sb = new StringBuilder();
//        //입력받은 단어 중 대문자 부분을 제외하고는 제거한다.
//        while (st.hasMoreTokens()) {
//            String word = st.nextToken();
//            for (int i = 0; i < word.length(); i++) {
//                if (Character.isUpperCase(word.charAt(i))) {
//                    // 대문자일 경우 StringBuilder에 append
//                    sb.append(word.charAt(i));
//                }
//            }
//        }

        // 대문자들로 만든 단어에서 UCPC가 순서대로 들어있을 경우 UCPC로 축약 가능하다
        String upperCaseStr = br.readLine();
        String[] ucpcArr = {"U", "C", "P", "C"};
        int beforeindex = -1;
        for (String spell : ucpcArr) {
            int idx = upperCaseStr.indexOf(spell, beforeindex);
            if (idx == -1) {
                System.out.println("I hate UCPC");
                return;
            }
            beforeindex = idx;
        }

        System.out.println("I love UCPC");
    }
}
