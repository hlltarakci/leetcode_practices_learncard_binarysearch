// https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1031/

class Solution {
    /*
        n: array length
        time: O(log n) -- if many duplicates items, could go up to O(n)
        space: O(1)
    */
    public int findMin(int[] nums) {
        if(nums == null) return -1;
        
        int left = 0, right = nums.length-1;
        
        // is rotation cuts duplicate element, break this
        while(nums[left] == nums[right] && left < right) left++;
        
        while(left < right) {
            int mid = left + (right-left)/2;
            if(nums[left] <= nums[right]) return nums[left];
            
            if(nums[left] <= nums[mid]) left = mid+1;
            else right = mid;
        }
        
        return nums[left];
    }
}
