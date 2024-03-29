import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String num = st.nextToken();
		int notation = Integer.parseInt(st.nextToken());
		int result = 0;
		
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) > 57) {
				result += (num.charAt(i) - 55) * Math.pow(notation, num.length() - i - 1);
			} else {
				result += (num.charAt(i) - '0') * Math.pow(notation, num.length() - i - 1);
			}
		}
		
		bw.write(result + "\n");
		bw.close();
		br.close();
	}
}
