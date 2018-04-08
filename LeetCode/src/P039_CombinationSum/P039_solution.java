package P039_CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P039_solution {
	public static void main(String[] args) {
		P039_solution ss=new P039_solution();
		int[] candidates= {2,3,5,7};
		int target=7;
		for(List<Integer> list:ss.combination(candidates, target)) {
			System.out.println(list);
		}
	}
	private List<List<Integer>> combination(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		findCombin(candidates, res, list, target, 0);
		return res;

	}

	private void findCombin(int[] candidates, List<List<Integer>> res, List<Integer> list, int target, int pos) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(list));  //此处必须新建一个数组添加到res中，因为后续操作会继续对list进行修改
		}
		for (int i = pos; i < candidates.length; i++) {
			if (candidates[i] > target) {
				break; 
			}
			list.add(candidates[i]);
			findCombin(candidates, res, list, target - candidates[i], i);
			list.remove(list.size() - 1);

		}

	}
}
