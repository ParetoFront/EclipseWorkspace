package P695_MaxIsland;

//在一片由1、0组成的矩阵中，寻找最大的陆地（由相连的1组成）
//思路：递归
//关键点：设置一个flag，在完成递归后，将当前cell设为true，表示该点已经被递归过，
//作用：1.避免在某个cell的递归过程中递归回到该点  2.在之后计算其他点时先校验flag，避免重复计算
public class P695_solution {
	
	static boolean[][] flag; // 全局变量，全false

	public static void main(String[] args) {
		P695_solution ss=new P695_solution();
		int[][] grid= {{0,0,1,0,0,0,0,1,0,0,0,0,0},
					   {0,0,0,0,0,0,0,1,1,1,0,0,0},
					   {0,1,1,0,1,0,0,0,0,0,0,0,0},
					   {0,1,0,0,1,1,0,0,1,0,1,0,0},
					   {0,1,0,0,1,1,0,0,1,1,1,0,0},
					   {0,0,0,0,0,0,0,0,0,0,1,0,0},
					   {0,0,0,0,0,0,0,1,1,1,0,0,0},
					   {0,0,0,0,0,0,0,1,1,0,0,0,0}};
		flag=new boolean[8][13];
		System.out.println(ss.maxArea(grid));
}
		
	

	public int maxArea(int[][] grid) {
		int maxarea = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				maxarea = Math.max(maxarea, area(grid, i, j));
			}
		}
		return maxarea;
	}

	private int area(int[][] grid, int i, int j) {
		//注意，应先判断i，j是否越界，在判断grid[i][j]。否则就会在ij越界时先报错
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || flag[i][j]) {
			return 0;
		}
		flag[i][j] = true;
		return (1 + area(grid, i, j - 1) + area(grid, i - 1, j) + area(grid, i, j + 1) + area(grid, i + 1, j));
	}
}
