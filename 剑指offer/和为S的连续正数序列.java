// https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&&tqId=11194&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 稍微写几个就能找到规律：
// 11/2=5 余1 ---5,6
// 15/3=5 余0 ---4,5,6
// 18/4=4 余2 -- 3,4,5,6
// 20/5=4 余0 -- 2,3,4,5,6
// 27/6=4 余3 -- 2,3,4,5,6,7
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i= sum/2+1; i>1; i--) {
            if(i%2 == 1) { // 奇数
                if(sum%i == 0) {
                    if(sum/i-i/2 < 1) continue;
                    ArrayList<Integer> temp = new ArrayList<>();
                    for(int j=sum/i-i/2; j<=sum/i+i/2; j++) {
                        temp.add(j);
                    }
                    res.add(temp);
                }
            } else { // 偶数
                if(sum%i == i/2) {
                    if(sum/i-i/2+1 < 1) continue;
                    ArrayList<Integer> temp = new ArrayList<>();
                    for(int j=sum/i-i/2+1; j<=sum/i+i/2; j++) {
                        temp.add(j);
                    }
                    res.add(temp);
                }
            }
        }
        return res;
    }
}