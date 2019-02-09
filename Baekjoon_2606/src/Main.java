import java.util.Scanner;

public class Main {

	public static boolean[] visited;
	public static int[][] computer;
	public static int infect_count = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		computer = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 1; i <= M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			computer[from][to] = computer[to][from] = 1;
		}
		sc.close();
		dfs(1);
		System.out.println(infect_count);
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		infect_count++;
		for (int i = 1; i <= computer.length - 1; i++) {
			if (!visited[i] && computer[start][i] == 1) {
				dfs(i);
			}
			
		}
	}
}
