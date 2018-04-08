package P036_validSudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P036_solution {
	public static void main(String[] args) {
		char[][] board= {{'.','8','7','6','5','4','3','2','1'},
				         {'2','.','.','.','.','.','.','.','.'},
				         {'3','.','.','.','.','.','.','.','.'},
				         {'4','.','.','.','.','.','.','.','.'},
				         {'5','.','.','.','.','.','.','.','.'},
				         {'6','.','.','.','.','.','.','.','.'},
				         {'7','.','.','.','.','.','.','.','.'},
				         {'8','.','.','.','.','.','.','.','.'},
				         {'9','.','.','.','.','.','.','.','.'}};
		P036_solution ss=new P036_solution();
		System.out.println(ss.isValidSudoku(board));
			
	}
	private boolean isValidSudoku(char[][] board) {
		for (char[] line : board) {
			if (!subValid(line)) {
				return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			char[] line = new char[9];
			for (int j = 0; j < 9; j++) {
				line[j] = board[i][j];
			}
			if (!subValid(line)) {
				return false;
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				char[] line = new char[9];
				for (int m = 0; m < 3; m++) {
					for (int n = 0; n < 3; n++) {
						line[m * 3 + n] = board[i * 3 + m][j * 3 + n];
					}
				}
				if (!subValid(line)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean subValid(char[] line) {
		Set<Character> set = new HashSet<>();
		for (char ch : line) {
			if(ch=='.') {
				continue;
			}
			if (!set.contains(ch)) {
				set.add(ch);
			} else {
				return false;
			}
		}
		return true;
	}
}
