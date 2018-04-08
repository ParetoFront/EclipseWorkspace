package P283_MoveZeros;

//思路2：设置left与right。right随循环移动。left遇到非零则移动，遇到0不动。这样left会在遇0时落在right后面
//并且在遇到0时，进行left与right所在位置数字互换
//效果为right会将非零值不断调到left，0最终移到末尾

public class P283_solution2 {
	public static void main(String[] args) {
		P283_solution2 ss = new P283_solution2();
		int[] a=new int[] {1,0,2,0,0,3,0,4,0};
		ss.movement(a);
	}

	public void movement(int[] nums) {
		if (nums == null || nums.length <= 1) return;
        int left = 0; 
        int right = 0;
        while (right < nums.length){
            if (nums[right] != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
    }
	}

