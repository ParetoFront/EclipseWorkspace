package P027_RemoveElement;

public class P027_solution {
	public static void main(String[] args) {
		int[] nums= {3,2,2,3};
		P027_solution ss=new P027_solution();
		System.out.println(ss.removement(nums, 3));
	}
		public int removement(int[] nums,int val) {
			int j=0;
			for(int i=0;i<nums.length;i++) {
				if(nums[i]!=val) {
					nums[j++]=nums[i];
				}
			}
			return j;
		}
}
