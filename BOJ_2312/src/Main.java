import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static final int MAX = 100001;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[MAX];
		for (int i = 2; i * i < MAX; i++) {
			for (int j = i * i; j < MAX; j += i) {
				if (!prime[j])
					prime[j] = true;
			}
		}
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			int idx = 2;
			
			while (N != 1) {
				int cnt = 0;
				
				while (N % idx == 0) {
					cnt++;
					N /= idx;
				}
				
				if (cnt != 0)
					bw.write(idx + " " + cnt + "\n");
				
				idx++;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
