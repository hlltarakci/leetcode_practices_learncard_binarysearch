// https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1042/

class Solution {
    /*
        n: array length
        s: sum of elements on array
        time: O(n log s)
        space: O(1);
    */
    public int splitArray(int[] nums, int m) {
        long low = 0, high = 0;
        for(int num: nums) {
            if(num > low) low = num;
            high += num;
        }
        
        long minSum = high;
        while(low <= high) {
            long mid = low + (high-low)/2;
            
            long sum=0;
            int count=1;
            for(int temp: nums) {
                if(sum + temp > mid) {
                    count++;
                    sum = temp;
                } 
                else sum += temp;
            }
            
            if( count <= m )  {
                minSum = Math.min(minSum, mid);
                high = mid-1;
            }
            else low = mid+1;
        }
        
        return (int)minSum;
    }
}
