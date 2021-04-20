/*
 * @lc app=leetcode.cn id=984 lang=java
 *
 * [984] 不含 AAA 或 BBB 的字符串
 */

// @lc code=start
class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        // A,B都大于0
        while(A > 0 && B > 0){
            // 追求最终A= B   类似于快慢指针。
            if(A > B){
                sb.append("aab");
                A -= 2;
                B--;
            }else if(A == B){
                sb.append("ab");
                A--;
                B--;
            }else if(A < B){
                sb.append("bba");
                A--;
                B -= 2;
            }
        }
        // 只有A
        while(A > 0){
            sb.append("a");
            A--;
        }
        // 只有B
        while(B > 0){
            sb.append("b");
            B--;
        }
        return sb.toString();
    }
}
// @lc code=end

