package P034_SearchRange;

import java.util.Arrays;

public class P034_solution {
	public static void main(String[] args) {
		P034_solution ss=new P034_solution();
		int[] nums = { 4, 5, 7, 8, 8, 8, 9, 9, 9, 10, 11, 12 };
		int target = 8;
		System.out.println(Arrays.toString(ss.searchRange(nums, target)));
	}
	private int[] searchRange(int[] nums,int target) {
		int left=findleft(nums,target);
		return new int[] {left,0};
	}
	private int findleft(int[] nums,int target) {
		int start=0,end=nums.length-1;
		while(start<end) {
			int mid=(start+end)/2;
			if(nums[mid]>=target) {
				end=mid;
			}else {
				start=mid+1;
			}
		}
		return start;
	}
}
