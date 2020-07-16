// https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&&tqId=11206&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 就不去看什么状态机了，直接按逻辑解
public class Solution {
    public boolean isNumeric(char[] str) {
        if(str.length == 0) return false;
        // 主要判断是否有数字、点和E/e,
        // 还有加减号的判断比较简单 不用另设变量了
        boolean hasNum = false;
        boolean hasDot = false;
        boolean hasE = false;

        for(int i=0; i<str.length; i++) {
            if(str[i]>='0' && str[i]<='9') {
                // 注意加引号
                hasNum = true;
            } else if(str[i] == '.') {
                // .之前不能有.
                // .不能在E/e之后出现
                // .不能出现在末尾 （这个好像不影响测试用例，但是'233.'明显不能算数字）
                if(hasDot || hasE || i==str.length-1) {
                    return false;
                }
                hasDot = true;
            } else if(str[i] == 'E' || str[i] == 'e') {
                // E之前必须有数字
                // E也不能出现在末尾
                if(!hasNum || i==str.length-1)  {
                    return false;
                }
                hasE = true;
                // E之后的数字需要重新判断
                hasNum = false;
            } else if(str[i] == '+' || str[i] == '-') {
                // +-号只能在开头，或者在E/e后面   +12 3e-1
                if(i!=0 && str[i-1] != 'E' && str[i-1] != 'e') {
                    return false;
                }
            } else { // 其他情况直接不可能是数字
                return false;
            }
        }
        return hasNum;
    }
}