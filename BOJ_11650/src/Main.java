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
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Point> pri_queue = new PriorityQueue<Point>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pri_queue.offer(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			Point point = pri_queue.poll();
			
			sb.append(point.x).append(" ").append(point.y).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}

class Point implements Comparable<Point>{
	int x, y;
	public Point(int x, int y) {
		this.x = x; this.y = y;
	}
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		if (this.x == o.x)
			return this.y - o.y;
		else
			return this.x - o.x;
	}
}