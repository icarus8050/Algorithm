import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int INF = Integer.MAX_VALUE;
	static int result = INF;
	static int[] dx = {0, -1, 0, 1, 0};
	static int[] dy = {0, 0, -1, 0, 1};
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int[][] lights = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				lights[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = (1 << N) - 1; i >= 0; i--) {
			int[][] copy = lights.clone();
			for (int k = 0; k < lights.length; k++) {
				copy[k] = lights[k].clone();
			}
			test(copy, i);
		}
		
		System.out.println((result != INF) ? result : -1);
		br.close();
	}
	
	public static void test(int[][] copyLights, int bit) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if ((bit & 1 << i) != 0) {
				count++;
				for (int j = 0; j < 5; j++) {
					int x = dx[j] + i;
					int y = dy[j];
					if (x >= 0 && x < N && y >= 0 && y < N)
						copyLights[y][x] ^= 1;
				}
			}
		}
		solve(copyLights, count);
	}
	
	public static void solve(int[][] copyLights, int count) {
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copyLights[i - 1][j] == 1) {
					count++;
					for (int k = 0; k < 5; k++) {
						int x = dx[k] + j;
						int y = dy[k] + i;
						if (x >= 0 && x < N && y >= 0 && y < N)
							copyLights[y][x] ^= 1;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copyLights[i][j] == 1)
					return;
			}
		}
		result = Math.min(result, count);
	}
}
