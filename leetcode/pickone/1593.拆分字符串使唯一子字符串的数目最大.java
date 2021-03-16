import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1593 lang=java
 *
 * [1593] 拆分字符串使唯一子字符串的数目最大
 */

// @lc code=start
class Solution {
    int ans;
    Set<String> set;
    public int maxUniqueSplit(String s) {
        set = new HashSet<>();
        backTracing(s, 0);
        return ans;
    }

    private void backTracing(String s, int start){
        // 终止，剪枝条件比较难想
        if(set.size() + s.length() - start <= ans){
            return;
        }
        if(start == s.length()){
            ans = Math.max(ans, set.size());
            return;
        }
        for(int i = start; i < s.length(); i++){
            String temp = s.substring(start, i + 1);
            if(!set.contains(temp)){
                set.add(temp);
                backTracing(s, i + 1);
                set.remove(temp);
            }
        }
    }
        
}
// @lc code=end

