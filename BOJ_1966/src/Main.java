import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<Document> docQueue = new LinkedList<>();
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int priority = Integer.parseInt(st.nextToken());
				priorityQueue.offer(priority);
				docQueue.offer(new Document(i, priority));
			}
			
			int cnt = 0;
			while (!docQueue.isEmpty()) {
				Document curDoc = docQueue.poll();
				
				if (curDoc.priority >= priorityQueue.peek()) {
					priorityQueue.poll();
					cnt++;
					
					if (curDoc.id == M)
						break;
				} else {
					docQueue.offer(curDoc);
				}
			}
			bw.write(cnt + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class Document {
	int id;
	int priority;
	public Document(int id, int priority) {
		this.id = id; this.priority = priority;
	}
}