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
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            Arrays.stream(br.readLine().split(" "))
                    .forEach(builder::append);
        }
        String s = builder.toString();

        if (s.equals(SUCCESS)) {
            bw.write(0 + "\n");
        } else {
            bw.write(bfs(s) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int bfs(String s) {
        Queue<Pair> queue = new LinkedList<>();

        visited.add(s);
        queue.add(new Pair(s, s.indexOf("0"), 0));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int t = 0; t < size; t++) {
                Pair current = queue.poll();

                if (current.position.equals(SUCCESS)) {
                    return current.ans;
                }

                for (int i = 0; i < 4; i++) {
                    int curX = current.blank / 3;
                    int curY = current.blank % 3;
                    int nextX = curX + dx[i];
                    int nextY = curY + dy[i];

                    if ((nextX >= 0 && nextX < 3) && (nextY >= 0 && nextY < 3)) {
                        String nextPair = swap(current.position, current.blank, nextX * 3 + nextY);
                        if (!visited.contains(nextPair)) {
                            visited.add(nextPair);
                            queue.add(new Pair(nextPair, nextX * 3 + nextY, current.ans + 1));
                        }
                    }
                }
            }
        }

        return -1;
    }

    static String swap(String s, int a, int b) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(a, s.charAt(b));
        sb.setCharAt(b, s.charAt(a));
        return sb.toString();
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
