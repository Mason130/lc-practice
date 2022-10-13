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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        return build(list, 0, list.size()-1);
    }
    
    public void dfs(TreeNode node, ArrayList<Integer> list){
        if(node == null)
            return;
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
    
    public TreeNode build(ArrayList<Integer> list, int l, int r){
        if (l> r) 
            return null;
        int m = (l + r) / 2;
        TreeNode root = new TreeNode(list.get(m));
        root.left = build(list, l, m - 1);
        root.right = build(list, m + 1, r);
        return root;
    }
}
