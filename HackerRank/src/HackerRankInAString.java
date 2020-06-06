import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * HackerRank in a String! (https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem)
 */
public class HackerRankInAString {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String hackerrank = "hackerrank";
        int hackerrankLen = hackerrank.length();

        while (n-- > 0) {
            String s = br.readLine();
            int sLen = s.length();
            int j = 0;

            for (int i = 0; i < sLen; i++) {
                if (j >= hackerrankLen) break;

                if (hackerrank.charAt(j) == s.charAt(i)) {
                    j++;
                }
            }

            if (j == hackerrankLen) {
                bw.write("YES");
            } else {
                bw.write("NO");
            }

            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
