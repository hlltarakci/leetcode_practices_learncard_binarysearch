// https://leetcode.com/explore/learn/card/binary-search/126/template-ii/949/

class Solution {
    /*
        n: array length
        time: O(log n)
        space: O(1)
    */
    public int findMin(int[] nums) {
        if(nums == null) return -1;
       
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            
            if(nums[left] <= nums[right]) return nums[left];
            if( mid!= 0 && nums[left] <= nums[mid-1] && nums[mid] <= nums[right]) return nums[mid];
            
            if(nums[mid] < nums[right]) right = mid-1;
            else left = mid+1;
        }
        
        return -1;
    }
}
