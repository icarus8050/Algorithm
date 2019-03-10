import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] days;
	static int[] reward;
	
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
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			result = Math.max(result, dfs(i, reward[i]));
		}
		System.out.println(result);
		br.close();
	}
	
	public static int dfs(int day, int sum) {
		if (days[day] > N - day)
			return 0;
		int temp = sum;
		for (int i = days[day] + day; i < N; i++) {
			sum = Math.max(sum, dfs(i, temp + reward[i]));
		}
		
		return sum;
	}
}
