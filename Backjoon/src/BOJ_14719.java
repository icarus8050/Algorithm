import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 빗물 (https://www.acmicpc.net/problem/14719)
 */
public class BOJ_14719 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] HW = br.readLine().split(" ");
        int h = Integer.parseInt(HW[0]);
        int w = Integer.parseInt(HW[1]);

        String[] inputs = br.readLine().split(" ");
        int[] area = new int[w];
        int[] leftMax = new int[w];
        int[] rightMax = new int[w];
        int ans = 0;

        int max = 0;
        for (int i = 0; i < w; i++) {
            area[i] = Integer.parseInt(inputs[i]);
            max = Math.max(max, area[i]);
            leftMax[i] = max;
        }

        max = 0;
        for (int i = w - 1; i >= 0; i--) {
            max = Math.max(max, area[i]);
            rightMax[i] = max;
        }

        for (int i = 0; i < w; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);

            if (min - area[i] > 0) ans += min - area[i];
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
