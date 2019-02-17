import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		bw.write((1 << N) - 1 + "\n");
		solve(N, 1, 3);
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void solve(int n, int x, int y) throws Exception {
		if (n == 0)
			return;
		
		solve(n - 1, x, 6 - x - y);
		bw.write(x + " " + y + "\n");
		solve(n - 1, 6 - x - y, y);
	}
}
