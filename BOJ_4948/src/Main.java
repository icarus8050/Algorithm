import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int max = 123456 * 2 + 1;
		int n;
		boolean[] prime = new boolean[max];
		prime[0] = true; prime[1] = true;
		
		for (int i = 2; i * i <= max; i++) {
			for (int j = i * i; j <= max; j += i) {
				if (!prime[j])
					prime[j] = true;
			}
		}
		
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			int cnt = 0;
			for (int i = n + 1; i <= n * 2; i++) {
				if (!prime[i])
					cnt++;
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
