package P448_FindDisappearedNum;

//要求不增加空间复杂度
import java.util.ArrayList;
import java.util.List;

public class P448_solution_better {
	// 取余法。数组的元素范围为1~n。
	// 第一次循环:每当某元素出现，则在该元素应在的位置加上n+1；
	// 第二次循环:把每个位置除以（n+1），如果该位置为0，表示某个元素没有出现；如果该位置等于2，表示出现两次。
	// 原理：在第一次循环中，我们其实是将每个位置变成k*(n+1)+i，
	// 其中k表示该位置加（n+1）的次数，取值为0、1、2，
	// 因为i的范围是1~n，所以除以（n+1）就等于0，从而我们就获得了k的值。
	// 根据k的值，我们就很容易知道哪些元素没有出现，哪些元素出现了多次。
	public static void main(String[] args) {
		P448_solution_better ss = new P448_solution_better();
		System.out.println(ss.findDisappearNum(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
	}

	private List<Integer> findDisappearNum(int[] nums) {
		int len = nums.length;
		int n = len + 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			nums[nums[i] % n - 1] += n; // 这里务必要%n，因为经过之前的循环，该位置的值可能已经加了n，需要%n来获得原始值
		}

		for (int i = 0; i < len; i++) {
			if (nums[i] / (len + 1) == 0) {
				list.add(i + 1);
			}
		}
		return list;
	}
}
