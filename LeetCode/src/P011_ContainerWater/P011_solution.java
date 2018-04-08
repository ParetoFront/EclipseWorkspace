package P011_ContainerWater;
/*
 * 思路：先保证底最长，再考虑高。即从两侧开始，较小的边内移。这样在保证底最长的情况下追求更高的高。
 * 如果是先保证高最高，则向外扩展底的时候讨论高度非常麻烦。
*/
public class P011_solution {
	public static void main(String[] args) {
		P011_solution ss=new P011_solution();
		System.out.println(ss.maxContain(new int[] {1,1}));
	}
	private int maxContain(int[] height) {
		 int maxarea=0,i=0,j=height.length-1;
		 while(i<j){
			 int area=Math.min(height[i], height[j])*(j-i);
			 maxarea=Math.max(area, maxarea);
			 if(height[i]<height[j]) {
				 i++;
			 }else if(height[i]==height[j]) {
				 i++;
				 j--;
			 }else {
				 j--;
			 }
		 }
		 return maxarea;
	}
}
