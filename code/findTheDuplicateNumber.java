// https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1039/

class Solution {
    /*
        n: array length
        time: O(n)
        space: O(1)
    */
    public int findDuplicate(int[] nums) {
        if(nums == null) return -1;
        
        int ADD_FACTOR = nums.length + 1;
        for(int i=0; i<nums.length; i++) {
            int supposedValue = i+1;
            int originalValue = nums[i] % ADD_FACTOR;
            
            if(originalValue == supposedValue) continue;
            
            int indexToGo = originalValue-1;
            
            if(nums[indexToGo] / ADD_FACTOR == originalValue || 
              nums[indexToGo] % ADD_FACTOR == originalValue) return originalValue;
            
            nums[indexToGo] += ADD_FACTOR * originalValue;
        }
        
        return -1;
    }
}
