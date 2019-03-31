import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		
		while (!(str = br.readLine()).equals(".")) {
			Stack<Character> stack = new Stack<Character>();
			boolean flag = true;
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '[') {
					stack.push(str.charAt(i));
				} else if (str.charAt(i) == ')') {
					if (!stack.isEmpty() && stack.peek() == '(')
						stack.pop();
					else {
						flag = false;
						break;
					}
				} else if (str.charAt(i) == ']') {
					if (!stack.isEmpty() && stack.peek() == '[')
						stack.pop();
					else {
						flag = false;
						break;
					}
				}
			}
			
			if (stack.isEmpty() && flag)
				bw.write("yes\n");
			else
				bw.write("no\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
