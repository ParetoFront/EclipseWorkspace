package P033_SearchInRotatedSortNums;
//先用二分法找到最小值所在位置，然后使用二分法查找target
public class P033_solution {
	public static void main(String[] args) {
		P033_solution ss=new P033_solution();
		int[] nums= {1,3};
		int target=2;
		System.out.println(ss.searchNum(nums, target));
	}
	private int searchNum(int[] nums,int target) {
		int minIndex=findMinNumIndex(nums);
		int start=0,end=nums.length-1;
//		不能使用下列判断方式，因为如果用nums[0]比较，当minIndex正好是0时，会发生错误。
//		要用nums[0]做判断，应该找到maxIndex
//		
//		if(nums[0]<=target) {   
//			end=minIndex;
//		}else {
//			start=minIndex;
//		}
		if(nums[end]>=target) {
			start=minIndex;
		}else {
			end=minIndex;
		}
		while(start<end) {
			int mid=(start+end)/2;
			if(nums[mid]<target) {
				start=mid+1;
			}else {
				end=mid;
			}
		}
		return start;
//		while(start<=end) {
//			int mid=(start+end)/2;
//			if(nums[mid]>target) {
//				end=mid-1;
//			}else if(nums[mid]<target){
//				start=mid+1;
//			}else {
//				return mid;
//			}
//		}
//		return -1;
	}
	
	private int findMinNumIndex(int[] nums) {
		int start=0,end=nums.length-1;
		while(start<end) {
			int mid=(start+end)/2;
			if(nums[mid]>nums[end]) {
				start=mid+1;
			}else {
				end=mid;
			}
		}
		return start;
	}
}
