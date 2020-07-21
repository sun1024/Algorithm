/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 *
 * https://leetcode-cn.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (49.69%)
 * Likes:    384
 * Dislikes: 0
 * Total Accepted:    117.3K
 * Total Submissions: 230.5K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \      \
 * ⁠       7    2      1
 * 
 * 
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 递归的用sum-cur.val，到叶子时减到0即存在路径
// class Solution {
//     public boolean hasPathSum(TreeNode root, int sum) {
//         if(root == null) return false;
//         if(root.left == null && root.right == null) return sum-root.val == 0;
//         // return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val); 
//         // 找到了就返回true
//         if(hasPathSum(root.left, sum-root.val)) return true;
//         return hasPathSum(root.right, sum-root.val);
//     }
// }
// BFS 在层次遍历的过程中同时记录下节点的路径和
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        Queue<TreeNode> queue_node = new LinkedList<>();
        Queue<Integer> queue_count = new LinkedList<>();
        queue_node.add(root);
        queue_count.add(root.val);
        while(!queue_node.isEmpty()) {
            int size = queue_node.size();
            for(int i=0; i<size; i++) {
                TreeNode temp = queue_node.poll();
                int temp_count = queue_count.poll();
                if(temp.left == null && temp.right == null && temp_count == sum) 
                    return true; 
                if(temp.left != null) {
                    queue_node.add(temp.left);
                    queue_count.add(temp_count+temp.left.val);
                }
                if(temp.right != null) {
                    queue_node.add(temp.right);
                    queue_count.add(temp_count+temp.right.val);
                }
            }
        }
        return false;
    }
}

// @lc code=end

