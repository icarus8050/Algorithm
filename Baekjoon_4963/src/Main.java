import java.util.Scanner;

public class Main {

	static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
	static int map[][];
	static int visited[][];
	static int w, h;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			
			if(w == 0 || h == 0)
				return;
			
			map = new int[h][w];
			visited = new int[h][w];
			int count = 0;
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (visited[i][j] == 0 && map[i][j] == 1) {
						count++;
						DFS(i, j);
					}
				}
			}
			System.out.println(count);
		}
	}

	public static void DFS(int x, int y) {
		int nx, ny;
		visited[x][y] = 1;
		
		for (int i = 0; i < 8; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if ((nx >= 0 && nx < h) && (ny >= 0 && ny < w)) {
				if (visited[nx][ny] == 0 && map[nx][ny] == 1) {
					DFS(nx, ny);
				}
			}
		}
	}
}
