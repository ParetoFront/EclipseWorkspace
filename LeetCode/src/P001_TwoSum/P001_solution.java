package P001_TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P001_solution {
	public static void main(String[] args) {
		int[] n = new int[] { 1, 2, 3, 4, 5, 6 };
		int t = 10;
		P001_solution ss = new P001_solution();
		System.out.println(Arrays.toString(ss.twosum(n, t)));
		System.out.println(Arrays.toString(ss.twosum_2(n, t)));
	}

	public int[] twosum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i + 1);
		}
		for (int i = 0; i < nums.length; i++) {
			int left = target - nums[i];
			if (map.containsKey(left) && (map.get(left) != i)) {
				return new int[] { i + 1, map.get(left) };
			}
		}
		throw new IllegalArgumentException("no such P001_solution");
	}
	//map方法的改进
	 public int[] twosum_2(int[] nums, int target) {
	        Map<Integer, Integer> map = new HashMap<>();
	        for (int i = 0; i < nums.length; i++) {
	            int left = target - nums[i];
	            if (map.containsKey(left)) {
	            	if(map.get(left)<i) {    //map随循环增长，可能出现回溯，需要判断一下先后顺序
	            		return new int[] {map.get(left),i+1};
	            	}
	                return new int[]{i + 1, map.get(left)};
	            }
	            map.put(nums[i], i + 1);
	        }
	        throw new IllegalArgumentException("no such P001_solution");
	    }

}
