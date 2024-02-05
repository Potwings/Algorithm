    package baekjoon.day101to200.day101to110.day105;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.LinkedList;
    import java.util.Queue;

    public class Q2164 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            Queue<Integer> numQueue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                numQueue.offer(i);
            }

            while (numQueue.size() > 1) {
                numQueue.poll();
                numQueue.offer(numQueue.poll());
            }

            System.out.println(numQueue.poll());
        }
    }
