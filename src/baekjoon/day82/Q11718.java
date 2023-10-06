package baekjoon.day82;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// IntelliJ에서 EOF(파일의 끝)을 입력하는 단축키는 Ctrl + D 이다.
public class Q11718 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = null;
        while ((input = br.readLine()) != null) {
            bw.write(input);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
