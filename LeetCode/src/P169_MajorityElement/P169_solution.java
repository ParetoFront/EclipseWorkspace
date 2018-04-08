package P169_MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class P169_solution {
	public static void main(String[] args) {
		P169_solution ss=new P169_solution();
		System.out.println(ss.majorityElement(new int[] {2,2,3}));
	}
	private int majorityElement(int[] nums) {
		int majorityCount=nums.length/2;
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int num:nums) {
			if(!map.containsKey(num)) {
				map.put(num, 1);
			}else {
				map.put(num, map.get(num)+1);
			}
		}
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			if(entry.getValue()>majorityCount) {
				return entry.getKey();
			}
		}
		throw new IllegalArgumentException();
	}
}
 