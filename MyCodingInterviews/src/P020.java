import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//由外向里顺时针打印一个矩阵
public class P020 {
	// public void printMat(int[][] nums) {
	//
	// if (nums.length % 2 != 0) {
	// if (nums[0].length % 2 != 0) {
	// int index = nums.length < nums[0].length ? nums.length / 2 : nums[0].length /
	// 2;
	// for (int i = 0; i < index; i++) {
	// printAround(nums, i);
	// }
	// if(nums.length>nums[0].length) {
	// while()
	// }
	// return;
	// }
	// }
	// int index = nums.length < nums[0].length ? nums.length / 2 : nums[0].length /
	// 2;
	// for (int i = 0; i < index; i++) {
	// printAround(nums, i);
	// }
	// }

	@Test
	public void fun() {
		int[][] nums = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 }, { 13, 14, 15 } };

		int index = nums.length < nums[0].length ? nums.length / 2 : nums[0].length / 2;
		for (int i = 0; i <= index; i++) {
			printAround(nums, i);
		}
		List<Integer> list=new ArrayList<Integer>();
	}

	public void printAround(int[][] nums, int i) {
		int row = i;
		int col = i;
		while (col < nums[0].length - i ) {
			System.out.println(nums[row][col]);
			col++;
		}
		row++;
		col--;
		while (row < nums.length - i) {
			System.out.println(nums[row][col]);
			row++;
		}
		row--;
		col--;
		while (col >= i) {
			System.out.println(nums[row][col]);
			col--;
		}
		col++;
		row--;
		while (row > i) {
			System.out.println(nums[row][col]);
			row--;
		}

	}
}
