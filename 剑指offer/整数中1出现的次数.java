// https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tqId=11184&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 暴力居然能过
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;
        for(int i=1; i<=n; i++) {
            int temp = i;
            while(temp>=1) {
                if(temp%10 == 1) res++;
                temp = temp/10;
            }
        }
        return res;
    }
}
// 找规律，题解都看半天ORZ
// 从个位开始分析:4567
// 个位每循环一次0-9就多10，出现一次1 （1）,1-4560的个位要循环456次，有456个1，4561-4567个位经历1-7出现一次1 => 456*1 + 1
// 十位每循环一次0-9就多100，出现10次1 （10,11,12...19），1-4500的十位要循环45次，有45*10个1，4501-4567十位经历0-6出现一次1*10 => 45*10 + 10*1
// 百位每循环一次0-9就多1000，出现100次1 （100,101...199），1-4000的百位要循环4次，有4*100个1，4001-4567百位经历0-5出现一次1*100 => 4*100 + 100*1
// 千位每循环一次0-9就多10000，出现1000次1（1000,1001...1999）但是这里只从0-4，所以一次没循环完 => 0*1000 + 1000
// 例子不是很准确，但是看得出来区别在于对于每一位上的数字n进行判断:
// 当前位<1就不用加多余的1，当前位>=1就加上0-n产生的1，但是这里还要分开讨论
// 当前位n=1，则当前位1出现的次数取决于右边的数，对于1-14来说十位上1出现了4+1=5次(10,11,12,13,14),对于1-167来说百位上1出现了68次(100-167)
// 当前位n>1，说明当前位为1时右边取任意值都行，1-20的十位出现了10次1(10-11)，1-400的百位出现了100次1(100-199)
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<1) return 0;
        int res = 0; 
        int base = 1; // 对于个位,经历一次0-9就有1个1 十位10个1 百位100个1 => base *= 10;
        int round = n; // 不直接使用n,因为n后面还有用
        while(round>0) {
            int cur = round % 10; // 当前位
            round = round / 10; // 当前位左边组成的数
            res += round*base;
            if(cur > 1) {
                res += base;
            } else if(cur == 1) {
                // 多出来了当前位右边的数+1个1 
                // 计算右边的数需要用到n%base
                res += (n % base) + 1;
            } // cur==0就不加了
            base *= 10;
        }
        return res;
    }
}