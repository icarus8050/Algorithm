import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int ans = 0;
	static int r, c;
	static boolean flag = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, N);
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		solve(N, 0, 0);
		System.out.println(ans);
		br.close();		
	}
	public static void solve(int n, int x, int y) {
		if (flag) return;
		if (n == 2) {
			for (int i = y; i < y + 2; i++) {
				for (int j = x; j < x + 2; j++) {
					if (i == r && j == c) {
						flag = true;
						return;
					}
					ans++;
				}
			}
			return;
		}
		if (!(x <= c && x + n > c && y <= r && y + n > r)) {
			ans += n * n;
			return;
		}
		solve(n / 2, x, y);
		solve(n / 2, x + n / 2, y);
		solve(n / 2, x, y + n / 2);
		solve(n / 2, x + n / 2, y + n / 2);
		
	}
}
