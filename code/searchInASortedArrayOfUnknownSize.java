// https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/1061/

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    /*
        time: O( math.abs(target-arr[0]) )
        space: O(1)
    */
    public int search(ArrayReader reader, int target) {
        int left = 0, right = target - reader.get(0);
        while(left <= right) {
            int mid = left + (right-left) / 2;
            int val = reader.get(mid);
            if(val == target) return mid;
            if(val < target) left = mid+1;
            else right = mid-1;
        }
        
        return -1;
    }
}
