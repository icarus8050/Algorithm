import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Caesar Cipher (https://www.hackerrank.com/challenges/caesar-cipher-1/problem)
 */
public class CaesarCipher {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        int k = Integer.parseInt(br.readLine());
        k %= 26;

        for (int i = 0; i < n; i++) {

            if (s[i] >= 65 && s[i] <= 90) { //Upper Case
                s[i] += k;
                if (s[i] > 90) s[i] -= 26;
            } else if (s[i] >= 97 && s[i] <= 122) { //Lower Case
                s[i] += k;
                if (s[i] > 122) s[i] -= 26;
            }
        }

        bw.write(s);
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }
}
