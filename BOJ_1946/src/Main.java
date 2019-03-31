import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int ans = 0;
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Pair> pri_queue = new PriorityQueue<Pair>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				pri_queue.offer(new Pair(a, b));
			}
			
			Pair first = pri_queue.poll();
			int min = first.b;
			ans++;
			
			while (!pri_queue.isEmpty()) {
				Pair temp = pri_queue.poll();
				if (min > temp.b) {
					min = temp.b;
					ans++;
				}
			}
			
			bw.write(ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class Pair implements Comparable<Pair> {
	int a, b;
	public Pair(int a, int b) {
		this.a = a; this.b = b;
	}
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return this.a - o.a;
	}
}