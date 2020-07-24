// https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&&tqId=11170&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
// 遍历A节点，分别于B节点对比是否结构一样
public class Solution {
    boolean has = false;
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        // 先序遍历
        preOrder(root1, root2);
        return has;
    }
    private void preOrder(TreeNode root1, TreeNode root2) {
        // 退出条件，root1为叶子或者已经找到存在子树相等
        if(root1 == null || has) return;
        // 将遍历到的每个子树与root2对比
        has = judge(root1, root2);
        if(root1.left != null) preOrder(root1.left, root2);
        if(root1.right != null) preOrder(root1.right, root2);
    }
    private boolean judge(TreeNode root1, TreeNode root2) {
        // root2比完了val都相等则到这一条分支都相等
        if(root2 == null) return true;
        // root1比完了但是root2没比完，则肯定不是子结构
        if(root1 == null) return false;
        if(root1.val != root2.val) return false;
        // 这里将左右子树是否为null放在开始判断了，一定要使用&&，所有分支都相等才是完全相等
        return judge(root1.left, root2.left) && judge(root1.right, root2.right);
    }
}