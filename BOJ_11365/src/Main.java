import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str;
		while (!(str = br.readLine()).equals("END")) {
			StringBuilder sb = new StringBuilder(str).reverse();
			bw.write(sb.toString() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
