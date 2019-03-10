import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static int[] tree;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		
		int h = (int) Math.ceil(getLog(N, 2));
		int treeSize = (1 << (h + 1));
		tree = new int[treeSize];
		Arrays.fill(tree, INF);
		
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		init(1, 1, N);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(getMin(1, 1, N, a, b)).append("\n");
		}
		System.out.println(sb);		
		br.close();
	}
	
	public static double getLog(int num, int base) {
		return Math.log(num) / Math.log(base);
	}
	
	public static int init(int node, int start, int end) {
		if (start == end)
			return tree[node] = arr[start];
		else
			return tree[node] = 
			Math.min(init(node * 2, start, (start + end) / 2),
					init(node * 2 + 1, (start + end) / 2 + 1, end));
	}
	
	public static int getMin(int node, int start, int end, int left, int right) {
		if (left > end || right < start)
			return INF;
		if (left <= start && right >= end) {
			return tree[node];
		}
		return Math.min(getMin(node * 2, start, (start + end) / 2, left, right),
				getMin(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
	}
}
