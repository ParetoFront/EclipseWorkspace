package P016_3sumClosest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//求最接近target的sum，假定只有一个解
public class P016_solution {
	public static void main(String[] args) {
		P016_solution ss=new P016_solution();
		int target=3;
		int[] nums= {-1,0,1,1,55};
		System.out.println(ss.threeSumClosest(nums, target));
	}
	public int threeSumClosest(int[] nums,int target) {
		Arrays.sort(nums);
		int minerr=Integer.MAX_VALUE;
		int res=0;
		for (int i = 0; i + 2 < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
				continue;
			}
			int low = i + 1, high = nums.length - 1;
			while (low < high) {
				int sum=nums[low] + nums[high] +nums[i];
				if (sum== target) {
					return target;
				} else if (sum > target) {
					if(minerr>Math.abs(sum-target)) {
						minerr=Math.abs(sum-target);
						res=sum;
					}
					 while (low < high && nums[high] == nums[high-1]) high--;  // skip same result
					high--;
				} else {
					if(minerr>Math.abs(sum-target)) {
						minerr=Math.abs(sum-target);
						res=sum;
					}
					while (low < high && nums[low] == nums[low+1]) low++;    // skip same result
					low++;
				}
			}
		}
		return res;
	}
}
