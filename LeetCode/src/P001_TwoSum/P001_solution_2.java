package P001_TwoSum;

//这题要求输出数字位置信息，不能使用sort，方法二无效。若要求输出数字组合，则可用。
//方法二：排序，然后双指针法寻找
import java.util.Arrays;

public class P001_solution_2 {
	public static void main(String[] args) {
		int[] n = new int[] { 3, 2, 4 };
		int t = 6;
		P001_solution_2 ss = new P001_solution_2();
		System.out.println(Arrays.toString(ss.twosum(n, t)));
	}

	public int[] twosum(int[] nums, int target) {
		Arrays.sort(nums);
		int i = 0, j = nums.length - 1;
		while (i < j) {
			if (nums[i] + nums[j] == target) {
				return new int[] { nums[i], nums[j] };
			} else if (nums[i] + nums[j] > target) {
				while (i < j && nums[j - 1] == nums[j]) {
					j--;
				}
				j--;
			} else {
				while (i < j && nums[i] == nums[i + 1]) {
					i++;
				}
				i++;
			}
		}
		throw new IllegalArgumentException();
	}

}
