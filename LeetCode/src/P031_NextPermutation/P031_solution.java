package P031_NextPermutation;

import java.util.Arrays;

//思路：例如字符串nums=354321，找到下一个较大排列的方法应该是：
//第一步：从低位向高位寻找第一个下降的数字nums[0]，即‘3’54321
//第二步：从低位向高位寻找第一个比选中数字大的数字nums[2]，即35‘4’321
//第三步：将两者互换，得到nums=453321
//第四步：完成第三步后，nums[0]右边的数字串53321已经达到最大值，需要对其reverse
public class P031_solution {
	public static void main(String[] args) {
		P031_solution ss = new P031_solution();
		int[] nums = { 3, 5, 4, 3, 2, 1 };
		ss.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

	private void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		//while (nums[i] <= nums[i - 1] && i > 0 ) 是不对的
		//遇到nums[i-1]此类情况，必须先考虑i-1是否符合要求，避免nums[i-1]超出界限
		while (i >= 0 && nums[i] >= nums[i + 1]) {  
			i--;
		}
		if (i >= 0) {           //此项意在排除nums只含一个数的情况
			int j = nums.length - 1;
			while (nums[j] <= nums[i] && j > i) {
				j--;
			}
			swap(nums, i, j);
		} 
		reverse(nums,i+1);
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[j];
		nums[j] = nums[i];
		nums[i] = tmp;
	}

	private void reverse(int[] nums,int start) {
		int x=start;
		int y = nums.length-1;
		while (x < y) {
			swap(nums, x, y);
			x++;
			y--;
		}
	}
}
