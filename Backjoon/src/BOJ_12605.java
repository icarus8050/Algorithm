import java.io.*;
import java.util.Stack;

/**
 * 단어순서 뒤집기 (https://www.acmicpc.net/problem/12605)
 */
public class BOJ_12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            bw.write(String.format("Case #%d: ", i));
            String input = br.readLine();
            String[] words = input.split(" ");

            Stack<String> stack = new Stack<>();
            for (String word : words) {
                stack.push(word);
            }

            while (!stack.isEmpty()) {
                bw.write(stack.pop() + " ");
            }

            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
