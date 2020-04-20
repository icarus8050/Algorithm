import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/**
 * 키로거 (https://www.acmicpc.net/problem/5397)
 */
public class BOJ_5397 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            LinkedList<Character> front = new LinkedList<>();
            LinkedList<Character> back = new LinkedList<>();

            char[] chars = br.readLine().toCharArray();

            for (char aChar : chars) {
                switch (aChar) {
                    case '<':
                        if (!front.isEmpty()) {
                            back.addFirst(front.pollLast());
                        }
                        break;
                    case '>':
                        if (!back.isEmpty()) {
                            front.addLast(back.pollFirst());
                        }
                        break;
                    case '-':
                        if (!front.isEmpty()) {
                            front.pollLast();
                        }
                        break;
                    default:
                        front.addLast(aChar);
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!front.isEmpty()) {
                sb.append(front.pollFirst());
            }

            while (!back.isEmpty()) {
                sb.append(back.pollFirst());
            }

            bw.write(sb.toString());
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
