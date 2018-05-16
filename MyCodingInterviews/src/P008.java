import org.junit.Test;
//求旋转数组的最小值
public class P008 {
	@Test
	public void fun() {
		int[] nums = { 2, 3, 4, 5, 6, 7, 8, 9, 10 ,1};
		System.out.println(findMin(nums));
	}

	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		//若末尾数大于起始数，说明没有旋转
		if(nums[nums.length-1]>nums[0]) {
			return nums[0];
		}
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		int target = nums[0];
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (nums[mid] >= target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return nums[left];
	}

	// 查询小于等于target的最大值
	public int findKey2(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (nums[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}
		return left;

	}

	@Test
	public void fun2() {
		int[] nums = { 1, 2, 3, 3, 4, 5 };
		int target = 3;
		int x = findKey2(nums, target);
		System.out.println(x);
	}

	// 查找大于等于target的最小值
	public int findKey3(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (nums[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}

	@Test
	public void fun3() {
		int[] nums = { 1, 2, 3, 3, 4, 5 };
		int target = 3;
		int x = findKey3(nums, target);
		System.out.println(x);
	}
}
