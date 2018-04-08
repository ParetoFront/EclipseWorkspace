package P018_4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//究极去重
public class P018_solution2 {
	public static void main(String[] args) {
		P018_solution2 ss = new P018_solution2();
		int[] nums = {1,4,-3,0,0,0,5,0 };
		int target = 0;
		System.out.println(ss.fourSum(nums, target));
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> res = new ArrayList<>();
		if (nums.length < 4) {return res;}
		Arrays.sort(nums);
		if (4 * nums[0] > target || 4 * nums[nums.length - 1] < target) {return res;}

		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {continue;}
			if (4 * nums[i] > target) {break;}
			if (4 * nums[i] == target) {
				if (i + 3 > nums.length - 1 || nums[i + 3] != nums[i])  {break;}
				}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i+1 && nums[j] == nums[j - 1]) {   continue;}
				int low = j + 1, high = nums.length - 1;
				while (low < high) {
					int sum = nums[i] + nums[j] + nums[low] + nums[high];
					if (sum == target) {
						// res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
						List<Integer> sub = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
						if (!res.contains(sub)) {
							res.add(sub);
						}
						low++;
						high--;
					} else if (sum > target) {
						while (high < nums.length - 1 && nums[high] == nums[high - 1]) {          // 去重
							high--;
						}
						high--;
					} else {
						while (low > j + 1 && nums[low] == nums[low + 1]) {                        // 去重
							low++;
						}
						low++;
					}
				}
			}
		}
		return res;
	}
}
