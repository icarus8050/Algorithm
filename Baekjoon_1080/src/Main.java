import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] mat;
	static int[][] mat_2;
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int result = 0;
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		mat = new int[N][M];
		mat_2 = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				mat[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				mat_2[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				if (mat[i - 1][j - 1] != mat_2[i - 1][j - 1]) {
					reverse(i, j);
					result++;
				}
			}
		}
		System.out.println(check()? result : -1);
		br.close();
	}
	
	public static void reverse(int i, int j) {
		for (int x = i - 1; x <= i + 1; x++)
			for (int y = j - 1; y <= j + 1; y++)
				mat[x][y] = Math.abs(mat[x][y] - 1);
	}
	
	public static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mat[i][j] != mat_2[i][j])
					return false;
			}
		}
		return true;
	}
}
