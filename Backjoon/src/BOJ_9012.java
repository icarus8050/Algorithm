import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_9012 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String bucket = br.readLine();
            bw.write(checkVPS(bucket));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    public static String checkVPS(String bucket) {
        if (bucket.length() % 2 != 0) return "NO";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < bucket.length(); i++) {
            char c = bucket.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}
