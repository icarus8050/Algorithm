import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static long[] square;
	static long N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if(N == 0)
				break;
			
			square = new long[(int) N];
			for (int i = 0; i < N; i++)
				square[i] = Integer.parseInt(st.nextToken());
			
			long result = solve(0, N - 1);
			bw.write(result + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static long solve(long left, long right) {
		if (left == right)
			return square[(int) left];
		
		long mid = (left + right) / 2;
		long result = Math.max(solve(left, mid), solve(mid + 1, right));
		long a = mid, b = mid + 1;
		long height = Math.min(square[(int) a], square[(int) b]);
		
		result = Math.max(result, height * 2);
		
		while (a > left || right > b) {
			if (a > left && (right == b || square[(int) (a - 1)] > square[(int) (b + 1)])) {
				a--;
				height = Math.min(height, square[(int) a]);
			}
			else {
				b++;
				height = Math.min(height, square[(int) b]);
			}
			result = Math.max(result, (b - a + 1) * height);
		}
		
		return result;
	}
}
