import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * 그룹 단어 체커 (https://www.acmicpc.net/problem/1316)
 */
public class BOJ_1316 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        while (N-- > 0) {
            String input = br.readLine();
            Set<Character> charSet = new HashSet<>();
            char[] chars = input.toCharArray();
            char current = chars[0];

            for (int i = 0; i < chars.length; i++) {
                if (!charSet.contains(chars[i]) || current == chars[i]) {
                    current = chars[i];
                    charSet.add(chars[i]);
                } else {
                    break;
                }

                if (i == chars.length - 1) ans++;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
