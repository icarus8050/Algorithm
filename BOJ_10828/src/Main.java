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
		CustomStack stack = new CustomStack();
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
			case "push" :
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop" :
				bw.write(stack.pop() + "\n");
				break;
			case "size" :
				bw.write(stack.size() + "\n");
				break;
			case "empty" :
				bw.write(stack.empty() + "\n");
				break;
			case "top" :
				bw.write(stack.top() + "\n");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

class CustomStack {
	private int[] arr;
	private int top;
	public CustomStack() {
		this.arr = new int[10000];
		this.top = -1;
	}
	
	public void push(int num) {
		if (top == 9999)
			return;
		
		arr[++top] = num;
	}
	
	public int pop() {
		if (top == -1)
			return top;
		
		return arr[top--];
	}
	
	public int size() {
		return top + 1;
	}
	
	public int empty() {
		if (top == -1)
			return 1;
		else
			return 0;
	}
	
	public int top() {
		if (top == -1)
			return top;
		
		return arr[top];
	}
}