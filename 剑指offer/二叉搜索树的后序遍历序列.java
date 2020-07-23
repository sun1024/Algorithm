// https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&&tqId=11176&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 从后序遍历的性质出发，左右根，最后一个肯定是根
// 二叉搜索树：左<根<右 递归的判断是否满足就行
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int len = sequence.length;
        if(len == 0) return false;
        if(len == 1) return true;
        return verify(sequence, 0, len-1);
    }
    private boolean verify(int[] sequence, int left, int right) {
        if(left >= right) return true; // 子树找完了还是满足条件就为true
        int i = left; // 遍历左子树
        while(i<=right && sequence[i] < sequence[right]) {
            i++;
        }
        int j = i; // 遍历右子树 
        while(j<=right) {
            // 右子树不能小于根节点
            if(sequence[j] < sequence[right]) return false;
            j++;
        }
        // 注意边界 左右根
        return verify(sequence, left, i-1) && verify(sequence, i, right-1);
    }
}