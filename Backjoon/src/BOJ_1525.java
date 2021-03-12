import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * 퍼즐 (https://www.acmicpc.net/problem/1525)
 */
public class BOJ_1525 {

    static final String SUCCESS = "123456780";
    static int[] d = {-1, -3, 1, 3};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            Arrays.stream(br.readLine().split(" "))
                    .forEach(builder::append);
        }
        String s = builder.toString();

        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();

        visited.add(s);
        queue.add(new Pair(s, s.indexOf("0"), 0));
        int ans = -1;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            if (current.position.equals(SUCCESS)) {
                ans = current.ans;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextBlank = current.blank + d[i];

                if (nextBlank < 0 || nextBlank >= 9) {
                    continue;
                }

                String nextPair = swap(current.position, current.blank, nextBlank);
                if (!visited.contains(nextPair)) {
                    visited.add(nextPair);
                    queue.add(new Pair(nextPair, nextBlank, current.ans + 1));
                }
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static String swap(String s, int blankIndex, int nextBlankIndex) {
        char[] chars = s.toCharArray();
        chars[blankIndex] = chars[nextBlankIndex];
        chars[nextBlankIndex] = '0';
        return new String(chars);
    }

    static class Pair {
        String position;
        int blank;
        int ans;

        public Pair(String position, int blank, int ans) {
            this.position = position;
            this.blank = blank;
            this.ans = ans;
        }
    }
}
