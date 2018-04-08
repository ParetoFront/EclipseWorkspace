package P485_MaxConsecutiveNum;
//找出由0和1组成的数组中连续1的最长长度
public class P485_solution {
	public static void main(String[] args) {
		P485_solution ss=new P485_solution();
		
		System.out.println(ss.findMaxConsecutiveOnes(new int[] {1}));
	}
	public int findMaxConsecutiveOnes(int[] nums) {
		int maxlen=0;
		int i=0;
		int len=0;
		while(i<nums.length) {
			if(nums[i]==1) {
				len++;
				maxlen=Math.max(maxlen, len);
			}else {
				len=0;
			}
			i++;
		}
		return maxlen;
	}
}
