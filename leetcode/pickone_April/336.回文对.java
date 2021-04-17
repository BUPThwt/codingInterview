import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=336 lang=java
 *
 * [336] 回文对
 */

// @lc code=start
class Solution {

    // 超时
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if(i != j && isPalindrome((words[i] + words[j]).toCharArray())){
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(char[] chars){
        if(chars.length < 2){
            return true;
        }
        int left = 0;
        int right = chars.length - 1;
        while(left < right){
            if(chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end

