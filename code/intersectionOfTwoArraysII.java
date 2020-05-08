// https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1029/

class Solution {
    /*
        l : length of larger array
        s : length of smaller array
        time: O(l log l + s log s) 
        space: O(s) -- list usage, could be eliminated by using the larger array to keep result
    */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] larger = nums1.length >= nums2.length ? nums1 : nums2;
        int[] smaller = nums1.length >= nums2.length ? nums2 : nums1;
        
        int iL = 0, iS = 0;
        while(iL < larger.length || iS < smaller.length) {
            long valueL = iL < larger.length ? larger[iL] : Long.MAX_VALUE;
            long valueS = iS < smaller.length ? smaller[iS] : Long.MAX_VALUE;
            
            if(valueL == valueS) {
                list.add((int)valueL);
                iL++;
                iS++;
            } 
            else if(valueL < valueS) iL++;
            else iS++;
        }
        
        return convert(list);
    }
    
    private int[] convert(List<Integer> list) {
        int[] arr = new int[list.size()];
        for(int i=0; i<arr.length; i++)
            arr[i] = list.get(i);
        
        return arr;
    }
}
