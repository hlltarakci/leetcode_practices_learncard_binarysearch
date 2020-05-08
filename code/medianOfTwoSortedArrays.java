// https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1040/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smaller = nums1.length < nums2.length ? nums1 : nums2;
        int[] larger = nums1.length >= nums2.length ? nums1 : nums2;
        int len = smaller.length + larger.length;
        int halfWay = (len+1)/2;
        
        int low=0, high=smaller.length;
        while(low <= high) {
            int mid = low + (high-low)/2;
            int other = halfWay - mid;
            
            if(mid < high && larger[other-1] > smaller[mid]) low = mid+1;
            else if( mid > low && larger[other] < smaller[mid-1]) high = mid-1;
            else {
                int maxLeft = 0;
                if (mid == 0) { maxLeft = larger[other-1]; }
                else if (other == 0) { maxLeft = smaller[mid-1]; }
                else { maxLeft = Math.max(smaller[mid-1], larger[other-1]); }
                if ( len % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (mid == smaller.length) { minRight = larger[other]; }
                else if (other == larger.length) { minRight = smaller[mid]; }
                else { minRight = Math.min(larger[other], smaller[mid]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        
        return 0.0;
    }
}
