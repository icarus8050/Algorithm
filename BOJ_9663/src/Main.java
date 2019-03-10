import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N, result = 0;
	static int[] col;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		col = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			col[1] = i;
			dfs(1);
		}
		System.out.println(result);
		br.close();
	}
	
	public static void dfs(int row) {
		if (row == N) {
			result++;
		}
		else {
			for (int i = 1; i <= N; i++) {
				col[row + 1] = i;
				if (isPossible(row + 1)) {
					dfs(row + 1);
				}
			}
		}
	}
	
	public static boolean isPossible(int row) {
		for (int i = 1; i < row; i++) {
			if (col[i] == col[row])
				return false;
			
			if (Math.abs(col[i] - col[row]) == Math.abs(i - row))
				return false;
		}
		return true;
	}
}
