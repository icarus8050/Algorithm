import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] inOrder;
	static int[] postOrder;
	static int[] position;
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		inOrder = new int[N];
		postOrder = new int[N];
		position = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
			position[inOrder[i]] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			postOrder[i] = Integer.parseInt(st.nextToken());
		
		solve(0, N - 1, 0, N - 1);
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void solve(int is, int ie, int ps, int pe) throws Exception {
		if (is > ie || ps > pe)
			return;
		
		int root = postOrder[pe];
		bw.write(root + " ");
		
		solve(is, position[root] - 1, ps, ps + position[root] - is - 1);
		solve(position[root] + 1, ie, ps + position[root] - is, pe - 1);
	}
}
