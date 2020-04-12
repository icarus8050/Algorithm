import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Lisa's WorkBook (https://www.hackerrank.com/challenges/lisa-workbook/problem)
 */
public class LisaWorkbook {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        String[] stringBasedProblems = br.readLine().split(" ");
        int[] problems = new int[n];
        int currentPage = 0;
        int ans = 0;

        for (int i = 0; i < stringBasedProblems.length; i++) {
            problems[i] = Integer.parseInt(stringBasedProblems[i]);
            currentPage++;

            for (int j = 1; j <= problems[i]; j++) {
                if (currentPage == j) {
                    ans++;
                }

                if (j != problems[i] && j % k == 0) {
                    currentPage++;
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.newLine();

        br.close();
        bw.close();
    }
}
