import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class dfs_ver {

	static int N, idx;
	static int[][] adjMat;
	static int[][] resultMat;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		adjMat = new int[N + 1][N + 1];
		resultMat = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				adjMat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (idx = 1; idx <= N; idx++) {
			visited = new boolean[N + 1];
			dfs(idx);
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				bw.write(resultMat[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int start) {
		for (int i = 1; i <= N; i++) {
			if (adjMat[start][i] == 1 && visited[i] == false) {
				visited[i] = true;
				resultMat[idx][i] = 1;
				dfs(i);
			}
		}
	}
}
