import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (72.05%)
 * Likes:    471
 * Dislikes: 0
 * Total Accepted:    131.4K
 * Total Submissions: 181.6K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最大深度 3 。
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
// 递归
// class Solution {
//     public int maxDepth(TreeNode root) {
//         if(root == null) return 0; // 递归结束条件
//         return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
//     }
// }
// BFS层次遍历
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0; 
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size(); //每层的元素总数
            for(int i=0; i<size; i++) {
                TreeNode node = queue.remove(); //先进先出 保证每一个元素的顺序
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return level;
    }
}
// @lc code=end

