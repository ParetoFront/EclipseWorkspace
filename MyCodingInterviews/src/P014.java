import org.junit.Test;

/*
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
 */
public class P014 {
	@Test
	public void fun() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		for (int i : manageNums(nums)) {
			System.out.println(i);
		}
	}
	public int[] manageNums(int[] nums) {
		if (nums == null || nums.length < 2) {
			return nums;
		}
		int end = nums.length - 1;
		int start = 0;
		while (start < end) {
			while (start < end && nums[start] % 2 != 0) {
				start++;
			}
			while (start < end && nums[end] % 2 == 0) {
				end--;
			}
			int tmp = nums[end];
			nums[end] = nums[start];
			nums[start] = tmp;

		}
		return nums;
	}
}
