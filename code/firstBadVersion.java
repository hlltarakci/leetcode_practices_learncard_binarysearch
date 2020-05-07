// https://leetcode.com/explore/learn/card/binary-search/126/template-ii/947/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    /*
        time: O(log n)
        space: O(1)
    */
    public int firstBadVersion(int n) {
        int left = 0, right = n;
        while(left < right) {
            int mid = left + (right-left)/2;
            
            if(isBadVersion(mid))  right = mid;
            else left = mid+1;
        }
        
        return left;
    }
}
