import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n + 1];
		
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (k == 1) {
				a = find(a);
				b = find(b);
				if (a == b)
					bw.write("YES\n");
				else
					bw.write("NO\n");
				bw.flush();
			}else {
				merge(a, b);
			}
		}
		br.close();
		bw.close();
	}
	
	public static int find(int n) {
		if(parent[n] == n)
			return n;
		
		return parent[n] = find(parent[n]);
	}
	
	public static void merge(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b)
			return;
		
		parent[a] = b;
	}
}
