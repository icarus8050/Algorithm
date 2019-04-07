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
		
		int N = Integer.parseInt(br.readLine());
		CustomDeque deque = new CustomDeque();
		
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			switch (st.nextToken()) {
			case "push_front" :
				deque.push_front(Integer.parseInt(st.nextToken()));
				break;
			case "push_back" :
				deque.push_back(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front" :
				bw.write(deque.pop_front() + "\n");
				break;
			case "pop_back" :
				bw.write(deque.pop_rear() + "\n");
				break;
			case "size" :
				bw.write(deque.size() + "\n");
				break;
			case "empty" :
				bw.write(deque.empty() + "\n");
				break;
			case "front" :
				bw.write(deque.getFront() + "\n");
				break;
			case "back" :
				bw.write(deque.getRear() + "\n");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

class CustomDeque {
	private int size;
	private Node front;
	private Node rear;
	
	public CustomDeque() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public int empty() {
		return ((size == 0) ? 1 : 0);
	}
	
	public int getFront() {
		return ((front != null) ? front.data : -1);
	}
	
	public int getRear() {
		return ((rear != null) ? rear.data : -1);
	}
	
	public void push_front(int data) {
		Node newNode = new Node(data);
		if (empty() == 0) {
			front.prev = newNode;
			newNode.next = front;
			front = newNode;
		} else {
			front = newNode;
			rear = newNode;
		}
		size++;
	}
	
	public void push_back(int data) {
		Node newNode = new Node(data);
		if (empty() == 0) {
			rear.next = newNode;
			newNode.prev = rear;
			rear = newNode;
		} else {
			front = newNode;
			rear = newNode;
		}
		size++;
	}
	
	public int pop_front() {
		if (empty() == 0) {
			int data = front.data;
			front = front.next;
			if (front == null) {
				rear = null;
			} else {
				front.prev = null;
			}
			size--;
			return data;
		} else {
			return -1;
		}
	}
	
	public int pop_rear() {
		if (empty() == 0) {
			int data = rear.data;
			rear = rear.prev;
			if (rear == null) {
				front = null;
			} else {
				rear.next = null;
			}
			size--;
			return data;
		} else {
			return -1;
		}
	}
}

class Node {
	int data;
	Node prev;
	Node next;
	
	public Node(int data) {
		this.data = data;
		prev = null;
		next = null;
	}
}