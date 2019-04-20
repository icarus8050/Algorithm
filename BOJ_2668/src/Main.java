import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N, cnt;
	static int[] arr;
	static boolean[] visited;
	static boolean[] cycle;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		cycle = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				visited[j] = cycle[j];
			}
			DFS(i, arr[i]);
		}
		
		bw.write(cnt + "\n");
		for (int i = 1; i <= N; i++) {
			if (cycle[i]) {
				bw.write(i + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean DFS(int startNum, int nodeNum) {
		if (visited[nodeNum])
			return false;
		
		visited[nodeNum] = true;
		
		if (startNum == nodeNum || DFS(startNum, arr[nodeNum])) {
			cnt++;
			cycle[nodeNum] = true;
			return true;
		}
		
		return false;
	}
}
