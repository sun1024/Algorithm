// https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11192&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 平衡二叉树：只考虑平衡性不考虑排序
// 平衡：左右子树高度差不超过1，同时左右子树也平衡. 本身就是一个递归的定义 所以就用递归做
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(Math.abs(getDep(root.left)-getDep(root.right)) > 1) {
            return false;
        } else // 平衡的递归性
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    // 判断树高
    private int getDep(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max(getDep(node.left), getDep(node.right));
    }
}