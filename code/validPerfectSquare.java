// https://leetcode.com/explore/learn/card/binary-search/137/conclusion/978/

class Solution {
    /*
        time: O(log n)
        space: O(1)
    */
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        
        int left=0, right = num/2;
        while(left <= right) {
            int mid = left + (right-left)/2;
            
            long square = (long)mid* (long)mid;
            
            if(square == num) return true;
            
            if(square < num) left = mid+1;
            else right = mid-1;
        }
        
        return false;
    }
}
