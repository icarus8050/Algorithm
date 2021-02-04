import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 쇠막대기 (https://www.acmicpc.net/problem/10799)
 */
public class BOJ_10799 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        int len = input.length();
        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                if (i - stack.peek() == 1) {
                    stack.pop();
                    ans += stack.size();
                } else {
                    stack.pop();
                    ans++;
                }
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
