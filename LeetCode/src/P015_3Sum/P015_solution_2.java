package P015_3Sum;
//排序，for循环第一个数字，剩下两个数字使用双指针查找
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P015_solution_2 {
	public static void main(String[] args) {
		P015_solution_2 ss = new P015_solution_2();
		// int[] nums= {-1,0,1,2,-1,-4};
		int[] nums = { 0, 0, 0 };
		System.out.println(ss.threeSum(nums));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i + 2 < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
				continue;
			}
			int low = i + 1, high = nums.length - 1;
			int target = -nums[i];
			while (low < high) {
				if (nums[low] + nums[high] == target) {
					res.add(Arrays.asList(nums[i], nums[low], nums[high]));
					low++;
					high--;
					while (low < high && nums[low] == nums[low - 1])
						low++; // skip same result
					while (low < high && nums[high] == nums[high + 1])
						high--; // skip same result
				} else if (nums[low] + nums[high] > target) {
					 while (low < high && nums[low] == nums[low+1]) low++;
					high--;
				} else {
					while (low < high && nums[high] == nums[high-1]) high--;
					low++;
				}
			}
		}
		return res;
	}
}
