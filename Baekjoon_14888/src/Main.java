import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int[] operator = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0, 0, 0, 1, arr[0]);
		System.out.println(max);
		System.out.println(min);
		br.close();
	}
	
	public static void dfs(int plus, int minus, int mul, int div, int index, int total) {
		if (index == N) {
			max = Math.max(max, total);
			min = Math.min(min, total);
			return;
		}
		
		if (operator[0] > plus) dfs(plus + 1, minus, mul, div, index + 1, total + arr[index]);
		if (operator[1] > minus) dfs(plus, minus + 1, mul, div, index + 1, total - arr[index]);
		if (operator[2] > mul) dfs(plus, minus, mul + 1, div, index + 1, total * arr[index]);
		if (operator[3] > div) dfs(plus, minus, mul, div + 1, index + 1, total / arr[index]);
	}
}
