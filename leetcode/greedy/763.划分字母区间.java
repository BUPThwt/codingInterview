import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] words = new int[26];
        for(int i = 0; i < S.length(); i++){
            words[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        List<Integer> result = new ArrayList<>();
        int max = 0;
        for(int i = 0; i < S.length(); i++){
            max = Math.max(max, words[S.charAt(i) - 'a']);
            if(max == i){
                result.add(i - start + 1);
                start = i + 1;
            }
        }
        return result;

    }
}
// @lc code=end

