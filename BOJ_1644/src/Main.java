import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[N + 1];
		
		for (int i = 2; i * i <= N; i++) {
			if (isPrime[i] == false) {
				for (int j = i * i; j <= N; j += i) {
					isPrime[j] = true;
				}
			}
		}
		
		for (int i = 2; i <= N; i++) {
			if (isPrime[i] == false) {
				primeList.add(i);
			}
		}
		primeList.add(0);
		
		int cnt = primeList.size() - 1;
		int s = 0, e = 0;
		int sum = 0, ans = 0;
		while (e <= cnt) {
			if (sum < N) {
				sum += primeList.get(e++);
			} else {
				
				if (sum == N)
					ans++;
				
				sum -= primeList.get(s++);
			}
		}
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}