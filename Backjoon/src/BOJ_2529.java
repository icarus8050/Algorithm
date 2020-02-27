import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 부등호 https://www.acmicpc.net/problem/2529
 */
public class BOJ_2529 {
    static boolean[] visited = new boolean[10];
    static String[] arr;
    static int k;
    static String min = null, max = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());
        arr = new String[k];

        arr = br.readLine().split(" ");

        dfs(0, "");

        bw.write(max + "\n");
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int cnt, String str) {
        if (cnt == k + 1) {
            if (min == null) min = str;
            else max = str;

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            if (cnt == 0 || possible(Character.getNumericValue(str.charAt(cnt - 1)), i, arr[cnt - 1])) {
                visited[i] = true;
                dfs(cnt + 1, str + i);
                visited[i] = false;
            }
        }
    }

    private static boolean possible(int first, int second, String op) {
        if (op.equals(">")) {
            return first > second;
        } else {
            return first < second;
        }
    }
}
