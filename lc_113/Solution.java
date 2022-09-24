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
    public void dfs(TreeNode node, List<List<Integer>> P, List<Integer> p, int sum){                
        if(node != null){
            p.add(node.val);
            // base case
            if(node.left == null && node.right == null && node.val == sum){
                List<Integer> temp = new ArrayList<Integer>(p);
                P.add(temp);
            }
            else{
                dfs(node.left, P, p, sum-node.val);
                dfs(node.right, P, p, sum-node.val);
            }
            p.remove(p.size()-1);
        }
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> P = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        dfs(root, P, p, targetSum);
        
        return P;
    }
}
