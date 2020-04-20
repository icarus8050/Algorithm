import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 키로거 (https://www.acmicpc.net/problem/5397)
 */
public class BOJ_5397 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            char[] inputs = br.readLine().toCharArray();
            List<Character> keys = new ArrayList<>();
            int cursor = 0;

            for (char input : inputs) {
                switch (input) {
                    case '<':
                        if (cursor != 0) {
                            cursor--;
                        }
                        break;
                    case '>':
                        if (cursor != keys.size()) {
                            cursor++;
                        }
                        break;
                    case '-':
                        if (cursor != 0) {
                            keys.remove(--cursor);
                        }
                        break;
                    default:
                        keys.add(cursor++, input);

                }
            }

            for (Character key : keys) {
                bw.write(key);
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
