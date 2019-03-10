import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_dfs_2 {
	static int N;
	static int[] days;
	static int[] reward;
	static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		days = new int[N];
		reward = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			days[i] = Integer.parseInt(st.nextToken());
			reward[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		System.out.println(result);
		br.close();
	}
	
	public static void dfs(int day, int sum) {
		if (day == N) {
			result = Math.max(result, sum);
			return;
		}
		
		if (day + days[day] <= N)
			dfs(day + days[day], sum + reward[day]);
		
		dfs(day + 1, sum);
	}
}
