// https://leetcode.com/explore/learn/card/binary-search/126/template-ii/948/

class Solution {
    /*
        n: array length
        time: O(log n)
        space: O(1)
    */
    public int findPeakElement(int[] nums) {
        if(nums == null) return -1;
        
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = left + (right-left)/2;
            
            if(nums[mid] > nums[mid+1]) right = mid;
            else left = mid+1;
        }
        
        return left;
    }
}
