// https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&&tqId=11180&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 发现自己想的方法和题解不一样，处理起来还比较麻烦，但也算是子问题分解，索性就不去记题解了
// 将str分为第一个first和剩下的所有others，那么str全排列就是把first分别插到others全排列的空隙中的所有组合，
// 递归到最小就是把第一个往第二个的前后插 eg:[ab] => a b => ab ba
// 主要的点在于：
// 字符重复的处理：会造成最后的排列也重复，题解的方法是用set处理，但是我这里用set不方便转换，就直接判断list.contains了
// 字典序排列：leetcode上没这个要求，所以没看到较好的方法，就直接用Collections.sort()排一下了
// 时间复杂度有点高，但是感觉后面几个考到的概率不大了，还是把基础的写好吧
// import java.util.*;
// public class Solution {
//     public ArrayList<String> Permutation(String str) {
//         ArrayList<String> res = new ArrayList<>();
//         // 初始条件
//         if(str.length() == 0) return res;
//         if(str.length() == 1) {
//             res.add(str);
//             return res;
//         }
//         // 区分first和others
//         char first = str.charAt(0);
//         int len = str.length()-1;
//         StringBuilder sb = new StringBuilder();
//         for(int i=1; i<str.length(); i++) {
//             sb.append(str.charAt(i));
//         }
//         // 递归的获取others的全排列
//         ArrayList<String> temp = new ArrayList<>();
//         temp = Permutation(sb.toString());
//         // 将first插入others的全排列
//         for(int i=0; i<temp.size(); i++) {
//             for(int j=0; j<=len; j++) {
//                 String temp_str = temp.get(i);
//                 StringBuilder temp_sb = toSb(temp_str);
//                 temp_sb.insert(j, first);
//                 // 避免重复
//                 if(!res.contains(temp_sb.toString()))
//                     res.add(temp_sb.toString());
//             }
//         }
//         Collections.sort(res);
//         return res;
//     }
//     private StringBuilder toSb(String str) {
//         StringBuilder sb = new StringBuilder();
//         for(int i=0; i<str.length(); i++) {
//             sb.append(str.charAt(i));
//         }
//         return sb;
//     }
// }
// dfs回溯 使用HashSet判断是否重复
// 固定一个，后面的递归式交换
// eg: abc acb  bac bca  cab cba
import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        // 转成char[] 不然没法改字符
        char[] chs = str.toCharArray();
        int len = chs.length;
        if(len == 0) return res;
        if(len == 1) {
            res.add(str);
            return res;
        }
        dfs(chs, 0, len, res);
        // 直接排成字典序
        Collections.sort(res);
        return res;
    }
    private void dfs(char[] chs, int start, int len, ArrayList<String> res) {
        // start跑到最后了 说明交换完了
        if(start == len-1) {
            // 这里不知道为什么chs.toString()不对
            String temp = String.valueOf(chs);
            // 直接判断是否存在，不太可取
            // if(!res.contains(temp))
            res.add(temp);
            return;
        }
        // 使用HashSet判断是否有重复
        HashSet<Character> set = new HashSet<>();
        for(int i=start; i<len; i++) {
            if(set.contains(chs[i])) continue;
            set.add(chs[i]);
            // 固定第一个，让所有字符都可以成为第一个
            swap(chs, start, i);
            // 第一个以后再进行交换
            dfs(chs, start+1, len, res);
            // 还原chs
            swap(chs, i, start);
        }
    }
    private void swap(char[] chs, int a, int b) {
        char temp = chs[a];
        chs[a] = chs[b];
        chs[b] = temp;
    }
}