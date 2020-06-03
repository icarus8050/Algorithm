import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Mars Exploration (https://www.hackerrank.com/challenges/mars-exploration/problem)
 */
public class MarsExploration {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int seq = i % 3;
            char comp = s.charAt(i);

            if (seq == 0 && comp != 'S') {
                ans++;
            } else if (seq == 1 && comp != 'O') {
                ans++;
            } else if (seq == 2 && comp != 'S') {
                ans++;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
