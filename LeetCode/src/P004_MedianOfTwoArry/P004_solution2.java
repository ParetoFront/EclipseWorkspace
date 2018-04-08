package P004_MedianOfTwoArry;

public class P004_solution2 {
    public static void main(String[] args) {
        int[] a=new int[]{2,3};
        int[] b=new int[]{1};
        System.out.println(new P004_solution2().findMedian(a,b));
    }

    public double findMedian(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedian(nums2, nums1);   //保证nums1是较短的数组，方便进行二分
        }
        //两个有序数组中的中位数和Top K问题
        // http://blog.csdn.net/hk2291976/article/details/51107778
        int length1 = 2 * nums1.length;
        int length2 = 2 * nums2.length;
        int start = 0;
        int end= length1;
        int left1=0,right1=0,left2=0,right2=0;
        int halfLen = (length1 + length2) / 2;  //获得二分法需要的中间位置
        while (start <= end) {
            int i = (start + end) / 2;
            int j = halfLen - i;

            if(i==0){
                left1=Integer.MIN_VALUE;
            }else{
                left1=nums1[(i-1)/2];
            }

            if(i==length1){
                right1=Integer.MAX_VALUE;
            }else{
                right1=nums1[i/2];
            }

            if(j==0){
                left2=Integer.MIN_VALUE;
            }else{
                left2=nums2[(j-1)/2];
            }

            if(j==length2){
                right2=Integer.MAX_VALUE;
            }else{
                right2=nums2[j/2];
            }

            if(left1>right2){
                end=i-1;      //这样在下一次循环时i = (start + end) / 2,实现了二分
            } else if(left2>right1){    //这里必须使用else if，否则若两种情况同时出现，会导致start与end同时变化
                start=i+1;
            }else{
                break;   //已经到达目标状态，即l1<r2,l2<r1,可以退出循环，进行输出
            }
        }
        return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
    }
}
