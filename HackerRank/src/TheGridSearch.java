import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * The Grid Search (https://www.hackerrank.com/challenges/the-grid-search/problem)
 */
public class TheGridSearch {

    static int R, C;
    static int r, c;
    static String[] G;
    static String[] P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] rcInput = br.readLine().split(" ");
            R = Integer.parseInt(rcInput[0]);
            C = Integer.parseInt(rcInput[1]);
            G = new String[R];
            for (int i = 0; i < R; i++) {
                G[i] = br.readLine();
            }

            rcInput = br.readLine().split(" ");
            r = Integer.parseInt(rcInput[0]);
            c = Integer.parseInt(rcInput[1]);
            P = new String[r];
            for (int i = 0; i < r; i++) {
                P[i] = br.readLine();
            }

            bw.write(solve());
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    public static String solve() {

        for (int i = 0; i <= R - r; i++) {
            int start = 0;
            int end = c;

            while (end <= C) {
                if (G[i].substring(start, end).equals(P[0])) {
                    for (int j = 1; j < r; j++) {
                        if (!G[i + j].substring(start, end).equals(P[j]))
                            break;

                        if (j == r - 1) return "YES";
                    }
                }
                start++;
                end++;
            }
        }

        return "NO";
    }
}
