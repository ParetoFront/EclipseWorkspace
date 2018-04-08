
public class P003 {
	public static void main(String[] args) {
		int[][] nums = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		int target = 6;
		P003 pp = new P003();
		System.out.println(pp.fun(nums, target, 0, 3));
	}

	public boolean fun(int[][] nums, int target, int row, int col) {
		while (row < nums.length && col >= 0) {
			int x = nums[row][col];
			if (x == target) {
				return true;
			} else if (x > target) {
				col--;
				fun(nums, target, row, col);
			} else {
				row++;
				fun(nums, target, row, col);
			}
		}
		return false;
	}
}
