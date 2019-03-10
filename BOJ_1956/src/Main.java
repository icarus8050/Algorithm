import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 100000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] adjMat = new int[V + 1][V + 1];
		
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++)
				adjMat[i][j] = INF;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjMat[a][b] = c;
		}
		
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if (adjMat[i][j] > adjMat[i][k] + adjMat[k][j]) {
						adjMat[i][j] = adjMat[i][k] + adjMat[k][j];
					}
				}
			}
		}
		int result = INF;
		for (int i = 1; i <= V; i++) {
			if (adjMat[i][i] != INF) {
				result = Math.min(result, adjMat[i][i]);
			}
		}
		result = (result != INF) ? result : -1;
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
