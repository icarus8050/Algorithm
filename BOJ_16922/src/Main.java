import java.util.Scanner;

public class Main {

	static int result = 0;
	static int N;
	static boolean[] visited;
	static int[] rome = {1, 5, 10, 50};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		visited = new boolean[N * 50 + 1];
		dfs(0, 0, 0);
		System.out.println(result);
		
		sc.close();
	}
	
	public static void dfs(int num, int cnt, int sum) {
		if (cnt == N) {
			if (!visited[sum]) {
				visited[sum] = true;
				result++;
			}
			return;
		}
		
		for (int i = num; i < 4; i++) {
			dfs(i, cnt + 1, sum + rome[i]);
		}
	}
}
