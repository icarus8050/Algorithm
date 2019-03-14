import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		ArrayList<Position> list = new ArrayList<Position>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Position(x, y));
		}
		Collections.sort(list, new Comparator<Position>() {
			@Override
			public int compare(Position pos_1, Position pos_2) {
				return pos_1.x - pos_2.x;
			}
		});
		list.add(0, new Position(0, 0));
		
		for (int i = 1; i <= N; i++) {
			Position pos = list.get(i);
			int lx = pos.x;
			int rx = pos.x;
			int y = Math.abs(pos.y);
			dp[i] = Integer.MAX_VALUE;
			for (int j = i - 1; j >= 0; j--) {
				int cost = Math.max(Math.abs(rx - lx), y * 2);
				dp[i] = Math.min(dp[i], dp[j] + cost);
				
				lx = list.get(j).x;
				y = Math.max(y, Math.abs(list.get(j).y));
			}
		}
		
		System.out.println(dp[N]);
		br.close();
	}
}
class Position {
	int x, y;
	public Position(int x, int y) {
		this.x = x; this.y = y;
	}
}
