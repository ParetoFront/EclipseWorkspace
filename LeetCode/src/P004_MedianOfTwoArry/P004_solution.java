package P004_MedianOfTwoArry;



public class P004_solution {
    public static void main(String[] args) {
        System.out.println(new P004_solution().findMedianSortedArrays(new int[]{2,3},new int[]{1}));
    }
    double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m)  
            return findMedianSortedArrays(nums2, nums1);
        int L1=0, L2=0, R1=0, R2=0, c1, c2, low = 0, high = 2 * n; 
        while (low <= high)  
        {
            c1 = (low + high) / 2;  
            c2 = m + n - c1;
            if (c1 == 0) L1 = Integer.MIN_VALUE;   //map to original element
            else L1 = nums1[(c1 - 1) / 2];   //map to original element
            if (c1 == 2 * n) R1 = Integer.MAX_VALUE;
            else R1 = nums1[c1 / 2];
            if (c2 == 0) L2 = Integer.MIN_VALUE;
            else L2 = nums2[(c2 - 1) / 2];
            if (c2 == 2 * m) R2 = Integer.MAX_VALUE;
            else R2 = nums2[c2 / 2];

            if (L1 > R2)
                high = c1 - 1;
            else if (L2 > R1)
                low = c1 + 1;
            else
                break;
        }
        return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
    }
}

