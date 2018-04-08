package P695_MaxIsland;

public class test {
	static boolean[][] flag;
	public static void main(String[] args) {
		int[][] grid = {
				{ 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		test ss = new test();
		flag=new boolean[8][13];
		System.out.println(ss.maxArea(grid));
		
	}
	
	

	private int maxArea(int[][] zone) {
		int res = 0;
		for (int i = 0; i < zone.length; i++) {
			for (int j = 0; j < zone[0].length; j++) {
				int sub = area(zone, i, j);
				res = Math.max(res, sub);
			}
		}
		return res;
	}

	private int area(int[][] zone, int i, int j) {
		if ( i < 0 || j < 0 || i >= zone.length || j >= zone[0].length||flag[i][j] || zone[i][j]==0) {
			return 0;
		}
		flag[i][j] = true;
		int subarea = 1 + area(zone, i - 1, j) + area(zone, i, j + 1) + area(zone, i + 1, j) + area(zone, i, j - 1);
		return subarea;
	}
}
