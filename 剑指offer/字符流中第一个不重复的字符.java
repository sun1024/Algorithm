// https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// hashmap 记录每个字符出现的次数，同时记录整个字符串，重新遍历一遍字符串，找到第一个在hashmap里出现一次的字符即为所求
import java.util.HashMap;
public class Solution {
    StringBuilder sb = new StringBuilder();
    HashMap<Character, Integer> map = new HashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        sb.append(ch);
        if(map.containsKey(ch)) {
            map.put(ch, map.get(ch)+1);
        } else {
            map.put(ch, 1);
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] string = sb.toString().toCharArray();
        for(char ch:string) {
            if(map.get(ch) == 1) return ch;
        }
        return '#';
    }
}