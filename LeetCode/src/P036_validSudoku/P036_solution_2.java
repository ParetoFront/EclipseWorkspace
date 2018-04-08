package P036_validSudoku;

import java.util.HashSet;
import java.util.Set;

public class P036_solution_2 {
	private boolean isValid(char[][] board) {
		for (int i = 0; i < 9; i++) {
			Set<Character> row = new HashSet<Character>();
			Set<Character> col = new HashSet<Character>();
			Set<Character> cube = new HashSet<Character>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !row.add(board[i][j])) {
					return false;
				}
				if (board[j][i] != '.' && !col.add(board[j][i])) {
					return false;
				}
				int rowIdx = 3 * (i / 3) + j / 3;
				int colIdx = 3 * (i % 3) + j % 3;
				
				// 一般的，由以下方式可以由一个数字的循环实现3x3表格的遍历
				// for (int i = 0; i < 9; i++) {
				//       row=i/3;
				//       col=i%3;
				//       board[row][col];
				// }
				// 注意/和%的运用。
				// 在此题中，对于cube的宏观位置，在j循环内应是不动的，即宏观位置由i遍历，
				// cube内部位置，用j遍历
				if (board[rowIdx][colIdx] != '.' && !cube.add(board[rowIdx][colIdx])) {
					return false;
				}
			}
		}
		return true;
	}
}
