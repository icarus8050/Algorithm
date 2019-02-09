import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static final int[][][] coverType = {
			{	{0, 0}, {1, 0}, {0, 1}	},
			{	{0, 0}, {0, 1}, {1, 1}	},
			{	{0, 0}, {1, 0}, {1, 1}	},
			{	{0, 0}, {1, 0}, {1, -1}	}
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase;
		int row, col;
		
		Scanner input = new Scanner(System.in);
		testCase = input.nextInt();
		
		for(int t = 0; t < testCase; t++) {
			ArrayList<ArrayList<Integer>> board =
					new ArrayList<ArrayList<Integer>>();
			
			row = input.nextInt();
			col = input.nextInt();
			input.nextLine();
			for (int i = 0; i < row; i++) {
				ArrayList<Integer> oneRow = new ArrayList<Integer>();
				String tempRow = input.nextLine();
				
				for (int j = 0; j < tempRow.length(); j++) {
					if (Character.toString(tempRow.charAt(j)).equals("#"))
						oneRow.add(1);
					else
						oneRow.add(0);
				}
				
				board.add(oneRow);
			}//end for
			System.out.println(cover(board));
			
		}//end for
		input.close();
	}//end main
	
	static int cover(ArrayList<ArrayList<Integer>> board) {
		int y = -1, x = -1;
		
		for(int i = 0; i < board.size(); i++) {
			for(int j = 0; j < board.get(i).size(); j++) {
				if(board.get(i).get(j) == 0) {
					y = i;
					x = j;
					break;
				}
			}
			if(y != -1) break;
		}
		
		if(y == -1) return 1;
		int result = 0;
		
		for(int type = 0; type < 4; type++) {
			if(set(board, x, y, type, 1))
				result += cover(board);
			set(board, x, y, type, -1);
		}
		return result;
	}
	
	static boolean set(ArrayList<ArrayList<Integer>> board, int x, int y,
			int type, int toggle) {
		
		boolean possible = true;
		
		for(int i = 0; i < 3; i++) {
			int ny = y + coverType[type][i][0];
			int nx = x + coverType[type][i][1];
			
			if(ny < 0 || ny >= board.size() ||
					nx < 0 || nx >= board.get(0).size())
				possible = false;
			else {
				board.get(ny).set(nx, board.get(ny).get(nx) + toggle);
				
				if(board.get(ny).get(nx) > 1)
					possible = false;
			}
		}
		return possible;
	}
}
