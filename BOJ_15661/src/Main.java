import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] S;
	static boolean[] team;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		team = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				S[i][j] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0);
		System.out.println(ans);
		br.close();
	}
	
	public static void dfs(int cnt, int select) {
		if (cnt == N) {
			if (select > 0 && N - select > 0) {
				int t_1 = 0, t_2 = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (team[i] == team[j] && team[i] == true)
							t_1 += S[i][j];
						
						if (team[i] == team[j] && team[j] == false)
							t_2 += S[i][j];
					}
				}
				ans = Math.min(ans, Math.abs(t_1 - t_2));
			}
			return;
		}
		
		team[cnt] = true;
		dfs(cnt + 1, select + 1);
		team[cnt] = false;
		dfs(cnt + 1, select);
	}
}
