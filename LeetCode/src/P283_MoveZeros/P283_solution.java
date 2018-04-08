package P283_MoveZeros;

import java.util.Arrays;

//将数组中的0移到末尾，要求不开辟新空间
//要点是如何一边循环一边在原数组上进行编辑

public class P283_solution {
	public static void main(String[] args) {
		P283_solution ss = new P283_solution();
		System.out.println(Arrays.toString(ss.movement(new int[] { 1, 0, 2, 0, 3, 4, 0, 5 })));
	}

	public int[] movement(int[] nums) {
		int index = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[index++] = num;
			}
		}
		while (index < nums.length) {
			nums[index++] = 0;
		}
		return nums;
	}
}
