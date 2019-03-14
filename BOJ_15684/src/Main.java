import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, H;
	static int[][] arr;
	static int result = -1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
		}
		
		for (int i = 0; i < 4; i++) {
			dfs(1, 0, i);
			if (result != -1)
				break;
		}
		System.out.println(result);
		br.close();
	}
	
	public static void dfs(int row, int cnt, int ladder) {
		if (result != -1)
			return;
		
		if (cnt == ladder) {
			if (check())
				result = ladder;
			return;
		}
		
		for (int i = row; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (arr[i][j] != 1 && arr[i][j - 1] != 1 && arr[i][j + 1] != 1) {
					arr[i][j] = 1;
					dfs(i, cnt + 1, ladder);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	public static boolean check() {
		for (int col = 1; col <= N; col++) {
			int cur = col;
			for (int row = 1; row <= H; row++) {
				if (arr[row][cur] == 1)
					cur++;
				else if(arr[row][cur - 1] == 1)
					cur--;
			}
			if (cur != col)
				return false;
		}
		return true;
	}
}
