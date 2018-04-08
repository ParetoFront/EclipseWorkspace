package P448_FindDisappearedNum;

import java.util.LinkedList;
import java.util.List;

public class P448_solution {
	public static void main(String[] args) {
		P448_solution ss=new P448_solution();
		System.out.println(ss.findDisappearNum(new int[] {1,2,3}));
	}
	private List<Integer> findDisappearNum(int[] nums) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		for(int num:nums) {
			if(list.contains(num)) {
				list.remove((Integer)num);   //remove可以传入index或object，直接传入int会被认为是index，此处要标明数据类型，
			}
		}
		return list;
	}
}
