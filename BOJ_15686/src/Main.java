import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static ArrayList<Node> houseList = new ArrayList<Node>();
	static ArrayList<Node> chickenList = new ArrayList<Node>();
	static ArrayList<Node> visitedList = new ArrayList<Node>();
	static int[][] map;
	static final int INF = Integer.MAX_VALUE;
	static int ans = INF;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					houseList.add(new Node(j, i));
					map[i][j] = num;
				}
				else if (num == 2) {
					chickenList.add(new Node(j, i));
					map[i][j] = num;
				}
			}
		}
		dfs(0, 0);
		System.out.println(ans);
		br.close();
	}
	
	public static void dfs(int num, int cnt) {
		
		if (cnt <= M) {
			check();
		}
		if (cnt > M || num == chickenList.size())
			return;
		
		visitedList.add(chickenList.get(num));
		dfs(num + 1, cnt + 1);
		visitedList.remove(visitedList.size() - 1);
		dfs(num + 1, cnt);
	}
	
	public static void check() {
		if (visitedList.size() == 0)
			return;
		
		int sum = 0;
		
		for (Node house: houseList) {
			int d = INF;
			for (Node visite: visitedList) {
				d = Math.min(d, Math.abs(house.x - visite.x) + Math.abs(house.y - visite.y));
			}
			sum += d;
		}
		ans = Math.min(ans, sum);
	}
}

class Node {
	int x, y;
	public Node(int x, int y) {
		this.x = x; this.y = y;
	}
}