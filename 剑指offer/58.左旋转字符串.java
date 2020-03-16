// https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11196&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 分成两段再拼起来 直接用api就有点欺负人了
import java.util.*;
public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str.length() == 0 && n > str.length()) return "";
        StringBuffer sb = new StringBuffer();
        Queue<Character> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            queue.add(str.charAt(i));
        }
        for(int i=n; i<str.length(); i++) {
            sb.append(str.charAt(i));
        }
        while(!queue.isEmpty()) {
            sb.append(queue.remove());
        }
        return sb.toString();
    }
}