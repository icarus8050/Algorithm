import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[] dx = {0, -1, 0, 1, 0};
	static int[] dy = {0, 0, -1, 0, 1};
	static int INF = Integer.MAX_VALUE;
	static int result = INF;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[100][100];
		
		for (int i = 0; i < 10; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < 10; j++) {
				if (input[j] == 'O')
					arr[i][j] = 1;
				else
					arr[i][j] = 0;
			}
		}
		
		for (int i = (1 << 10) - 1; i >= 0; i--) {
			int[][] temp = arr.clone();
			for (int c = 0; c < 10; c++)
				temp[c] = arr[c].clone();
			
			init(temp, i);
		}
		
		System.out.println((result != INF) ? result : -1);
		br.close();
	}
	public static void init(int[][] temp, int bit) {
		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			
			if ((bit & 1 << i) != 0) {
				cnt++;
				for (int j = 0; j < 5; j++) {
					int x = dx[j] + i;
					int y = dy[j];
					if (x >= 0 && x < 10 && y >= 0 && y < 10) {
						temp[y][x] ^= 1;
					}
				}
			}
		}
		solve(temp, cnt);
	}
	
	public static void solve(int[][] temp, int cnt) {
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (temp[i - 1][j] == 1) {
					cnt++;
					for (int k = 0; k < 5; k++) {
						int x = dx[k] + j;
						int y = dy[k] + i;
						if (x >= 0 && x < 10 && y >= 0 && y < 10) {
							temp[y][x] ^= 1;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (temp[i][j] == 1)
					return;
			}
		}
		result = Math.min(result, cnt);
	}
}
