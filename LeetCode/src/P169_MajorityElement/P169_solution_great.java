package P169_MajorityElement;

import java.util.Arrays;
//既然主元素数目大于n/2，则num排序后去中间位置值必为主元素
public class P169_solution_great {
	public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
