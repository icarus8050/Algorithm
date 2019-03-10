import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		long total = A * X + B * Y;
		int cnt = Math.min(X, Y);
		
		while (cnt-- > 0) {
			if ((A + B) > 2 * C) {
				total = (total - A - B) + C * 2;
			}
		}
		total = Math.min(total, Math.max(X, Y) * 2 * C);
		System.out.println(total);
		br.close();
	}
}
