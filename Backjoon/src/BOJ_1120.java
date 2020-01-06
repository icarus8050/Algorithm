import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1120 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i <= s[1].length() - s[0].length(); i++) {
            int min = 0;

            for (int j = 0; j < s[0].length(); j++) {
                if (s[0].charAt(j) != s[1].charAt(j + i)) {
                    min++;
                }
            }

            diff = Math.min(diff, min);
        }

        bw.write(diff + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
