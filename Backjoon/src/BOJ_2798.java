import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 블랙잭 (https://www.acmicpc.net/problem/2798)
 */
public class BOJ_2798 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] cards = new int[N];
        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(cards);

        int ans = 0;
        for (int i = N - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (M >= cards[i] + cards[j] + cards[k]) {
                        ans = Math.max(ans, cards[i] + cards[j] + cards[k]);
                    }
                }
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
