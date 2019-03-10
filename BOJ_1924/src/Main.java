import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strNum = br.readLine().split(" ");
		int x = Integer.parseInt(strNum[0]);
		int y = Integer.parseInt(strNum[1]);
		
		String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int sum = 0;
		for (int i = 1; i < x; i++) {
			if (i == 4 || i == 6 || i == 9 || i == 11)
				sum += 30;
			else if (i == 2)
				sum += 28;
			else
				sum += 31;
		}
		sum += y;
		
		while (sum / 7 != 0)
			sum %= 7;
		
		System.out.println(day[sum]);
		br.close();
	}
}
