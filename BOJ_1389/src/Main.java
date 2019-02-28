import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 1000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] adjMat = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					adjMat[i][j] = 0;
				else
					adjMat[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjMat[a][b] = 1;
			adjMat[b][a] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (adjMat[i][j] > adjMat[i][k] + adjMat[k][j]) {
						adjMat[i][j] = adjMat[i][k] + adjMat[k][j];
					}
				}
			}
		}
		
		int num = 0;
		int kevin_num = INF;
		
		for (int i = 1; i <= N; i++) {
			int temp = 0;
			
			for (int j = 1; j <= N; j++) {
				temp += adjMat[i][j];
			}
			
			if (kevin_num > temp) {
				kevin_num = temp;
				num = i;
			}
		}
		bw.write(num + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
