
public class CrazyBot {

	boolean[][] visited = new boolean[100][100];
	int[] dx = {1, -1, 0, 0};
	int[] dy = {0, 0, -1, 1};
	double[] probability = new double[4];
	public double getProbability(int n, int east, int west, int south, int north) {
		probability[0] = east / 100.0;
		probability[1] = west / 100.0;
		probability[2] = south / 100.0;
		probability[3] = north / 100.0;
		
		return dfs(49, 49, n);
	}
	
	public double dfs(int x, int y, int n) {
		if (visited[x][y]) return 0;
		if (n == 0) return 1;
		
		visited[x][y] = true;
		double result = 0;
		
		for (int i = 0; i < 4; i++) {
			result += dfs(x + dx[i], y + dy[i], n - 1) * probability[i];
		}
		visited[x][y] = false;
		
		return result;
	}
}
