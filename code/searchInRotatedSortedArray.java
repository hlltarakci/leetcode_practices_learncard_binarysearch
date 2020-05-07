// https://leetcode.com/explore/learn/card/binary-search/125/template-i/952/

class Solution {
    /*
        n: arr length
        time: O(log n)
        space: O(1)
    */
    public int search(int[] nums, int target) {
        if(nums == null) return -1;
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            
            if(nums[mid] == target) return mid;
            
            if(nums[right] < nums[mid]) {
                if(nums[left] <= target && target < nums[mid]) right = mid-1; 
                else left = mid+1;
            }
            else{
                if(nums[right] >= target && target > nums[mid])  left = mid+1; 
                else right = mid-1; 
            }
            
        }
        
        return -1;
    }
}
