// https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 换了好几种思路做都出问题，结果才发现是substring(start, end)方法理解错了，原来是左开右闭[start, end)的。。。
// 这里直接从后往前以单词为单位进行反转，没必要用stack入栈再出栈了
public class Solution {
    public String ReverseSentence(String str) {
        StringBuilder res = new StringBuilder();
        int right = str.length();
        for(int i=str.length()-1; i>=0; i--) {
            if(str.charAt(i) == ' ') {
                res.append(str.substring(i+1, right));
                res.append(' ');
                right = i;
            }
        }
        res.append(str.substring(0, right));
        return res.toString();
    }
}