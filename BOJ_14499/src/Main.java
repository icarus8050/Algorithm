import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] dice = new int[7];
	static int N, M, x, y, K;
	static int[][] map;
	static int[] dx = {0, 1, -1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int command = Integer.parseInt(st.nextToken());
			int nx = dx[command] + x;
			int ny = dy[command] + y;
			if (inRange(nx, ny)) {
				changeDice(command);
				y = ny;
				x = nx;
				if (map[y][x] == 0) {
					map[y][x] = dice[6];
				}
				else {
					dice[6] = map[y][x];
					map[y][x] = 0;
				}
				sb.append(dice[1]).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean inRange(int x, int y) {
		return (x >= 0 && x < M && y >= 0 && y < N);
	}
	
	public static void changeDice(int command) {
		int[] temp = dice.clone();
		
		switch (command) {
		case 1:
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[6] = temp[4];
			dice[4] = temp[1];
			break;
		case 2:
			dice[1] = temp[4];
			dice[4] = temp[6];
			dice[6] = temp[3];
			dice[3] = temp[1];
			break;
		case 3:
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[6] = temp[5];
			dice[5] = temp[1];
			break;
		case 4:
			dice[1] = temp[5];
			dice[5] = temp[6];
			dice[6] = temp[2];
			dice[2] = temp[1];
			break;
		}
	}
}
