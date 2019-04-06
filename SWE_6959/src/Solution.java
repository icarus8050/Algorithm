import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t<= T; t++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			int cnt = 0;
			
			while (sb.length() > 1) {
				int a = sb.charAt(0) - '0';
				int b = sb.charAt(1) - '0';
				sb.delete(0, 2);
				sb.append(a + b);
				cnt++;
			}
			bw.write("#" + t + " " + ((cnt % 2 != 0) ? 'A' : 'B') + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
