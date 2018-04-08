package P018_4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P018_solution {
	public static void main(String[] args) {
		P018_solution ss = new P018_solution();
		int[] nums = { 1,4,-3,0,0,0,5,0 };
		int target = 0;
		System.out.println(ss.fourSum(nums, target));
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> res = new ArrayList<>();
		if (nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				int low = j + 1, high = nums.length - 1;
				while (low < high) {
					int sum = nums[i] + nums[j] + nums[low] + nums[high];
					if (sum == target) {
						List<Integer> sub = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
						if (!res.contains(sub)) {
							res.add(sub);
						}
						low++;
						high--;
					} else if (sum > target) {
						high--;
					} else {
						low++;
					}
				}
			}
		}
		return res;
	}
}
