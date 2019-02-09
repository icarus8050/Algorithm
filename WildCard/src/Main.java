import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static String wildCard;
	static String file;
	static int cache[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < testCase; i++) {
			ArrayList<String> fileList = new ArrayList<String>();
			
			wildCard = sc.nextLine();
			
			int n = sc.nextInt();
			sc.nextLine();
			
			for (int j = 0; j < n; j++) {
				cache = new int[101][101];
				file = sc.nextLine();
				
				if (match(0, 0) == 1)
					fileList.add(file);
			}
			
			Collections.sort(fileList);
			
			for (String fileName : fileList) {
				System.out.println(fileName);
			}
			
		}
	}
	
	public static int match(int wild_index, int str_index) {
		if (cache[wild_index][str_index] != 0)
			return cache[wild_index][str_index];
		
		while (wild_index < wildCard.length() && str_index < file.length() &&
				(wildCard.charAt(wild_index) == '?' || wildCard.charAt(wild_index) == file.charAt(str_index))) {
			return cache[wild_index][str_index] = match(wild_index + 1, str_index + 1);
		}
		
		if (wild_index == wildCard.length())
			return cache[wild_index][str_index] = (str_index == file.length()) ? 1 : -1;
		
		if (wildCard.charAt(wild_index) == '*') {
			if((match(wild_index + 1, str_index) == 1) ||
					(str_index < file.length() && match(wild_index, str_index + 1) == 1))
				return cache[wild_index][str_index] = 1;
		}
		
		return cache[wild_index][str_index] = -1;
	}

}
