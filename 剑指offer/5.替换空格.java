// https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// StringBuffer api
// public class Solution {
//     public String replaceSpace(StringBuffer str) {
//     	for(int i=0; i<str.length(); i++) {
//             if((int)str.charAt(i) == 32) {
//                 str.deleteCharAt(i);
//                 str.insert(i, "%20");
//             }
//         }
//         return str.toString();
//     }
// }
// 双指针
public class Solution {
    public String replaceSpace(StringBuffer str) {
        // 计算str中的空格数
        int blankCount = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == ' ') blankCount++;
        }
        if(blankCount == 0) return str.toString();
        // 得到替换后的str长度
        int originalLength = str.length();
        int newLength = str.length() + blankCount*2;
        str.setLength(newLength);
        // 双指针 从后往前 O(n)
        int p1 = originalLength - 1;
        int p2 = newLength - 1;
        while(p1>=0) {
            if(str.charAt(p1) != ' ')  str.setCharAt(p2--, str.charAt(p1--));
            else {
                str.setCharAt(p2, '0');
                str.setCharAt(p2-1, '2');
                str.setCharAt(p2-2, '%');
                p1--;
                p2-=3;
            }
        }
        return str.toString();
    }
}