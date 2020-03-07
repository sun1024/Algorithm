// https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
// 递归
public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        return compare(pRoot.left, pRoot.right);
    }
    private boolean compare(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val == right.val) {
            return compare(left.left, right.right) && compare(left.right, right.left);
        } else return false;
    }
}
// 非递归 层次遍历 从两边往中间比 和leetcode一样就不写了