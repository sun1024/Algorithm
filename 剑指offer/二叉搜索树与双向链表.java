// https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&&tqId=11179&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 中序遍历，同时改变指向关系即可
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
public class Solution {
    TreeNode pre, head; // 全局变量，记录中序递归时的前一个节点和头节点
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder(TreeNode root) {
        if(root == null) return;
        // 左中右
        inOrder(root.left);

        if(pre == null) head = root; // 没有设置pre，则当前是头节点，即最左节点
        else pre.right = root; // 有pre，就互相指
        root.left = pre;
        pre = root; // 不断更新pre

        inOrder(root.right);
    }
}