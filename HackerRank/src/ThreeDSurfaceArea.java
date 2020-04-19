import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 3D Surface Area (https://www.hackerrank.com/challenges/3d-surface-area/problem)
 */
public class ThreeDSurfaceArea {

    static int h, w;
    static int[][] cubes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] hw = br.readLine().split(" ");
        h = Integer.parseInt(hw[0]);
        w = Integer.parseInt(hw[1]);
        cubes = new int[h][w];

        int ans = 0;
        for (int i = 0; i < h; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                cubes[i][j] = Integer.parseInt(inputs[j]);
                ans += (cubes[i][j] * 4) + 2;

                if (j >= 1) ans -= Math.min(cubes[i][j - 1], cubes[i][j]) * 2;
                if (i >= 1) ans -= Math.min(cubes[i - 1][j], cubes[i][j]) * 2;
            }
        }

        bw.write(ans+"\n");
        br.close();
        bw.close();
    }
}
