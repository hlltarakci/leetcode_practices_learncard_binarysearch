// https://leetcode.com/explore/learn/card/binary-search/125/template-i/950/

class Solution {
    /*
        time: O(log x)
        space: O(1)
    */
    public int mySqrt(int x) {
        if(x < 2) return x;
        
        int left = 1, right = x/2;
        
        while(left <= right) {
            int mid = left + (right-left) / 2;
            long square = (long)mid * (long)mid;
            
            if(square == x) return mid;
            
            if(square < x) left = mid+1;
            else right = mid-1;
        }
        
        return (long)left* (long)left > x ? left-1 : left;
    }
}
