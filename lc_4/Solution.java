class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);
        
        int k = (n1 + n2 + 1) / 2;
        int l = 0;
        int r = n1;
        
        while (l < r) {
            int m1 = (l+r) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1])
                l = m1 + 1;
            else
                r = m1;
        }
        
        int m1 = l;
        int m2 = k - l;
        
        int c1, c2;
        if(m1<=0)
            c1 = nums2[m2 - 1];
        else if(m2<=0)
            c1 = nums1[m1 - 1];
        else
            c1 = Math.max(nums1[m1 - 1], nums2[m2 - 1]);
        
        if((n1 + n2) % 2 == 1)
            return c1;
        
        if(m1>=n1)
            c2 = nums2[m2];
        else if(m2>=n2)
            c2 = nums1[m1];
        else
            c2 = Math.min(nums1[m1], nums2[m2]);
        
        double ret = (double) (c1 + c2)/2;
        return ret;
    }
}
