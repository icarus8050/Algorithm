import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 키로거 (https://www.acmicpc.net/problem/5397)
 */
public class BOJ_5397 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Stack<String> front = new Stack<>();
            Stack<String> back = new Stack<>();

            String[] keys = br.readLine().split("");

            for (String key : keys) {
                if (key.equals("<")) {
                    if (!front.isEmpty()) {
                        String val = front.pop();
                        back.push(val);
                    }
                } else if (key.equals(">")) {
                    if (!back.isEmpty()) {
                        String val = back.pop();
                        front.push(val);
                    }
                } else if (key.equals("-")) {
                    if (!front.isEmpty()) {
                        front.pop();
                    }
                } else {
                    front.push(key);
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!back.isEmpty()) {
                sb.append(back.pop());
            }

            while (!front.isEmpty()) {
                sb.insert(0, front.pop());
            }

            bw.write(sb.toString());
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
