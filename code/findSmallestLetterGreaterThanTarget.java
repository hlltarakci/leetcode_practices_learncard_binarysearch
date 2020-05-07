// https://leetcode.com/explore/learn/card/binary-search/137/conclusion/977/

class Solution {
    /*
        n: num of array
        time: O(log n)
        space: O(1)
    */
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length;
        while(left < right) {
            int mid = left + (right-left)/2;
            if(letters[mid] <= target) left = mid+1;
            else right = mid;
        }
        
        return letters[left % letters.length];
    } 
}
