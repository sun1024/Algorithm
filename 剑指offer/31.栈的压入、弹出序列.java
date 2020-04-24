// https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 直接用栈验证
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for(int i:pushA) {
            stack.push(i);
            while(!stack.isEmpty() && stack.peek()==popA[j]) {
                stack.pop();
                j++;
            }
        }
        for(; j<popA.length; j++) {
            if(stack.pop()!=popA[j]) return false;
        }
        return true;
    }
}