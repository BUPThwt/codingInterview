import jdk.internal.vm.compiler.word.WordBase;
import jdk.javadoc.internal.doclets.toolkit.WorkArounds;

/*
 * @lc app=leetcode.cn id=1737 lang=java
 *
 * [1737] 满足三条件之一需改变的最少字符数
 */

// @lc code=start
class Solution {
    public int minCharacters(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        int[] worda = new int[26];
        int[] wordb = new int[26];
        for(char c : a.toCharArray()){
            worda[c - 'a']++;
        }
        for(char c : b.toCharArray()){
            wordb[c - 'a']++;
        }

        // 采用前缀策略，统计包括当前值的之前的字母的数量
        int[] preA = new int[26];
        int[] preB = new int[26];
        for(int i = 0; i < 26; i++){
            preA[i] = i == 0 ? worda[0] : preA[i - 1] + worda[i];
        }
        for(int i = 0; i < 26; i++){
            preB[i] = i == 0 ? wordb[0] : preB[i - 1] + wordb[i];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            if(i != 25){
                ans = Math.min(ans, preA[i] + blen - preB[i]);
                ans = Math.min(ans, preB[i] + alen - preA[i]);
            }
            int aNotEqual = alen - worda[i];
            int bNotEqual = blen - wordb[i];
            ans = Math.min(ans, aNotEqual + bNotEqual);
        }
        return ans;
    }
}
// @lc code=end

