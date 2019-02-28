import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] adjMat = new int[N][N];
		int[][] resMat = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adjMat[i][j] = Integer.parseInt(st.nextToken());
				resMat[i][j] = adjMat[i][j];
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (i == k)
					continue;
				for (int j = 0; j < N; j++) {
					if (j == k)
						continue;
					
					if (adjMat[i][j] == adjMat[i][k] + adjMat[k][j]) {
						resMat[i][j] = 0;
						
					} else if (adjMat[i][j] > adjMat[i][k] + adjMat[k][j]) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result += resMat[i][j];
			}
		}
		System.out.println(result / 2);
	}
}