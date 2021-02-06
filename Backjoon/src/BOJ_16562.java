import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 친구비 (https://www.acmicpc.net/problem/16562)
 */
public class BOJ_16562 {

    static int n, m, k;
    static boolean[][] friends;
    static int[] friendsCost;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        k = Integer.parseInt(inputs[2]);
        int ans = 0;

        friendsCost = new int[n];
        friends = new boolean[n][n];
        visited = new boolean[n];

        inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            friendsCost[i] = Integer.parseInt(inputs[i]);
        }

        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");

            int u1 = Integer.parseInt(inputs[0]) - 1;
            int u2 = Integer.parseInt(inputs[1]) - 1;

            friends[u1][u2] = true;
            friends[u2][u1] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans += dfs(i, Integer.MAX_VALUE);
            }
        }

        if (k >= ans)
            bw.write(ans + "\n");
        else
            bw.write("Oh no\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int idx, int minCost) {
        if (minCost > friendsCost[idx]) {
            minCost = friendsCost[idx];
        }

        for (int i = 0; i < n; i++) {
            if (idx == i) continue;

            if (!visited[i] && friends[idx][i]) {
                visited[i] = true;
                minCost = Math.min(minCost, dfs(i, minCost));
            }
        }

        return minCost;
    }
}
