// https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1035/

class Solution {
    /*
        n: length of array
        time: O(n)
        space: O(1)
    */
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) return null;
        int left = 0, right = numbers.length-1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) return new int[] {left+1, right+1};
            if(sum > target) right--;
            else left++;
        }
        return null;
    }
}

