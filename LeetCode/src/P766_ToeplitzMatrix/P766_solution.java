package P766_ToeplitzMatrix;
//判断二维矩阵是否对角线上的值全相同
public class P766_solution {
	public static void main(String[] args) {
		int[][] target= {{1,2,3,4},{5,1,2,3}, {9,5,1,2}};
		P766_solution ss=new P766_solution();
		System.out.println(ss.test(target));
	}

	private boolean test(int[][] matrix) {
		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[0].length;j++) {
				if(!(matrix[i][j]==matrix[i-1][j-1])){
					return false;
				}
			}
		}
		return true;
	}
}
