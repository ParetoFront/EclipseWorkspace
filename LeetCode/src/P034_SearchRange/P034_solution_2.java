package P034_SearchRange;

import java.util.Arrays;

//用二分法寻找target的左边界和右边界
public class P034_solution_2 {
	public static void main(String[] args) {
		P034_solution_2 s = new P034_solution_2();
		 int[] nums = { 4, 5, 7, 8, 8, 8, 9, 9, 9, 10, 11, 12 };
//		int[] nums = {};
		int target = 13;
		System.out.println(Arrays.toString(s.searchRange(nums, target)));
	}

	private int[] searchRange(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (nums[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		int left = end;
		end = nums.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (nums[mid] > target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		int right = end;
		if (right >= 0 && nums[right] != target) {     //当数组最后一位也为target或数组中无target时，是不用左移一位的
			right--;
		}
		if (left < 0 || nums[left] != target) { // 若数组为空或数组中无target，left为-1
			right = -1;
			left = -1;
		}
		return new int[] { left, right };
	}
}
