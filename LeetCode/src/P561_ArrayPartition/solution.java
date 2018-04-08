package P561_ArrayPartition;

import java.util.Arrays;
//熟练使用Arrays的方法
public class solution {
	public static void main(String[] args) {
		solution ss=new solution();
		int result=ss.arrayPairSum(new int[] {1,3,2,4});
		System.out.println(result);
	}
	
	public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}
