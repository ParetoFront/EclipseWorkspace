package P026_RemoveDuplicates;

import java.util.Arrays;

public class P026_solution {
	public static void main(String[] args) {
		int[] nums = { 1,2, 2, 3, 3,3,3, 4 };
		P026_solution ss = new P026_solution();
		// System.out.println(ss.removeDuplicates(nums));
		System.out.println(Arrays.toString(ss.removeDuplicates(nums)));
	}

	private int[] removeDuplicates(int[] nums) {
		int j = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				j++;
				nums[j] = nums[i];
			}	
		}
		return nums;
	}
}
