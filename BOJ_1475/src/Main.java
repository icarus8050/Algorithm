import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] number = new int[10];
		String roomNum = br.readLine();
		
		for (int i = 0; i < roomNum.length(); i++) {
			int num = roomNum.charAt(i) - '0';
			
			if (num == 9)
				number[6]++;
			else
				number[num]++;
		}
		number[6] = number[6] / 2 + number[6] % 2;
		int max = 0;
		for (int i : number)
			max = Math.max(max, i);
		
		System.out.println(max);
		br.close();
	}
}
