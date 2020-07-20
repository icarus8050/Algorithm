import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 피시방 알바 (https://www.acmicpc.net/problem/1453)
 */
public class BOJ_1453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        int ans = 0;

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < inputs.length; i++) {
            int seat = Integer.parseInt(inputs[i]);
            if (set.contains(seat)) {
                ans++;
            } else {
                set.add(seat);
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
