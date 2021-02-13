import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 추월 (https://www.acmicpc.net/problem/2002)
 */
public class BOJ_2002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeMap<Integer, String> map = new TreeMap<>();
        TreeMap<String, Integer> rMap = new TreeMap<>();
        Queue<String> out = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 0; i < n; i++) {
            String driver = br.readLine();
            map.put(i, driver);
            rMap.put(driver, i);
        }

        for (int i = 0; i < n; i++) {
            String driver = br.readLine();
            out.offer(driver);
        }

        while (!out.isEmpty()) {
            String driver = out.poll();
            Map.Entry<Integer, String> entry = map.firstEntry();

            if (!driver.equals(entry.getValue())) {
                ans++;
            }

            Integer removed = rMap.remove(driver);
            map.remove(removed);
        }

        bw.write(ans + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
