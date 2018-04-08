package P037_SolveSoduku;

public class P037_solution {
	private void solveSudoku(char[][] board) {
		doSolve(board, 0, 0);
	}

	private boolean doSolve(char[][] board, int row, int col) {
		for (int i = row; i < 9; i++, col = 0) {    
			//这一步令计算从下一点开始，避免重复计算，col的初始值只在i的第一个循环保留，之后要在每次循环开始时置0
			for (int j = col; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char num = '1'; num <= '9'; num++) {
						if (isValid(board, i, j, num)) {
							board[i][j] = num;
							if (doSolve(board, i, j)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int row, int col, char num) {
		int cubeRow = 3 * (row / 3);
		int cubeCol = 3 * (col / 3);
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == num || board[i][col] == num 
					|| board[cubeRow + i / 3][cubeCol + i % 3] == num) {
				return false;
			}
		}
		return true;

	}
}