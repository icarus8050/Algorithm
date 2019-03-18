import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		boolean flag = true;
		int max = 0;
		int top = 0;
		int[] stack = new int[n];
		while (n-- > 0) {
			int num = Integer.parseInt(br.readLine());
			
			if (num > max) {
				for (int i = max; i < num; i++) {
					sb.append("+\n");
					stack[top++] = i + 1;
				}
				max = num;
			}
			else {
				if (num != stack[top - 1]) {
					flag = false;
					break;
				}
			}
			top--;
			sb.append("-\n");
		}
		if (flag)
			System.out.println(sb);
		else
			System.out.println("NO");
		br.close();
	}
}
