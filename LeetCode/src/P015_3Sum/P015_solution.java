package P015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//for循环第一个数，转化为2sum问题。依然用map做。这个方法非常耗时
public class P015_solution {
	public static void main(String[] args) {
		P015_solution ss = new P015_solution();
//		int[] nums= {-1,0,1,2,-1,-4};
		int[] nums = { 0, 0, 0 };
		System.out.println(ss.threeSum(nums));
	}

	private List<List<Integer>> threeSum(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums); // 非常重要，用于排除重复，例如main中例子，{-1,0,1}和{0,1,-1}是重复的
		for (int i=0;i<nums.length;i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
				continue;
			}
			for (int j = i + 1; j < nums.length - 1; j++) {
				int left = 0 - nums[i] - nums[j];
				if (map.containsKey(left) && map.get(left) > j) {
//					ArrayList<Integer> sublist = new ArrayList<>();
//					sublist.add(nums[i]);
//					sublist.add(nums[j]);
//					sublist.add(left);
//					res.add(sublist);
					res.add(Arrays.asList(nums[i], nums[j], left));   //快捷输入数组
				}
			}
		}
		return res;
	}
}
