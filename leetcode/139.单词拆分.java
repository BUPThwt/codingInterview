import java.util.List;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < wordDict.size(); j++){
                if(i >= wordDict.get(j).length()){
                    String str = s.substring(i - wordDict.get(j).length(), i);
                    if(dp[i - wordDict.get(j).length()] && str.equals(wordDict.get(j))){
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    // public boolean wordBreak(String s, List<String> worList){
    //     boolean[] dp = new boolean[s.length() + 1];
    //     dp[0] = true;
    //     for(int i = 1; i <= s.length(); i++){
    //         for(int j = 0; j <= i; j++){
    //             String str = s.substring(i - j, i);
    //             if(dp[i - j] && worList.contains(str)){
    //                 dp[i] = true;
    //             }
    //         }
    //     }
    //     return dp[s.length()];
    // }
}
// @lc code=end

