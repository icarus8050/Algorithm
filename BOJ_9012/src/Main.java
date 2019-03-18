import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (t-- > 0) {
			String str = br.readLine();
			boolean flag = true;
			int open = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(')
					open++;
				else {
					if (open > 0)
						open--;
					else {
						flag = false;
						break;
					}
				}
			}
			if (open != 0)
				flag = false;
			
			if (flag)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.println(sb);
		br.close();
	}
}
