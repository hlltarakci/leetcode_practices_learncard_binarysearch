// https://leetcode.com/explore/learn/card/binary-search/135/template-iii/945/

class Solution {
    /*
        n: array length
        time: O(log n + k)
        space: O(1)
    */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null) return null;
        if(arr.length == k) return convert(arr, 0, arr.length);
        
        int left = 0, right = arr.length-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(arr[mid] == x) {
                left = mid;
                break;
            } 
            
            if(arr[mid] < x) left = mid+1;
            else right = mid-1;
        }
        
        // left has the num or closest one
        int index = left;
        if(arr[left] != x) {
            if(left != 0 && Math.abs(arr[left-1] - x) <= Math.abs(arr[left]-x)) 
                index = left-1;
            if(left != arr.length-1 && Math.abs(arr[left+1] - x) < Math.abs(arr[left]-x)) 
                index = left+1;
        }
        
        // expand closest elements to capture k elements
        left = index;
        right = index;
        while(right-left != k) {
            if(left == 0) {
                right++;
                continue;
            }
            
            if(right == arr.length -1) {
                left--;
                continue;
            }
            
            int diffLeft = Math.abs(x - arr[left]);
            int diffRight = Math.abs(arr[right] - x);
            
            if(diffLeft <= diffRight) left--;
            else right++;
        }
        
        // adjust the one extra that breaks the loop
        if( Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ) right--;
        else left++;
        
        
        return convert(arr, left, right+1);
    }
    
    private List<Integer> convert(int[] arr, int start, int end) {
        List<Integer> list = new ArrayList<>();
        for(int i=start; i<end; i++) list.add(arr[i]);
        return list;
    }
}
