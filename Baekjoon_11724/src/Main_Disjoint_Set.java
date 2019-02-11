import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_Disjoint_Set {

	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			merge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 1; i <= N; i++)
			if (parent[i] == i) result++;
		
		System.out.println(result);
	}
	
	public static int find(int u) {
		if (parent[u] == u)
			return u;
		else
			return parent[u] = find(parent[u]);
	}
	
	public static void merge(int u, int v) {
		u = find(u);
		v = find(v);
		
		if (u == v) return;
		
		parent[u] = v;
	}
}
