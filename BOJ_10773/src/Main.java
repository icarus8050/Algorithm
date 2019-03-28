import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		int sum = 0;
		Stack<Integer> stack = new Stack<>();
		while (K-- > 0) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
				stack.push(num);
			} else {
				stack.pop();
			}
		}
		
		while (!stack.isEmpty())
			sum += stack.pop();
		
		System.out.println(sum);
		br.close();
	}
}
