// https://leetcode.com/explore/learn/card/binary-search/137/conclusion/982/

class Solution {
    /*
        time: O(log n)
        space: O(log n) -- recursion stack
    */
    public double myPow(double x, int n) {
        if(n < 0) {
            x = 1/x;
            n = -n;
        }
        
        return pow(x, n);
    }
    
    private double pow(double x, int n) {
        if(n == 0) return 1;
        
        double nPow = pow(x, n/2);
        if(n % 2 == 0) 
            return nPow * nPow;
        else 
            return nPow * nPow * x;
    }
}
