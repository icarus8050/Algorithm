import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		CustomQueue queue = new CustomQueue();
		
		while (N-- > 0) {
			String[] input = br.readLine().split(" ");
			
			switch (input[0]) {
			case "push" :
				queue.enqueue(Integer.parseInt(input[1]));
				break;
			case "pop" :
				bw.write(queue.dequeue() + "\n");
				break;
			case "size" :
				bw.write(queue.getSize() + "\n");
				break;
			case "empty" :
				bw.write(queue.isEmpty() + "\n");
				break;
			case "front" :
				bw.write(queue.getfront() + "\n");
				break;
			case "back" :
				bw.write(queue.getRear() + "\n");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

class CustomQueue {
	private Node front;
	private Node rear;
	private int size;
	
	public CustomQueue() {
		front = null;
		rear = null;
		size = 0;
	}
	
	public void enqueue(int data) {
		Node newNode = new Node(data);
		if (isEmpty() == 1) {
			front = newNode;
			rear = newNode;
		} else {
			rear.nextNode = newNode;
			rear = newNode;
		}
		size++;
	}
	
	public int dequeue() {
		if (isEmpty() == 1) {
			return -1;
		} else {
			int data = front.data;
			front = front.nextNode;
			if (front == null) {
				rear = null;
			}
			size--;
			return data;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public int isEmpty() {
		return ((front == null) ? 1 : 0);
	}
	
	public int getfront() {
		return ((front != null) ? front.data : -1);
	}
	
	public int getRear() {
		return ((rear != null) ? rear.data : -1);
	}
}

class Node {
	int data;
	Node nextNode;
	public Node(int data) {
		this.data = data;
		nextNode = null;
	}
}