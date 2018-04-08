package P035_SearchInsertPosition;

public class P035_solution {
	public static void main(String[] args) {
		P035_solution ss = new P035_solution();
		int[] nums = { 1, 3, 5, 6 };
		int target = 7;
		System.out.println(ss.searchPosition(nums, target));
	}

	private int searchPosition(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = lo + ((hi - lo) >> 1); // 防止溢出，移位也更高效
			if (nums[mid] < target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return lo;
	}
}
