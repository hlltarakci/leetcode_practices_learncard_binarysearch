// https://leetcode.com/explore/learn/card/binary-search/138/background/1038/

class Solution {
    /*
        n: nums length
        time: O(log n)
        space: O(log n) -- recursion stack
    */
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }
    
    private int binarySearch(int[] nums, int target, int left, int right) {
        if(left > right) return -1;
    
        int mid = left + (right-left)/2;
        if(nums[mid] == target) return mid;
        
        if(nums[mid] > target) return binarySearch(nums, target, left, mid-1);
        
        return binarySearch(nums, target, mid+1, right);
    }
}
