import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T > 0) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			Node startNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Node destinationNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			int n = Integer.parseInt(br.readLine());
			
			while (n > 0) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				boolean isStartNodeInRange = 
						Math.pow((startNode.x - x), 2) + Math.pow((startNode.y - y), 2) < r * r;
				
				boolean isDestinationNodeInRange = 
						Math.pow((destinationNode.x - x), 2) + Math.pow((destinationNode.y - y), 2) < r * r;
				
				if (isStartNodeInRange ^ isDestinationNodeInRange) {
					ans++;
				}
				n--;
			}
			bw.write(ans + "\n");
			bw.flush();
			T--;
		}
		br.close();
		bw.close();
	}
}

class Node {
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}