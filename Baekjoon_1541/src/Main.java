import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String formula_1 = br.readLine();
		String formula_2 = "";
		
		int result = 0;
		
		for (int i = 0; i < formula_1.length(); i++) {
			if (formula_1.charAt(i) == '-') {
				st = new StringTokenizer(formula_1.substring(i + 1).replaceAll("[+]|[-]", " "));
				
				while (st.hasMoreTokens())
					result -= Integer.parseInt(st.nextToken());
				break;
			}
			else {
				formula_2 += formula_1.charAt(i);
			}
		}
		st = new StringTokenizer(formula_2, "+");
		while (st.hasMoreTokens())
			result += Integer.parseInt(st.nextToken());
		
		System.out.println(result);
		br.close();
	}
}
