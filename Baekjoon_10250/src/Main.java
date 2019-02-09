import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int H, W, N;
		
		for (int i = 0; i < testCase; i++) {
			int floor;
			int roomNumber = 1;
			String strFloor;
			String strRoomNumber;
			
			H = sc.nextInt();
			W = sc.nextInt();
			N = sc.nextInt();
			
			while ((N - H) > 0) {
				roomNumber++;
				N -= H;
			}
			floor = N;
			
			strFloor = Integer.toString(floor);
			if (roomNumber < 10)
				strRoomNumber = "0" + Integer.toString(roomNumber);
			else
				strRoomNumber = Integer.toString(roomNumber);
			
				
			System.out.println(strFloor + strRoomNumber);
		}
	}
}
