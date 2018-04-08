package P566_ReshapeMatrix;

import java.util.Arrays;

public class P566_solution {
	public static void main(String[] args) {
		P566_solution ss = new P566_solution();
		int[][] matrix= {{1,2},{3,4}};
		int r=1;
		int c=4;
		int[][] newmat=ss.matrixReshape(matrix, r, c);
		for(int i=0;i<r;i++) {
			System.out.println(Arrays.toString(newmat[i]));
		}
	}

	private int[][] matrixReshape(int[][] nums, int r, int c) {
		int m = nums.length;
		int n = nums[0].length;
		if (!(r * c == m * n)) {
			throw new IllegalArgumentException("no such resolve");
		}
		int[][] newMat = new int[r][c];
		int i = 0, j = 0, inew = 0;
		for (inew = 0; inew < r; inew++) {
			int jnew = 0;
			while (jnew < c) {
					newMat[inew][jnew] = nums[i][j];
					j++;
					jnew++;
				if(j==n) {
					j = 0;
					i++;
				}
			}
		}
		return newMat;
	}
}
