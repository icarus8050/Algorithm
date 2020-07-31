import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 숫자 야구 (https://www.acmicpc.net/problem/2503)
 */
public class BOJ_2503 {

    //baseballs[0][] = {number, strike, ball}
    static String[][] baseballs;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        baseballs = new String[n][3];

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            baseballs[i][0] = inputs[0];
            baseballs[i][1] = inputs[1];
            baseballs[i][2] = inputs[2];
        }

        int ans = 0;
        for (int i = 123; i <= 987; i++) {
            if (isPossible(String.valueOf(i))) ans++;
        }
        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isPossible(String num) {
        char[] c = num.toCharArray();

        if (c[0] == c[1] || c[0] == c[2] || c[1] == c[2]
                || c[0] == '0' || c[1] == '0' || c[2] == '0')
            return false;

        for (int i = 0; i < n; i++) {
            int[] sb = getSB(i, c);

            int strike = Integer.parseInt(baseballs[i][1]);
            int ball = Integer.parseInt(baseballs[i][2]);
            if (strike != sb[0] || ball != sb[1]) return false;
        }

        return true;
    }

    private static int[] getSB(int time, char[] num) {
        String s = baseballs[time][0];
        int[] SB = {0, 0};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (s.charAt(i) == num[j]) {
                    if (i == j) SB[0]++;
                    else SB[1]++;
                }
            }
        }

        return SB;
    }
}
