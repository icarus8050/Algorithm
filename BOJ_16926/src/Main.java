import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] mat = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				mat[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = Math.min(N, M) / 2;
		while (R-- > 0) {
			for (int t = 0; t < cnt; t++) {
				int temp = mat[t][t];
				int right_col = M - t - 1;
				int right_row = N - t - 1;
				
				for (int c = t; c < right_col; c++)
					mat[t][c] = mat[t][c + 1];
				
				for (int r = t; r < right_row; r++)
					mat[r][right_col] = mat[r + 1][right_col];
				
				for (int c = right_col; c > t; c--)
					mat[right_row][c] = mat[right_row][c - 1];
				
				for (int r = right_row; r > t; r--)
					mat[r][t] = mat[r - 1][t];
				
				mat[t + 1][t] = temp;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(mat[i][j]).append(" ");
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
