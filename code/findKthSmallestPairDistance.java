// https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1041/

class Solution {
    /*
        n: array length
        w: diff bw min and max element
        time: O(n log n + n log w) 
        space: O(1)
    */
    public int smallestDistancePair(int[] nums, int k) {
        if(nums == null) return -1;
        
        Arrays.sort(nums);
        
        int low = 0, high = nums[nums.length-1] - nums[0];
        while(low < high) {
            int mid = low + (high-low)/2;
            
            int count = 0, left = 0;
            for(int right = 0; right < nums.length; ++right) {
                while(nums[right] - nums[left] > mid) left++;
                count += (right-left);
            }
            if(count >= k) high = mid;
            else low = mid+1;
        }
        
        return low;
    }
}
