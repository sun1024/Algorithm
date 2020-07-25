/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一个树的子树
 *
 * https://leetcode-cn.com/problems/subtree-of-another-tree/description/
 *
 * algorithms
 * Easy (46.81%)
 * Likes:    319
 * Dislikes: 0
 * Total Accepted:    45K
 * Total Submissions: 95.9K
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
 *
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s
 * 也可以看做它自身的一棵子树。
 * 
 * 示例 1:
 * 给定的树 s:
 * 
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 给定的树 t：
 * 
 * 
 * ⁠  4 
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * 
 * 示例 2:
 * 给定的树 s：
 * 
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * ⁠   /
 * ⁠  0
 * 
 * 
 * 给定的树 t：
 * 
 * 
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 返回 false。
 * 
 */

// @lc code=start
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
// 剑指offer: 树的子结构 再敲一遍
class Solution {
    boolean has = false;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null) return false;
        // 遍历
        preOrder(s, t);
        return has;
    }
    private void preOrder(TreeNode s, TreeNode t) {
        if(s == null || has) return;
        has = judge(s, t);
        if(s.left != null) preOrder(s.left, t);
        if(s.right != null) preOrder(s.right, t);
    }
    private boolean judge(TreeNode s, TreeNode t) {
        // 和子结构不同的是子树必须完全匹配
        if(s == null) {
            if(t == null) return true; // 都为null，说明全部匹配
            return false; 
        }
        // 有一方不为null，则不匹配
        if(t == null) return false;
        // 都不为null，则判断是否相等
        if(s.val != t.val) return false;
        // 相等再接着往下判断
        return judge(s.left, t.left) && judge(s.right, t.right);
    }
}
// @lc code=end

