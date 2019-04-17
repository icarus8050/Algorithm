import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue pq = new PriorityQueue();
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0) {
				bw.write(pq.poll() + "\n");
			} else {
				pq.offer(num);
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class PriorityQueue {
	private final static int MAX_SIZE = 100_000;
	private int numberOfData;
	private int[] heap;
	
	public PriorityQueue() {
		numberOfData = 0;
		heap = new int[MAX_SIZE];
	}
	
	public void offer(int data) {
		int idx = numberOfData++;
		
		while (idx != 0) {
			if (data < heap[getParent(idx)]) {
				heap[idx] = heap[getParent(idx)];
				idx = getParent(idx);
			} else {
				break;
			}
		}
		heap[idx] = data;
	}
	
	public int poll() {
		if (isEmpty()) {
			return 0;
		}
		
		int ret = heap[0];
		int lastData = heap[--numberOfData];
		
		int parent = 0;
		int child;
		
		while ((child = getPriorityChild(parent)) >= 0) {
			if (lastData <= heap[child]) {
				break;
			}
			heap[parent] = heap[child];
			parent = child;
		}
		heap[parent] = lastData;
		return ret;
	}
	
	private boolean isEmpty() {
		return numberOfData == 0 ? true : false;
	}
	
	private int getParent(int idx) {
		return (idx - 1) / 2;
	}
	
	private int getLeftChild(int idx) {
		return idx * 2 + 1;
	}
	
	private int getRightChild(int idx) {
		return idx * 2 + 2;
	}
	
	private int getPriorityChild(int parent) {
		if (getLeftChild(parent) > numberOfData) {
			return -1;
		} else if (getLeftChild(parent) == numberOfData) {
			return getLeftChild(parent);
		} else {
			return (heap[getLeftChild(parent)] > heap[getRightChild(parent)]) ?
					getRightChild(parent) : getLeftChild(parent);
		}
	}
}
