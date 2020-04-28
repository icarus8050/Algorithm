import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * OX 퀴즈 (https://www.acmicpc.net/problem/8958)
 */
public class BOJ_8958 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            char[] answers = br.readLine().toCharArray();
            int[] scores = new int[answers.length];

            scores[0] = (answers[0] == 'O') ? 1 : 0;

            int length = answers.length;
            for (int i = 1; i < length; i++) {
                if (answers[i] == 'O') {
                    scores[i] = scores[i - 1] + 1;
                } else {
                    scores[i] = 0;
                }
            }

            int result = Arrays.stream(scores).sum();
            bw.write(String.valueOf(result));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
