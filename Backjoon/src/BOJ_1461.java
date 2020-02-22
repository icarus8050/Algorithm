import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1461 (도서관)
 */
public class BOJ_1461 {

    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> positive = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (val > 0) {
                positive.add(val);
            } else {
                negative.add(val);
            }
        }

        int maxDist = 0;
        int val;
        int sum = 0;

        while (!positive.isEmpty()) {
            for (int i = 0; i < M; i++) {
                if (positive.isEmpty()) {
                    break;
                }

                val = positive.poll();
                if (i == 0) {
                    sum += (val * 2);
                    maxDist = Math.max(maxDist, val);
                }
            }
        }

        while (!negative.isEmpty()) {
            for (int i = 0; i < M; i++) {
                if (negative.isEmpty()) {
                    break;
                }

                val = Math.abs(negative.poll());
                if (i == 0) {
                    sum += (val * 2);
                    maxDist = Math.max(maxDist, val);
                }
            }
        }
        sum -= maxDist;

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
