// https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/1028/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
        n: num of nodes
        time: O(log n) -- assuming balanced tree
        space: O(1)
    */
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        
        while(root != null) {
            double diffClosest = Math.abs(closest - target);
            double diffVal = Math.abs(root.val - target);
            
            if(diffVal < diffClosest) closest = root.val;
            
            if(root.val < target) root = root.right;
            else root = root.left;
        }
        
        return closest;
    }
}

